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


public class Amazon {
    ChromeDriver driver;

    public Amazon(){
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
 
    
    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

        // Launch Chrome https://www.google.com/
        // find search box Using Locator "Name" //textarea[@name='q']
        // enter input keys "amazon.in Using Locator "Name" //textarea[@name='q']
        // click on google search button Using Locator "XPath" //textarea[@name='q']
        // validate amazon in search result Using Locator "XPath"
        // //span[text()='Amazon.in']
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("amazon");
        driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]")).click();
        WebElement value = driver.findElement(By.xpath("//span[text()='Amazon.in']"));
        System.out.println(value.isDisplayed());

    }

}
