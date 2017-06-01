import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLSelectElement;

import javax.xml.ws.Action;
import java.awt.*;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by otaran on 23.05.2017.
 */
public class MyFirstTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        final File file = new File(PropertyLoader.loadProperty("path.webDriver"));
        System.setProperty(PropertyLoader.loadProperty("webDriver"), file.getAbsolutePath());
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.navigate().to("http://juliemr.github.io/protractor-demo/");
        Assert.assertEquals(driver.getCurrentUrl(), "http://juliemr.github.io/protractor-demo/", "NOT OK!");
    }

    @Test
    public void test2() {
        WebElement first = driver.findElement(By.xpath("//input[@ng-model='first']"));
        WebElement second = driver.findElement(By.xpath("//input[@ng-model='second']"));
        first.sendKeys("1");
        second.sendKeys("1");

        Assert.assertEquals(first.getAttribute("value"), "1", "not 1");
        Assert.assertEquals(second.getAttribute("value"), "1", "not 1");
    }

    @Test
    public void test3_dropdown() {

        WebElement dropdown = driver.findElement(By.xpath(".//select//option[1]"));
        Assert.assertEquals(dropdown.getText(), "+");

    }

    @Test
    public void test4_clickGo() {

        WebElement clickGo = driver.findElement(By.id("gobutton"));
        clickGo.click();

    }

    @Test
    public void test5_getResult() throws Exception {

      WebDriverWait wait = new WebDriverWait (driver, 5);
      Thread.sleep(2000);
      WebElement getResult =  driver.findElement(By.xpath("//h2"));

        Assert.assertEquals(getResult.getText(), "2");

    }


}