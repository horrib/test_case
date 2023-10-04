package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Bookshow {
    ChromeDriver driver;

    public Bookshow(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    
    public void testCase04() throws InterruptedException {
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);
        List<WebElement> totalimageurls = driver.findElements(By.tagName("img"));
        for (WebElement totalimageurl : totalimageurls) {
            System.out.println(totalimageurl.getAttribute("src"));
        }
        Thread.sleep(5000);
        List<WebElement> movienames = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 zDfcI']"));
       
        Thread.sleep(3000);
        System.out.println(movienames.size());

        for (WebElement webElement : movienames) {
            String name = webElement.getText();
            System.out.println(name);
        }
        Thread.sleep(5000);

        List<WebElement> totallanguages = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 veMGd']"));

        System.out.println(totallanguages.size());

        for (WebElement webElement : totallanguages) {
            String names = webElement.getText();
            System.out.println(names);
        }
        // Thread.sleep(5000);

    }
}
