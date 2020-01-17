package com.simulatorbri.test.directDebit.verify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "verify")
public class PaymentChargeVerifyController {

    @Autowired
    PaymentChargeVerifyService paymentChargeVerifyService;

    @PostMapping
    public ResponseEntity<ResponsePayVerify> doPayVerif (@Validated @RequestBody ReqPaymentVerify reqPaymentVerify){
        return paymentChargeVerifyService.doVerify(reqPaymentVerify);
    }
}
