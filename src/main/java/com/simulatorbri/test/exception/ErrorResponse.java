package com.simulatorbri.test.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    public int status;
    public String message;
    public String[] errors;
}
