package com.simulatorbri.test.entity;

import lombok.*;

@Data
public class BaseResponse<T> {
    String message;
    String responseCode;
    String responseDescription;
    String errorDescription;
    T data;
}
