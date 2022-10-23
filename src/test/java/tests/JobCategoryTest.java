package tests;

import library.PageBase;
import library.TestBase;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.JobCategoryPage;
import pages.LoginPage;
import pages.MenuOptions;

import java.util.UUID;

public class JobCategoryTest extends TestBase {

  @Test
  public void addJobCategoryTest(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.login("admin", "admin123",true,null);

    HeaderPage headerPage = new HeaderPage(driver);
    headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);

    JobCategoryPage jobCategoryPage = new JobCategoryPage(driver);
//    String nameInput="nurse";
//    jobCategoryPage.createJobCategory(nameInput);
    String uuid=UUID.randomUUID().toString();
    jobCategoryPage.createJobCategory("nurse");
  }

  @Test
  public void deleteJobCategoryTest(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
    JobCategoryPage jobCategoryPage = new JobCategoryPage(driver);
    String nameInput = "nurse";
    jobCategoryPage.deleteJobCategory(nameInput);

  }

  @Test
  public void editLanguage(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "admin123", true, null);
    HeaderPage headerPage = new HeaderPage(driver);
    headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
    JobCategoryPage jobCategoryPage = new JobCategoryPage(driver);
    //String nameInput = "nurse";
    jobCategoryPage.editJobCategory();




  }


}
