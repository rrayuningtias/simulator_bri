package com.simulatorbri.test.directDebit.refund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "refunds")
public class PaymentRefundController {

    @Autowired
    PaymentRefundService paymentRefundService;

    @PostMapping
    public ResponseEntity<ResponsePaymentRefund> doRefunds (@Validated @RequestBody ReqPaymentRefund reqPaymentRefund){
        return paymentRefundService.doRefund(reqPaymentRefund);
    }
}
