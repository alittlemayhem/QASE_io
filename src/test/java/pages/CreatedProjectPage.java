package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreatedProjectPage {

    private final String PROJECT_TITLE = "//h1",
            CASETITLE_PANE_PATTERN = "//h1//div[text()='%s']",
            CASETITLE_TABLE = "//div[text()='%s']",
            MESSAGE = "//div[@role='alert']";

    @Step("Check that created projects has correct title: {name} repository.")
    public void getProjectTitle(String name) {
        $x(PROJECT_TITLE).shouldHave(exactText(name + " repository"));
    }

    @Step("Switch to new test case creation page")
    public CreateTestCasePage switchToTestCase() {
        $(byText("Create new case")).click();
        return new CreateTestCasePage();
    }

    @Step("Check that correct {title} is displayed on panel and in the table.")
    public CreatedProjectPage getTestCaseTitle(String title) {
        $x(String.format(CASETITLE_PANE_PATTERN, title)).shouldBe(visible);
        $x(String.format(CASETITLE_TABLE, title)).shouldBe(visible);
        return this;
    }

    public CreatedProjectPage successMessage() {
        String expectedMessage = "Test case was created successfully!";
        $x(MESSAGE).find(byText(expectedMessage)).shouldBe(visible);
        return this;
    }
}
