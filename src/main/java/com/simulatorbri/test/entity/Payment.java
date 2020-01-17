package com.simulatorbri.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Setter
@Getter
public class Payment {

    @NotNull (message = "Number referral cannot be null")
    @Size (max = 20, message = "Number referral length must not be more than 20 characters")
    private String noReferral;

    @NotNull (message = "Source Account Source cannot be null")
    @Size(max = 15, message = "Source Account Source length must not be more than 15 characters")
    private String sourceAccount;

    @NotNull (message = "Beneficiary Account cannot be null")
    @Size (max = 15, message = "Beneficiary Account length must not be more than 15 characters")
    private String beneficiaryAccount;

    @NotNull (message = "Amount cannot be null")
    @Size (max = 15, message = "Amount length must not be more than 15 characters")
    private String amount;

    @NotNull (message = "Fee Type cannot be null")
    private String feeType;

    @NotNull (message = "Transaction Date cannot be null")
    private String transactionDateTime;

    @NotNull (message = "Remark cannot be null")
    private String remark;

    @NotNull (message = "JurnalSeq cannot be null")
    private String jurnalSeq;
}
