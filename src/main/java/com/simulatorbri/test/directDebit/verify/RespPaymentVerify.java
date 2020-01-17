package com.simulatorbri.test.directDebit.verify;

import lombok.Data;

@Data
public class RespPaymentVerify {
    private String status;
    private String payment_id;
    private String amount;
    private String currency;
    private String remarks;
    private String device_id;
    private String payment_status;
    private RespLocation location;
    private RespMetadata metadata;
}
