package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class Checkbox {

    private final String CHECKBOX_PATTERN = "//label[text()='%s']//following::span//input";

    public void selectCheckbox(String label, String status) {
        if (status.equals("checked")) {
            $x(String.format(CHECKBOX_PATTERN, label)).click();
        }
    }
}
