package com.simulatorbri.test.dto;

import lombok.Data;

@Data
public class CheckStatusResp {

    private String noReferral;
    private String jurnalSeq;
    private String internalTransferStatus;
    private String internalTransferErrorMessage;
}
