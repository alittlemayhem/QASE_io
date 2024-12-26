package pages;

import dto.TestcaseBasic;
import io.qameta.allure.Step;
import wrappers.Checkbox;
import wrappers.PickList;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateTestCasePage {

    private final String TITLE = "#title";
    private final String EDITABLE_CONTENT_PATTERN = "";
    private final String SAVE_BUTTON = "#save-case";
    private final String ADD_STEP = "//span[text()=' Add step']//parent::button";

    //@Step("Fill 'Basic' section for test case page.")
    public CreateTestCasePage fillBasicSection(TestcaseBasic basicInfo) {
        $(TITLE).setValue(basicInfo.getTitle());
        new PickList().selectPicklistItem("Status", basicInfo.getStatus());
        new PickList().selectPicklistItem("Severity", basicInfo.getSeverity());
        new PickList().selectPicklistItem("Priority", basicInfo.getPriority());
        new PickList().selectPicklistItem("Type", basicInfo.getType());
        new PickList().selectPicklistItem("Layer", basicInfo.getLayer());
        new PickList().selectPicklistItem("Is flaky", basicInfo.getIsFlaky());
        new PickList().selectPicklistItem("Behavior", basicInfo.getBehavior());
        new PickList().selectPicklistItem("Automation status", basicInfo.getAutoStatus());
        new Checkbox().selectCheckbox(basicInfo.getToBeAuto());
        new Checkbox().selectCheckbox(basicInfo.getMuted());
        return this;
    }

    //@Step("Create specified amount of test steps filled with some data.")
    public CreateTestCasePage fillTestCaseSteps(int numberOfSteps) {
        for (int i = 1; i <= numberOfSteps; i++) {
            $(byXpath(ADD_STEP)).click();

            String step = String.valueOf(i);

            $(byXpath(String.format("//*[text() = '%s']//following::input[@value][1]", step))).sendKeys(String.format("Step Action %s", step));
            $(byXpath(String.format("//*[text() = '%s']//following::input[@value][2]", step))).sendKeys(String.format("Data %s", step));
            $(byXpath(String.format("//*[text() = '%s']//following::input[@value][3]", step))).sendKeys(String.format("Expected result %s", step));
        }
        return this;
    }

    //@Step("Save created test case.")
    public CreatedProjectPage saveTestCase() {
        $(SAVE_BUTTON).click();
        return new CreatedProjectPage();
    }
}
