package com.simulatorbri.test.directDebit.refund;

import com.simulatorbri.test.directDebit.verify.RespMetadata;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ReqPaymentRefund {

    @NotNull(message = "Oops! Wrong format.")
    @NotEmpty(message = "cannot be null")
    @Pattern(regexp = "[A-Za-z0-9 _.-]*[A-Za-z0-9][A-Za-z0-9 _.-]", message = "wrong format, try again.")
    private String card_token;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Pattern(message = "wrong format, try again.", regexp = "^([A-Z0-9])+[.][0]{2}$")
    private String amount;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Length(max = 15, message = "maximal character must be 15.")
    private String payment_id;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Pattern(message = "wrong format, try again.", regexp = "[A-Z]{3}")
    private String currency;

    @NotNull (message = "Oops! Wrong format.")
    private String reason;

    @NotNull (message = "Oops! Wrong format.")
    private RespMetadata metadata;
}
