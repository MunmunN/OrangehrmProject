package pages;

import library.PageBase;
import okhttp3.internal.http2.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends PageBase {


//  @FindBy(name = "username")
//  WebElement txtUsername;
//  @FindBy(name = "password")
//  WebElement txtPassword;
//  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
//  WebElement btnLogin;
//  @FindBy(id = "spanMessage")
//  WebElement lblError;
//
//  public LoginPage(WebDriver driver) {
//    super(driver);
//  }
//
//  public void login(String username, String password, boolean pass, String errMsg) {
//    //This function will take care of login
//    sendkeys(txtUsername, username);
//    sendkeys(txtPassword, password);
//    click(btnLogin);
//    if (pass) {
//      HeaderPage header = new HeaderPage(driver);
//      Assert.assertTrue(header.isDisplayed(), "Login failed");
//    } else {
//      Assert.assertTrue(isDisplayed(lblError), "Error message not displayed");
//      Assert.assertEquals(getText(lblError), errMsg, "Incorrect error message");
//    }
//  }
//}

  private String name = "username";
  private String pass = "password";
  private String idLogin = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";
  private String idErrMsg = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p";

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password, boolean validCredentials, String expErrMsg) {
    setText(By.name(name), username);
    setText(By.name(pass), password);
    click(By.xpath(idLogin));

    HeaderPage headerPage = new HeaderPage(driver);
    if (validCredentials) {

      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/jobCategory");
    } else {
      Assert.assertFalse(headerPage.isMenuVisible());
      Assert.assertEquals(getText(By.xpath(idErrMsg)), expErrMsg, "Incorrect Error Message");
    }
  }
}

