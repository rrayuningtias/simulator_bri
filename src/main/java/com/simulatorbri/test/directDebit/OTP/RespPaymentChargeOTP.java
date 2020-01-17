package com.simulatorbri.test.directDebit.OTP;

import lombok.Data;

@Data
public class RespPaymentChargeOTP {
    private String charge_token;
    private String status;
}
