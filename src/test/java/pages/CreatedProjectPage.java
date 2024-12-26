package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreatedProjectPage {

    private final String PROJECT_TITLE = "//h1";
    private final String CASETITLE_PANE_PATTERN = "//h1//div[text()='%s']";
    private final String CASETITLE_TABLE = "//div[text()='%s']";

    //@Step("Check that created projects has correct title.")
    public void getProjectTitle(String name) {
        $(byXpath(PROJECT_TITLE)).shouldHave(exactText(name + " repository"));
    }

    //@Step("Switch to new test case creation page")
    public CreateTestCasePage switchToTestCase() {
        $(byText("Create new case")).click();
        return new CreateTestCasePage();
    }

    //@Step("Check that correct title is displayed on panel and in the table.")
    public CreatedProjectPage getTestCaseTitle(String title) {
        $(byXpath(String.format(CASETITLE_PANE_PATTERN, title))).shouldBe(visible);
        $(byXpath(String.format(CASETITLE_TABLE, title))).shouldBe(visible);
        return this;
    }

    public CreatedProjectPage successMessage() {
        String expectedMessage = "Test case was created successfully!";
        $(byXpath("//div[@role='alert']")).find(byText(expectedMessage)).shouldBe(visible);
        return this;
    }
}
