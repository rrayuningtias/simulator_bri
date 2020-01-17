package com.simulatorbri.test.directDebit.verify;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ReqPaymentVerify {

    @NotNull(message = "Oops! Wrong format.")
    @NotEmpty(message = "cannot be null")
    @Pattern(regexp = "[A-Za-z0-9 _.-]*[A-Za-z0-9][A-Za-z0-9 _.-]", message = "wrong format, try again.")
    private String card_token;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Length (max = 40, message = "maximal character must be 40.")
    private String charge_token;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Size (max = 6, message = "maximal character must be 6.")
    private String passcode;
}
