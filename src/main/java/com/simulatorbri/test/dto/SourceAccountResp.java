package com.simulatorbri.test.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SourceAccountResp {
    private String sourceAccount;
    private String sourceAccountName;
    private String sourceAccountStatus;
    private String sourceAccountBalance;
    private String registrationStatus;
    private String beneficiaryAccount;
    private String beneficiaryAccountName;
    private String beneficiaryAccountStatus;
}
