package com.simulatorbri.test.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentReq {
    private String noReferral;
    private String sourceAccount;
    private String beneficiaryAccount;
    private String amount;
    private String feeType;
    private String transactionDateTime;
    private String remark;
}
