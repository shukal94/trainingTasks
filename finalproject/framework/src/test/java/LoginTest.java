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
 * Created by shukal on 11.12.16.
 */
public class LoginTest {
    private WebDriver driver;
    private final String CORRECT = "correct";
    private final String INCORRECT = "incorrect";
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
    public void tryToLoginPositive(String username, String pass) throws Exception {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        WebElement message = driver.findElement(By.xpath(".//*[@id='wp-admin-bar-my-account']/a"));
        Assert.assertTrue(message.getText().contains("Howdy, " + username));
    }

    @Test(dataProvider = "Correct login")
    public void tryToLogout(String username, String pass) throws Exception {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        driver.get("http://localhost:8888/wp-login.php?action=logout&_wpnonce=ac0fd92c45");
        driver.findElement(By.linkText("log out")).click();
        WebElement message = driver.findElement(By.className("message"));
        Assert.assertTrue(message.getText().contains("You are now logged out."));
    }


    @DataProvider(name = "Incorrect login")
    public Object[][] incorrectLogin() throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(INCORRECT);
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

    @Test(dataProvider = "Incorrect login")
    public void tryToLoginNegative(String username, String pass) throws Exception {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        driver.findElement(By.id("wp-submit")).click();
        WebElement message = driver.findElement(By.cssSelector("#login_error"));
        Assert.assertTrue(message.getText().contains("Invalid username."));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
