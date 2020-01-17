package com.simulatorbri.test.dto;

import lombok.Data;

@Data
public class PaymentResp {
    private String responseCode;
    private String responseDescription;
    private String errorDescription;
    private String jurnalSeq;
}
