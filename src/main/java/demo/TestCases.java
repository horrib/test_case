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

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
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

    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> hyperlink = driver.findElementsByTagName("a");
        System.out.println(hyperlink.size());

    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        // Launch Chrome https://www.linkedin.com/home
        // search element for inpuut box and senk keys Using Locator "ID"
        // //input[@id='session_key']
        // search ellemnt for passward filed and send keys Using Locator "ID"
        // //input[@id='session_password']
        // search the sign in button anf click on sign in button Using Locator "XPath"
        // //input[@id='session_password']
        // search how many viewed your profile Using Locator "XPath"
        // //*[@id="ember588"]/div/div[2]/span/strong
        // search the start the post button and click Using Locator "ID"
        // //button[@id='ember463']
        // celick on that ans start post content Using Locator "XPath"
        // //div[@data-placeholder='What do you want to talk about?']
        // click on post button Using Locator "XPath" //button[@id='ember706']
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
        driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"))
                .sendKeys("start posting the contect");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")));
        element.click();
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", movienames);
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

    public void testCase05() throws InterruptedException {
        driver.get("https://www.google.com/");
        // Launch Chrome https://www.google.com/
        // type your name in search box Using Locator "Name" q'
        // click on search button Using Locator "XPath" (//input[@value='Google
        // Search'])[2]
        // search the your name link in which its present Using Locator "Tag Name"
        // (//input[@value='Google Search'])[2]

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("ashish");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        ;
        List<WebElement> totallinks = driver.findElements(By.tagName("a"));

        System.out.println(totallinks.size());

        for (WebElement webElement : totallinks) {
            String name = webElement.getText();
            System.out.println(name);
        }

    }

    public void testCase06() throws Exception {
        // navigate to the url https://www.linkedin.com/home
        // search th input box and sendkeys "ashishnandal27756@gmail.com Using Locator
        // "ID" session_key
        // search the password field and send keys"Nnadal@123# Using Locator "ID"
        // session_password
        // click on start the post Using Locator "ID" //button[@id="ember27"]
        // click on the start media post button Using Locator "XPath"
        // //button[@aria-describedby="artdeco-hoverable-artdeco-gen-56"]
        // click on the next button when you upload the photo Using Locator "ID"
        // //button[@id="ember366"]
        // click on the post button Using Locator "ID" //button[@id="ember419"]

        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.id("session_key")).sendKeys("ashishnandal27756@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Nandal@123#");
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath("(//button[@aria-label='Add media'])[1]")).click();

        StringSelection sel = new StringSelection("C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot (349).png");

        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.setAutoDelay(3000);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        robot.setAutoDelay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebDriverWait wat = new WebDriverWait(driver, 20);
        WebElement ele = wat.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//button[@class='share-box-footer__primary-btn artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")));
        ele.click();
        // driver.findElement(By.xpath("//*[@id='ember562']")).click();

        WebDriverWait wb = new WebDriverWait(driver, 20);
        WebElement elem = wb.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")));
        elem.click();
        // driver.findElement(By.id("ember419")).click();
    }

    public void testCase07() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(driver.findElement(By.name("frame-top")));

        driver.switchTo().frame(driver.findElement(By.name("frame-left")));
        System.out.println("text" + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        System.out.println("text" + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.name("frame-right")));
        System.out.println("text" + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));

        System.out.println("text" + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
    }

    public void testCase08() throws InterruptedException {

        // navigate to the url https://web-locators-static-site-qa.vercel.app/Alerts
        // click on the add reamrk button Using Locator "XPath"
        // //*[@id="root"]/div/div[2]/div[2]/div[3]/button
        // user alert the class to handle the pop up options
        // search the txt what we write the text in pop up Using Locator "XPath"

        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");

        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/button")).click();
        ;
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("ashish");
        alert.accept();
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/p[2]"));
        System.out.println("the text is waht you write in alert" + ele.getText());

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
        WebElement recentmovie = driver.findElement(By.xpath("//h3[text()='43. Oppenheimer']"));
        System.out.println("recent movie" + recentmovie.getText());
        Thread.sleep(3000);
        WebElement oldestmovie = driver.findElement(By.xpath("//h3[text()='131. The Kid']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", oldestmovie);
        Thread.sleep(3000);
        System.out.println("oldestmovie is" + oldestmovie.getText());

    }
}
