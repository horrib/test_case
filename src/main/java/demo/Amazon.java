public class Amazon {


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
