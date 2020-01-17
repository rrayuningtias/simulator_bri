package com.simulatorbri.test.service;

import com.simulatorbri.test.dto.PaymentResp;
import com.simulatorbri.test.dto.request.PaymentReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class PaymentService {

    @Autowired
    private Environment env;

    public ResponseEntity<PaymentResp> doValidatePayment(@RequestBody PaymentReq paymentReq) {
        PaymentResp paymentResp = new PaymentResp();

        String noReferral = paymentReq.getNoReferral();
        String errorCode = noReferral.substring(paymentReq.getNoReferral().length() - 4);

        String errorMsg = env.getProperty("err.code." + errorCode);
        String successMsg = env.getProperty("success.code." + errorCode);

        if ( errorMsg != null ){
            paymentResp.setResponseCode(errorCode);
            paymentResp.setResponseDescription("FAILED");
            paymentResp.setErrorDescription(errorMsg);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    contentType(MediaType.APPLICATION_JSON).
                    body(paymentResp);
        }
        else if ( successMsg != null){
            paymentResp.setResponseCode(errorCode);
            paymentResp.setResponseDescription(successMsg);
            paymentResp.setErrorDescription("");
            paymentResp.setJurnalSeq("3289331");
        }

        String feeType = paymentReq.getFeeType();
        String amount = paymentReq.getAmount();
        int fixFeeType = 6500;
        int sender = 0;
        int receipt = 0;

        if (feeType.equals("OUR")){
            sender = Integer.valueOf(amount) + fixFeeType;
            receipt = Integer.valueOf(amount);
        } else if (feeType.equals("BEN")){
            sender = Integer.valueOf(amount);
            receipt = Integer.valueOf(amount) - fixFeeType;
        } else if (feeType.matches("^SHA\\|([0-9]{4})$")){
            String fourDigit = feeType.substring(feeType.length()-4);
            int sha = Integer.parseInt(fourDigit);
            int valueSHA = (fixFeeType - sha);
            sender = Integer.valueOf(amount) + sha ;
            receipt = Integer.valueOf(amount) - valueSHA;
        }

        log.info("Sender  ======" + sender);
        log.info("Receipt ======" + receipt);

        return ResponseEntity.status(HttpStatus.OK).
                contentType(MediaType.APPLICATION_JSON).
                body(paymentResp);
    }

}
