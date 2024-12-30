package steps;

import pages.NewProjectModal;

public class CreateProjectStep {

    NewProjectModal newProjectModal;

    public CreateProjectStep() {
        newProjectModal = new NewProjectModal();
    }

    public void create(String project) {
        newProjectModal.open()
                .setProjectName(project)
                .clickCreateProject();
    }
}
