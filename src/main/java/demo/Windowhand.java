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


public class Windowhand {
   
    ChromeDriver driver;

    public Windowhand(){
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
    
    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) throws IOException {

        String homepath = "src\\main\\java\\demo\\screenshots\\aas.png";
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(homepath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public void testCase09() throws InterruptedException, IOException {
        // navigate to url
        // https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        // click on the try it button Using Locator "XPath" //button[text()="Try it"]
        // check the windows handles
        // take a screen by screen method to the new window

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        Thread.sleep(2000);
        takeScreenshot(driver, "starttestcase", "testcase08");
        driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/button")).click();
        takeScreenshot(driver, "starttestcase", "testcase08");
        String parentwindow = driver.getWindowHandle();
        Thread.sleep(3000);

        Set<String> childwindows = driver.getWindowHandles();

        for (String childwindow : childwindows) {
            if (!childwindow.equals(parentwindow)) {
                System.out.println(driver.switchTo().window(childwindow).getTitle());
                System.out.println(driver.switchTo().window(childwindow).getCurrentUrl());
            }
        }
        System.out.println(driver.switchTo().window(parentwindow).getTitle());
    }

    
}
