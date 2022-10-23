package pages;


import library.PageBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

@Slf4j
  public class HeaderPage extends PageBase {
//  @FindBy(xpath = "//div[@class='menu']")
//  WebElement mbMenubar;
//  String xpMenuBar = "//div[@class='menu']";
//  String xpMenuItem = ".//*[text()='XXX']";
//
//  public HeaderPage(WebDriver driver) {
//    super(driver);
//  }
//
//  public void selectMenu(String menu) {
//    List<String> menuItems = Arrays.asList(menu.split("\\|"));
//    for (String item : menuItems) {
//      clickMenu(item);
//    }
//  }
//
//
//  private void clickMenu(String item) {
//    WebElement weMenuItem = findElement(By.xpath(xpMenuBar), By.xpath(xpMenuItem.replace("XXX", item)));
//    click(weMenuItem);
//  }
//
//  public boolean isDisplayed() {
//    return super.isDisplayed(mbMenubar);
//  }
//}
    private String lblWelcome = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a";
//  Admin
    private String mnuItem = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]";
  //job
    private String idMenu = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[4]/a";
    //job category;
    private String mnuItem1 ="//*[@class='oxd-topbar-body-nav']//descendant::*[contains(text(),'XXX')]";
    public HeaderPage(WebDriver driver) {
      super(driver);
    }

  public void assertWelcomeMessage(){
    Assert.assertTrue(isElementVisible(By.xpath(lblWelcome)),"Login not successful");
  }
  public void selectMenu(String menu){//Admin|Job|Job Title
    List<String> menuItems = Arrays.asList(menu.split("\\|"));
    Dimension dimension = driver.manage().window().getSize();
    log.debug("Window size height :{}, width :{}", dimension.height,dimension.width);

    int menuLevel=0;
    for (String item:menuItems){

      menuLevel++;
      if(menuLevel==1) {
        By byMenu = By.xpath(mnuItem.replace("XXX", item));
        Rectangle rectangle = getRect(byMenu);
        log.debug("Menu item coordinates- X1:{}, Y1:{}, X2 :{}, Y2 :{}", rectangle.getX(), rectangle.getY(),
          rectangle.getX() + rectangle.getWidth(), rectangle.getY() + rectangle.getHeight());

        mouseHover(byMenu);

        sleep(MENU_SELECTION_DELAY);
        click(byMenu);
      }
      else {
        By byMenu1 = By.xpath(mnuItem1.replace("XXX", item));
        Rectangle rectangle1 = getRect(byMenu1);
        log.debug("Menu item coordinates- X1:{}, Y1:{}, X2 :{}, Y2 :{}", rectangle1.getX(), rectangle1.getY(),
          rectangle1.getX() + rectangle1.getWidth(), rectangle1.getY() + rectangle1.getHeight());

        mouseHover(byMenu1);

        sleep(MENU_SELECTION_DELAY);
        click(byMenu1);
      }

    }

  }
  public boolean isMenuVisible(){
    return isElementVisible(By.className(idMenu));
  }

}


//    public void assertWelcomeMessage(){
//      Assert.assertTrue(isElementVisible(By.xpath(lblWelcome)),"Login not successful");
//    }
//    public void selectMenu(String menu){//Admin|Job|Job Title
//      List<String> menuItems = Arrays.asList(menu.split("\\|"));
//      Dimension dimension = driver.manage().window().getSize();
//      log.debug("Window size height :{}, width :{}", dimension.height,dimension.width);
//      int menuLevel=0;
//      for (String item:menuItems){
//        menuLevel++;
//        By byMenu = By.xpath(mnuItem.replace("XXX",item));
//        Rectangle rectangle = getRect(byMenu);
//        log.debug("Menu item coordinates- X1:{}, Y1:{}, X2 :{}, Y2 :{}", rectangle.getX(),rectangle.getY(),
//          rectangle.getX()+rectangle.getWidth(), rectangle.getY()+rectangle.getHeight());
//
//        mouseHover(byMenu);
//        sleep(MENU_SELECTION_DELAY);
//        click(byMenu);
//        if(menuLevel==1) {
//          int yOffset = rectangle.getY() + rectangle.height+10;
//          if(yOffset>dimension.height){
//            yOffset = dimension.height-1;
//          }
//          mouseMove(rectangle.getX(), yOffset);
//        }
//      }
//
//    }
//    public boolean isMenuVisible(){
//      return isElementVisible(By.xpath(idMenu));
//    }
//}
