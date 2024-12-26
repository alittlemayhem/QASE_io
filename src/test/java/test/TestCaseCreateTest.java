package test;

import dto.TestcaseBasic;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestCaseCreateTest extends BaseTest {

    TestcaseBasic basicCaseInfo1 = TestcaseBasic.builder()
            .title("Case 1")
            .build();
    TestcaseBasic basicCaseInfo2 = TestcaseBasic.builder()
            .title("Case 2")
            .build();

    @Test(testName = "Case creation with basic info", description = "Create test case with 'Basic' section filled.")
    @Description("Creation of new test case with all fields filled/selected/checked in the 'Basic' section")
    public void checkCreateTestCaseWithoutSteps() {
        loginStep.login();
        projectsPage.waitTilOpened();
        createProjectStep.create();
        createdProjectPage.switchToTestCase()
                .fillBasicSection(basicCaseInfo1)
                .saveTestCase()
                .successMessage()
                .getTestCaseTitle("Case 1");

        removeProjectStep.deleteProject("QASE");
    }

    @Test(testName = "Case creation with steps", description = "Create test case with specified amount of test steps.")
    @Description("Creation of new test case with all fields in the 'Basic' section and addition of 3 steps filled with data.")
    public void checkCreateTestCaseWithSteps() {
        loginStep.login();
        projectsPage.waitTilOpened();
        createProjectStep.create();
        createdProjectPage.switchToTestCase()
                .fillBasicSection(basicCaseInfo2)
                .fillTestCaseSteps(3)
                .saveTestCase()
                .successMessage()
                .getTestCaseTitle("Case 2");

        removeProjectStep.deleteProject("QASE");
    }
}
