package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.CreateProjectStep;
import steps.LoginStep;
import steps.RemoveProjectStep;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    NewProjectModal newProjectModal;
    CreatedProjectPage createdProjectPage;
    CreateTestCasePage createTestCasePage;
    LoginStep loginStep;
    CreateProjectStep createProjectStep;
    RemoveProjectStep removeProjectStep;

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.baseUrl = "https://app.qase.io/";

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        newProjectModal = new NewProjectModal();
        createdProjectPage = new CreatedProjectPage();
        createTestCasePage = new CreateTestCasePage();
        loginStep = new LoginStep();
        createProjectStep = new CreateProjectStep();
        removeProjectStep = new RemoveProjectStep();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
