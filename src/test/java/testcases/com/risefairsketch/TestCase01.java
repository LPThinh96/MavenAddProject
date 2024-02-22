package testcases.com.risefairsketch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actions.commons.AbstractTest;
import actions.commons.DataProviderFactory;
import actions.risefairsketch.HomePage;
import actions.risefairsketch.LoginPage;
import actions.risefairsketch.TasksPage;
import actions.risefairsketch.ProjectsPage;

public class TestCase01 extends AbstractTest {
    WebDriver driver;
    String uniqueTitle;

    @Parameters({"browser", "version"})
    @BeforeMethod
    public void beforeMethod(String browser, String version){
        driver = openMultiBrowsers(browser, version);
        uniqueTitle = randomEmail();
    }

    @Test(dataProvider = "inputInformationAddProject", dataProviderClass = DataProviderFactory.class)
    public void TC01_CreateProjects(String title, String ProjectType , String ValueProjectType , String Description, String startDate, String deadLine,String Price, String ValueLabels, String ValueOfClient) {
        loginPage = new LoginPage(driver);

        log.info("Step 01 - Open rise fairsketch page");
        loginPage.openLoginPage("https://rise.fairsketch.com/");

        log.info("Step 02 - Login with username admin@demo.com");
        loginPage.loginWithEmailAndPassword("admin@demo.com","riseDemo");

        homePage = new HomePage(driver);
        log.info("VP - Verify Login successfully");
        homePage.verifyHomePageIsDisplayed();

        log.info("Step 02 - Open page Projects");
        homePage.selectMenu("projects");

        projectsPage = new ProjectsPage(driver);
        log.info("Step 03 - Click Add project");
        projectsPage.clickAddProject();

        log.info("Step 04 - Add a new project");
        projectsPage.inputAllInformation(title, ProjectType , ValueProjectType , Description , startDate , deadLine , Price , ValueLabels , ValueOfClient);

        log.info("VP - Verify project is added successfully");
//        projectsPage.verifyTaskIsAddedSuccessfully();
    }

    //	@Test


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    private LoginPage loginPage;
    private HomePage homePage;
    private TasksPage tasksPage;
    private ProjectsPage projectsPage;
}