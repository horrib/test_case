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


public class Linkedlnpost {
    ChromeDriver driver;

    public Linkedlnpost(){
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

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        
        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.id("session_key")).sendKeys("ashishnandal27756@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Nandal@123#");
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        Thread.sleep(4000);
        WebElement postviewed = driver.findElement(By.xpath(
                "(//div[@class=\"feed-identity-widget-item__icon-stat t-12 t-black t-bold flex-1\"]/span/strong)[1]"));
        System.out.println(postviewed.getText());

        driver.findElement(By.id("ember27")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='artdeco-modal__content p0 ember-view']/div/div[2]/div[1]/div/div/div/div/div/div/div[1]"))
                .sendKeys("start posting the contect");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")));
        element.click();
    }
    
}
