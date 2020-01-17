package com.simulatorbri.test.directDebit.OTP;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsePaymentOTP<T> {
    private T body;
}
