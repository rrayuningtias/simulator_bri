package com.simulatorbri.test.controller;

        import com.simulatorbri.test.dto.PaymentBaseResponse;
        import com.simulatorbri.test.dto.PaymentResp;
        import com.simulatorbri.test.dto.request.PaymentReq;
        import com.simulatorbri.test.service.PaymentService;
        import com.simulatorbri.test.util.Response;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<PaymentResp> doPayment(@Validated @RequestBody PaymentReq paymentReq){
        return paymentService.doValidatePayment(paymentReq);
    }
}
