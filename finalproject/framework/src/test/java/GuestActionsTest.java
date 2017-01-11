import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by shukal on 16.12.16.
 */
public class GuestActionsTest {
    private WebDriver driver;
    private String currentDir = System.getProperty("user.dir");

    @BeforeMethod
    public void setUp() {
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
        WebElement content = driver.findElement(By.cssSelector("#div-comment-5 > div:nth-child(2)"));
        Assert.assertTrue(content.getText().contains("Ho-ho-ho!!!"));
    }

    @Test
    public void doSearch() {
        driver.get("http://localhost:8888/");
        driver.findElement(By.id("search-2"));
        driver.findElement(By.className("search-field")).sendKeys("Hello");
        driver.findElement(By.className("search-submit")).click();
        WebElement results = driver.findElement(By.cssSelector("#post-52 > header:nth-child(1) > h2:nth-child(1) " +
                "> a:nth-child(1)"));
        Assert.assertTrue(results.getText().contains("Hello"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
