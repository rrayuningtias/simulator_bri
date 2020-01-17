package com.simulatorbri.test.directDebit.OTP;

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
public class PaymentChargeOTPService {

    @Autowired
    private Environment env;

    public ResponseEntity<ResponsePaymentOTP> doCreateOTP (@RequestBody ReqPaymentChargeOTP reqPaymentChargeOTP){
        RespPaymentChargeOTP respPaymentChargeOTP = new RespPaymentChargeOTP();
        ResponsePaymentOTP response = new ResponsePaymentOTP();

        String tokenCard = reqPaymentChargeOTP.getCard_token();
        String errorCode = tokenCard.substring(tokenCard.length()-4);
        String errorMsg = env.getProperty("err.code.pay." + errorCode);
        String successMsg = env.getProperty("success.code." + errorCode);


        if ( errorMsg != null ){
            respPaymentChargeOTP.setCharge_token(errorCode);
            respPaymentChargeOTP.setStatus(errorMsg);
            response.setBody(respPaymentChargeOTP);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } else {
            respPaymentChargeOTP.setCharge_token("CHARGE_M3AVZN3LQSX5Q3YZSUHDLT7UAUMANZAP");
            respPaymentChargeOTP.setStatus("PENDING_USER_VERIFICATION");
            response.setBody(respPaymentChargeOTP);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
