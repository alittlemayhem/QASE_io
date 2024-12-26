package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    //@Step("Open 'Projects' page.")
    public void openPage() {
        open("projects");
    }

    public void waitTilOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible);
    }

    //@Step("Remove project after test is finished.")
    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(byXpath("//span[text()='Delete project']")).click();
    }
}
