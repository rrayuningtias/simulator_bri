package com.simulatorbri.test.directDebit.verify;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsePayVerify<T> {
    private T body;
}
