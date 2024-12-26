package wrappers;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PickList {

    private final String DROPDOWN_PATTERN = "//label[text()='%s']//following::div";
    private final String DROPDOWN_OPTION_PATTERN = "//div[text()='%s']";

    public void selectPicklistItem(String label, String option) {
        $(byXpath(String.format(DROPDOWN_PATTERN, label))).click();
        $(byXpath(String.format(DROPDOWN_OPTION_PATTERN, option))).click();
    }
}