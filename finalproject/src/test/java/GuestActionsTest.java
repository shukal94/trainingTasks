import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by shukal on 16.12.16.
 */
public class GuestActionsTest {
    private WebDriver driver;
    private final String PATH = "/home/shukal/IdeaProjects/finalproject/credentials.xml";

    @BeforeMethod
    public void setUp() {
        String currentDir = System.getProperty("user.dir");
        String marionetteDriverLocation = currentDir + "/geckodriver";
        System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        driver = new MarionetteDriver();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8888/");
    }

    @Test
    public void writeComment() {
        driver.get("http://localhost:8888/?p=1");
        driver.findElement(By.id("comment")).sendKeys("Ho-ho-ho!!!");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void doSearch() {
        driver.get("http://localhost:8888/");
        driver.findElement(By.id("search-2"));
        driver.findElement(By.className("search-field")).sendKeys("Hello");
        driver.findElement(By.className("search-submit")).click();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
