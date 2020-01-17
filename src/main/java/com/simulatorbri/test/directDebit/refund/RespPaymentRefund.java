package com.simulatorbri.test.directDebit.refund;

import lombok.Data;

@Data
public class RespPaymentRefund {
    private String status;
    private String refund_id;
    private String payment_id;
    private String amount;
    private String currency;
    private String reason;
    private String refund_status;
    private String device_id;
    private RespLocation location;
    private RespMetadata metadata;
}
