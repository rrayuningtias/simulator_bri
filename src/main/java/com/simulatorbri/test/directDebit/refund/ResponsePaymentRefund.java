package com.simulatorbri.test.directDebit.refund;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsePaymentRefund<T> {
    private T body;
}
