package test;

import dto.TestСaseBasic;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestCaseCreateTest extends BaseTest {

    TestСaseBasic basicCaseInfo1 = TestСaseBasic.builder()
            .title("Case 1")
            .build();
    TestСaseBasic basicCaseInfo2 = TestСaseBasic.builder()
            .title("Case 2")
            .build();

    @Test(testName = "Case creation with basic info", description = "Create test case with 'Basic' section filled.")
    @Description("Creation of new test case with all fields filled/selected/checked in the 'Basic' section")
    public void checkCreateTestCaseWithoutSteps() {
        loginStep.login(user, password);
        projectsPage.waitTilOpened();
        createProjectStep.create("QASE");
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
        loginStep.login(user, password);
        projectsPage.waitTilOpened();
        createProjectStep.create("QASE");
        createdProjectPage.switchToTestCase()
                .fillBasicSection(basicCaseInfo2)
                .fillTestCaseSteps(3)
                .saveTestCase()
                .successMessage()
                .getTestCaseTitle("Case 2");

        removeProjectStep.deleteProject("QASE");
    }
}
