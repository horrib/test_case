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

public class Movieratings {

    ChromeDriver driver;

    public Movieratings(){
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
    public void testCase10() throws InterruptedException {
        driver.get(" https://www.imdb.com/chart/top");

        WebElement rating = driver.findElement(By.xpath("//span[@aria-label='IMDb rating: 9.3']"));
        System.out.println("rating of the movie" + rating.getText());
        Thread.sleep(3000);

        List<WebElement> elem = driver.findElements(By.xpath("//h3[@class='ipc-title__text']"));
        System.out.println("total movies count" + elem.size());
        for (int i = 0; i < elem.size(); i++) {
            String str = elem.get(i).getText();
            System.out.println("total names of the movies" + str);
        }
        Thread.sleep(3000);
        WebElement recentmovie = driver.findElement(By.xpath("//h3[text()='44. Oppenheimer']"));
        System.out.println("recent movie" + recentmovie.getText());
        Thread.sleep(3000);
        WebElement oldestmovie = driver.findElement(By.xpath("//h3[text()='131. The Kid']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", oldestmovie);
        Thread.sleep(3000);
        System.out.println("oldestmovie is" + oldestmovie.getText());

    }
}


 

