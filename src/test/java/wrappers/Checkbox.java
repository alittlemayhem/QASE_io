package wrappers;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Checkbox {

    private final String CHECKBOX_PATTERN = "//label[text()='%s']//following::span//input";

    public void selectCheckbox(String label) {
        $(byXpath(String.format(CHECKBOX_PATTERN, label))).click();
    }
}
