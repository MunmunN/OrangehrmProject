package pages;


import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobCategoryPage extends PageBase {
    private final String idBtnAdd = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button";
    private final String idTxtName = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input";
    private final String idBtnSave = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @type='submit']";

  private final String idBtnCancel = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]";
  private final String idBtnDelete = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]";

  private final String editBtn = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//following ::button[11]";
  private final String chkLanguage = "//button[@class='oxd-icon-button oxd-table-cell-action-space']//following ::button[12]";




  public JobCategoryPage(WebDriver driver) {
      super(driver);
    }
    public void createJobCategory(String nameInput){
      click(By.xpath(idBtnAdd));
      setText(By.xpath(idTxtName), nameInput);
      click(By.xpath(idBtnSave));



    }

  public void deleteJobCategory(String nameInput) {
    click(By.xpath(chkLanguage.replace("XXX", "//*[@id=\"app\"]/div[3]/div/div/div")));
    //Assert.assertFalse(click(By.xpath(chkLanguage.replace("XXX", ))),"cancel");
    click(By.xpath(idBtnDelete));
    //click(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
  }

  public void editJobCategory() {
    click(By.xpath(editBtn.replace("XXX", idTxtName)));
    setText(By.xpath(idTxtName),"ffff");
    click(By.xpath(idBtnSave));
    //Assert.assertTrue(isElementVisible(By.xpath(editBtn.replace("nurse", nameInput))), "Language is not saved");
//    click(By.xpath(lnkLanguage.replace("doctor","nurse")));
//    setText(By.xpath(idTxtName));
//    click(By.xpath(idBtnSave));
    //Assert.assertTrue(isElementVisible(By.xpath(lnkLanguage.replace("XXX", nameInput))), "Language is not saved");

  }

  }


