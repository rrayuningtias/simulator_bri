package com.simulatorbri.test.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
    private String responseCode;
    private String responseDescription;
    private String errorDescription;
    private T data;
}
