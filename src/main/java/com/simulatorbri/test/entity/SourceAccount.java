package com.simulatorbri.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter
public class SourceAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer sourceAccountId;

    @NotNull (message = "Source Account Source cannot be null")
    @Size (max = 15, message = "Source Account Source length must not be more than 15 characters")
    private String sourceAccount;

    @NotNull (message = "Source Account Name cannot be null")
    private String sourceAccountName;

    @NotNull (message = "Source Account Status cannot be null")
    private String sourceAccountStatus;

    @NotNull (message = "Source Account Balance cannot be null")
    private String sourceAccountBalance;

    @NotNull (message = "Registration Status cannot be null")
    private String registrationStatus;

    @NotNull (message = "Beneficiary Account cannot be null")
    @Size (max = 15, message = "Beneficiary Account length must not be more than 15 characters")
    private String beneficiaryAccount;

    @NotNull (message = "Beneficiary Account Name cannot be null")
    private String beneficiaryAccountName;

    @NotNull (message = "Beneficiary Account Status cannot be null")
    private String beneficiaryAccountStatus;

    @NotNull (message = "Destination Account cannot be null")
    @Size (max = 15, message = "Destination Account length must not be more than 15 characters")
    private String destinationAccount;


}
