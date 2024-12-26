package test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(testName = "Project with required fields", description = "Create project with filled name and code.")
    @Description("Creation of new project named 'QASE' and with code 'AQ'")
    public void checkCreateProjectWithRequiredFields() {
        loginStep.login();
        projectsPage.waitTilOpened();
        newProjectModal.open()
                .setProjectName("QASE")
                .setProjectCode("AQ")
                .clickCreateProject()
                .getProjectTitle("AQ");

        removeProjectStep.deleteProject("QASE");
    }

    @Test(testName = "Project with name only", description = "Create project with filled name.")
    @Description("Creation of new project named 'QASE'")
    public void checkCreateProjectNameOnly() {
        loginStep.login();
        projectsPage.waitTilOpened();
        newProjectModal.open()
                .setProjectName("QASE")
                .clickCreateProject()
                .getProjectTitle("QASE");

        removeProjectStep.deleteProject("QASE");
    }

    @Test(testName = "Public project creation", description = "Create project with public access.")
    @Description("Creation of new project named 'QASE' with access mode 'Public'")
    public void checkCreatePublicProject() {
        loginStep.login();
        projectsPage.waitTilOpened();
        newProjectModal.open()
                .setProjectName("QASEradio")
                .setRadioButtonValue("public")
                .clickCreateProject()
                .getProjectTitle("QASEradio");

        removeProjectStep.deleteProject("QASEradio");
    }

    @Test(testName = "Group project creation", description = "Create project with private access (group mode).")
    @Description("Creation of new project named 'QASE' with access mode 'Private' for specific group.")
    public void checkCreatePrivateProjectGroupAccess() {
        loginStep.login();
        projectsPage.waitTilOpened();
        newProjectModal.open()
                .setProjectName("QASEradio")
                .setRadioButtonValue("group")
                .selectGroupOwner()
                .clickCreateProject()
                .getProjectTitle("QASEradio");

        removeProjectStep.deleteProject("QASEradio");
    }
}
