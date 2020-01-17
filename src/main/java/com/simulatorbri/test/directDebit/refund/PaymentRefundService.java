package com.simulatorbri.test.directDebit.refund;

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
public class PaymentRefundService {

    @Autowired
    private Environment env;

    public ResponseEntity<ResponsePaymentRefund> doRefund (@RequestBody ReqPaymentRefund reqPaymentRefund){
        RespPaymentRefund respPaymentRefund = new RespPaymentRefund();
        ResponsePaymentRefund response = new ResponsePaymentRefund();

        RespLocation respLocation = new RespLocation();
        RespMetadata respMetadata = new RespMetadata();
        String tokenCard = reqPaymentRefund.getCard_token();
        String errorCode = tokenCard.substring(tokenCard.length()-4);
        String errorMsg = env.getProperty("err.code.pay.refund." + errorCode);
        String successMsg = env.getProperty("success.code." + errorCode);

        if ( errorMsg != null ){
            respPaymentRefund.setStatus(errorCode);
            respPaymentRefund.setRefund_id("");
            respPaymentRefund.setPayment_id("");
            respPaymentRefund.setAmount("");
            respPaymentRefund.setCurrency("");
            respPaymentRefund.setReason(errorMsg);
            respPaymentRefund.setRefund_status("");
            respPaymentRefund.setDevice_id("");
            respLocation.setLat(respLocation.getLat());
            respLocation.setLon(respLocation.getLon());
            respPaymentRefund.setLocation(respPaymentRefund.getLocation());
            respMetadata.setExample1(respMetadata.getExample1());
            respPaymentRefund.setMetadata(respPaymentRefund.getMetadata());
            response.setBody(respPaymentRefund);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } else {
            respPaymentRefund.setStatus(errorCode);
            respPaymentRefund.setRefund_id("6218763823");
            respPaymentRefund.setPayment_id("89937492374");
            respPaymentRefund.setAmount("20000.00");
            respPaymentRefund.setCurrency("IDR");
            respPaymentRefund.setReason(successMsg);
            respPaymentRefund.setRefund_status("SUCCESS");
            respPaymentRefund.setDevice_id("lg-lllll");
            respLocation.setLat("-6.21462");
            respLocation.setLon("106.84513");
            respPaymentRefund.setLocation(respLocation);
            respMetadata.setExample1("example1");
            respPaymentRefund.setMetadata(respMetadata);
            response.setBody(respPaymentRefund);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
