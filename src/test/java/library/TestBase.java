package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

  protected WebDriver driver;
  protected String browser;
  protected String baseUrl = "https://opensource-demo.orangehrmlive.com";

  @BeforeSuite
  public void beforeSuite(){
    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeTest
  public void beforeTest(){


  }
  //    @Parameters({"browser"})
//    @BeforeMethod
//    public void beforeMethod(String browser){
//        this.browser = browser;
//        System.out.println("Browser : "+ browser);
//        getDriver();
//    }
  @BeforeMethod
  public void beforeMethod(){
    this.browser = "chrome";
    System.out.println("Browser : "+ browser);
    getDriver();
  }


  private void getDriver() {
    if (browser == null) browser = "chrome";
    switch (browser.toLowerCase()) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      case "safari":
        driver = new SafariDriver();
        break;
      default:
        driver = new ChromeDriver();
        break;
    }
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }

//  @AfterMethod
//  public void afterMethod(){
//    driver.quit();
//  }
}


