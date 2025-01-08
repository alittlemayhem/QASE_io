package steps;

import pages.ProjectsPage;

public class RemoveProjectStep {

    ProjectsPage projectsPage;

    public RemoveProjectStep() {
        projectsPage = new ProjectsPage();
    }

    public void deleteProject(String project) {
        projectsPage.openPage();
        projectsPage.removeProject(project);
    }
}
