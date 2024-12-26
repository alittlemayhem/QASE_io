package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectModal {

    private final String CREATE_PROJECT_BUTTON = "//span[text()='Create project']",
            PROJECT_NAME = "#project-name",
            PROJECT_CODE = "#project-code",
            RADIOBUTTON_PATTERN = "//input[@value='%s']",
            DROPDOWN = "//input[@id='select-search-:rm:']";

    //@Step("Open modal window for new project creation.")
    public NewProjectModal open() {
        $(byText("Create new project")).click();
        return this;
    }

    //@Step("Specify project code.")
    public NewProjectModal setProjectName(String projectName) {
        $(PROJECT_NAME).setValue(projectName);
        return this;
    }

    //@Step("Specify user-defined value of project code.")
    public NewProjectModal setProjectCode(String projectCode) {
        $(PROJECT_CODE).clear();
        $(PROJECT_CODE).setValue(projectCode);
        return this;
    }

    //@Step("Select radiobutton for mode access.")
    public NewProjectModal setRadioButtonValue(String buttonValue) {
        $(byXpath(String.format(RADIOBUTTON_PATTERN, buttonValue))).selectRadio(buttonValue);
        return this;
    }

    //@Step("Select group owner for private access mode.")
    public NewProjectModal selectGroupOwner() {
        $(byXpath(DROPDOWN)).shouldBe(clickable).click();
        $(byXpath("//div[text()='Owner group']")).shouldBe(visible).click();
        return this;
    }

    //@Step("Create project.")
    public CreatedProjectPage clickCreateProject() {
        $(byXpath(CREATE_PROJECT_BUTTON)).click();
        return new CreatedProjectPage();
    }
}
