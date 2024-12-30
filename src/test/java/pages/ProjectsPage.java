package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final String REMOVE_BUTTON = "[data-testid=remove]",
            DELETE_PROJECT_BUTTON = "//span[text()='Delete project']",
            ACTION_MENU = "button[aria-label='Open action menu']";

    @Step("Open 'Projects' page.")
    public void openPage() {
        open("projects");
    }

    public void waitTilOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible);
    }

    @Step("Remove project after test is finished.")
    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find(ACTION_MENU)
                .click();
        $(REMOVE_BUTTON).click();
        $x(DELETE_PROJECT_BUTTON).click();
    }
}
