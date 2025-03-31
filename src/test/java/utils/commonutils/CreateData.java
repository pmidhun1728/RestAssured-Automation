package utils.commonutils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateData {
    private String loanAppUuid;
    private Boolean skipSideEffects;
}
