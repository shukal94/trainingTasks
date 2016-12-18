import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by shukal on 16.12.16.
 */
public class AdminActionsTest {
    private WebDriver driver;
    private final String CORRECT = "correct";
    private final String USERNAME = "username";
    private final String PASS = "password";
    private String currentDir = System.getProperty("user.dir");
    private final String PATH = currentDir + "/credentials.xml";

    @BeforeMethod
    public void setUp() {
        String marionetteDriverLocation = currentDir + "/geckodriver";
        System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        driver = new MarionetteDriver();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8888/wp-login.php/");
    }

    @DataProvider(name = "Correct login")
    public Object[][] correctLogin() throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(CORRECT);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(USERNAME).getNodeValue(),
                    map.getNamedItem(PASS).getNodeValue(),
            };
        }
        return result;
    }

    @Test(dataProvider = "Correct login")
    public void writePostPositive(String username, String pass) throws Exception {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.id("menu-pages")).click();
        driver.get("http://localhost:8888/wp-admin/post-new.php");
        driver.findElement(By.id("title")).sendKeys("HelloWorld2");
        driver.findElement(By.id("publish")).click();
        driver.get("http://localhost:8888/?p=44");
        WebElement post = driver.findElement(By.cssSelector(".entry-title"));
        Assert.assertTrue(post.getText().contains("HelloWorld2"));
    }

    @Test(dataProvider = "Correct login")
    public void writeComment(String username, String pass) {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        driver.get("http://localhost:8888/?p=1");
        driver.findElement(By.id("comment")).sendKeys("fdvdfg");
        driver.findElement(By.id("submit")).click();
        WebElement content = driver.findElement(By.cssSelector("#div-comment-6 > div:nth-child(2) > p:nth-child(1)"));
        Assert.assertTrue(content.getText().contains("fdvdfg"));
    }

    @Test(dataProvider = "Correct login")
    public void doSearch(String username, String pass) {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        driver.findElement(By.id("search-2"));
        driver.findElement(By.className("search-field")).sendKeys("Hello");
        driver.findElement(By.className("search-submit")).click();
        WebElement results = driver.findElement(By.cssSelector("#post-27 > header:nth-child(1) > h2:nth-child(1)"));
        Assert.assertTrue(results.getText().contains("Hello"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
