package com.simulatorbri.test.directDebit.verify;

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
public class PaymentChargeVerifyService {

    @Autowired
    private Environment env;

    public ResponseEntity<ResponsePayVerify> doVerify (@RequestBody ReqPaymentVerify reqPaymentVerify){
        RespPaymentVerify respPaymentVerify = new RespPaymentVerify();
        ResponsePayVerify response = new ResponsePayVerify();

        RespLocation respLocation = new RespLocation();
        RespMetadata respMetadata = new RespMetadata();
        String tokenCard = reqPaymentVerify.getCard_token();
        String errorCode = tokenCard.substring(tokenCard.length()-4);
        String errorMsg = env.getProperty("err.code.pay.verify." + errorCode);

        if ( errorMsg != null ){
            respPaymentVerify.setStatus(errorCode);
            respPaymentVerify.setPayment_id("175226995569");
            respPaymentVerify.setAmount("20000.00");
            respPaymentVerify.setCurrency("IDR");
            respPaymentVerify.setRemarks("failed");
            respPaymentVerify.setDevice_id("");
            respPaymentVerify.setPayment_status(errorMsg);
            respLocation.setLat("");
            respLocation.setLon("");
            respPaymentVerify.setLocation(respPaymentVerify.getLocation());
            respMetadata.setExample1("example1");
            respPaymentVerify.setMetadata(respPaymentVerify.getMetadata());
            response.setBody(respPaymentVerify);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } else {
            respPaymentVerify.setStatus(errorCode);
            respPaymentVerify.setPayment_id("175226995569");
            respPaymentVerify.setAmount("20000.00");
            respPaymentVerify.setCurrency("IDR");
            respPaymentVerify.setRemarks("Remarks");
            respPaymentVerify.setDevice_id("");
            respPaymentVerify.setPayment_status("SUCCESS");
            respLocation.setLat("-6.21462");
            respLocation.setLon("106.84513");
            respPaymentVerify.setLocation(respLocation);
            respMetadata.setExample1("example1");
            respPaymentVerify.setMetadata(respMetadata);
            response.setBody(respPaymentVerify);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}
