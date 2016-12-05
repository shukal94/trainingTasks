import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by shukal on 4.12.16.
 */
public class SiteTester {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        String currentDir = System.getProperty("user.dir");
        String marionetteDriverLocation = currentDir + "/geckodriver";
        System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        driver = new MarionetteDriver();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8888/");
    }

    @Test
    public void testEnterLoginPositive() {
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("shukal");
        driver.findElement(By.id("user_pass")).sendKeys("1");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void testLoginPositive() {
        driver.get("http://localhost:8888/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("shukal");
        driver.findElement(By.id("user_pass")).sendKeys("1");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void testPresenceOfLinkNamePositive() {
        driver.get("http://localhost:8888/");
        driver.findElement(By.linkText("site-title")).click();
    }

    @Test
    public void testPresenceOfLinkHrefPositive() {
        driver.get("http://localhost:8888/");
        driver.findElement(By.xpath("site-title")).click();
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
