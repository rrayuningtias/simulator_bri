package com.simulatorbri.test.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SourceAccountReq {
    private String sourceAccount;
    private String beneficiaryAccount;
}
