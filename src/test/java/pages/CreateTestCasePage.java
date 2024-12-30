package pages;

import dto.TestСaseBasic;
import io.qameta.allure.Step;
import wrappers.Checkbox;
import wrappers.PickList;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTestCasePage {

    private final String TITLE = "#title",
            SAVE_BUTTON = "#save-case",
            ADD_STEP = "//span[text()=' Add step']//parent::button",
            STEP_ACTION = "//*[text() = '%s']//following::input[@value][1]",
            DATA = "//*[text() = '%s']//following::input[@value][2]",
            EXPECTED_RESULT = "//*[text() = '%s']//following::input[@value][3]";

    @Step("Fill 'Basic' section for test case page.")
    public CreateTestCasePage fillBasicSection(TestСaseBasic basicInfo) {
        $(TITLE).setValue(basicInfo.getTitle());
        new PickList().selectPicklistItem("Status", basicInfo.getStatus());
        new PickList().selectPicklistItem("Severity", basicInfo.getSeverity());
        new PickList().selectPicklistItem("Priority", basicInfo.getPriority());
        new PickList().selectPicklistItem("Type", basicInfo.getType());
        new PickList().selectPicklistItem("Layer", basicInfo.getLayer());
        new PickList().selectPicklistItem("Is flaky", basicInfo.getIsFlaky());
        new PickList().selectPicklistItem("Behavior", basicInfo.getBehavior());
        new PickList().selectPicklistItem("Automation status", basicInfo.getAutoStatus());
        new Checkbox().selectCheckbox("To be automated", basicInfo.getToBeAuto());
        new Checkbox().selectCheckbox("Muted case", basicInfo.getMuted());
        return this;
    }

    @Step("Create specified amount of test steps - {numberOfSteps} - filled with some data.")
    public CreateTestCasePage fillTestCaseSteps(int numberOfSteps) {
        for (int i = 1; i <= numberOfSteps; i++) {
            $(byXpath(ADD_STEP)).click();

            String step = String.valueOf(i);

            $x(String.format(STEP_ACTION, step)).sendKeys(String.format("Step Action %s", step));
            $x(String.format(DATA, step)).sendKeys(String.format("Data %s", step));
            $x(String.format(EXPECTED_RESULT, step)).sendKeys(String.format("Expected result %s", step));
        }
        return this;
    }

    @Step("Save created test case.")
    public CreatedProjectPage saveTestCase() {
        $(SAVE_BUTTON).click();
        return new CreatedProjectPage();
    }
}
