package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class TestcaseBasic {

    private final String title;
    @Builder.Default
    private final String status = "Draft";
    @Builder.Default
    private final String severity = "Critical";
    @Builder.Default
    private final String priority = "High";
    @Builder.Default
    private final String type = "Security";
    @Builder.Default
    private final String layer = "E2E";
    @Builder.Default
    private final String isFlaky = "Yes";
    @Builder.Default
    private final String behavior = "Destructive";
    @Builder.Default
    private final String autoStatus = "Manual";
    @Builder.Default
    private final String toBeAuto = "To be automated";
    @Builder.Default
    private final String muted = "Muted case";
}
