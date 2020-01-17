package com.simulatorbri.test.directDebit.OTP;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ReqPaymentChargeOTP {

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Pattern(regexp = "[A-Za-z0-9 _.-]*[A-Za-z0-9][A-Za-z0-9 _.-]", message = "wrong format, try again.")
    private String card_token;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Pattern(message = "wrong format, try again.", regexp = "^([0-9])+[.][0]{2}$")
    private String amount;

    @NotNull (message = "Oops! Wrong format.")
    @NotEmpty (message = "cannot be null")
    @Pattern(message = "wrong format, try again.", regexp = "[A-Z]{3}")
    private String currency;

    @NotNull (message = "Oops! Wrong format.")
    private String remarks;

    @NotNull (message = "Oops! Wrong format.")
    private String otp_bri_status;

    @NotNull (message = "Oops! Wrong format.")
    private ReqMetadata metadata;
}
