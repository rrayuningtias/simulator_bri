package com.simulatorbri.test.directDebit.OTP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "charge")
public class PaymentChargeController {

    @Autowired
    PaymentChargeOTPService paymentChargeOTPService;

    @PostMapping
    public ResponseEntity<ResponsePaymentOTP> doChargePay (@Valid @RequestBody ReqPaymentChargeOTP reqPaymentChargeOTP){
        return paymentChargeOTPService.doCreateOTP(reqPaymentChargeOTP);
    }
}
