package com.simulatorbri.test.service;

import com.simulatorbri.test.dto.CheckStatusBaseResp;
import com.simulatorbri.test.dto.CheckStatusResp;
import com.simulatorbri.test.dto.request.CheckStatusReq;
import com.simulatorbri.test.entity.BaseResponse;
import com.simulatorbri.test.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Slf4j
public class CheckStatusService {

//    @Value("${success.code.0300}")  private String successStatus;
//    @Value("${err.code.0304}")      private String cannotNull;
//    @Value("${err.code.0307}")      private String invalidReferral;
//    @Value("${err.code.0308}")      private String failedStatus;
//    @Value("${err.code.0002}")      private String errorMaxCharacter;
//    @Value("${err.code.0001}")      private String errorFormat;

    @Autowired
    private Environment env;

    public ResponseEntity<ResponseStatus> doCheck (@RequestParam String noReferral){
        CheckStatusResp checkStatusResp = new CheckStatusResp();
        ResponseStatus response = new ResponseStatus();

        String fourDigit = noReferral.substring(noReferral.length() - 4);
        String errorCode = env.getProperty("err.code." + fourDigit);
        String successMsg = env.getProperty("success.code.0300");

        if (errorCode != null){
            response.setResponseCode(fourDigit);
            response.setResponseDescription(errorCode);
            response.setErrorDescription("");
            response.setData(checkStatusResp);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            response.setResponseCode(fourDigit);
            response.setResponseDescription(successMsg);
            response.setErrorDescription("");
            checkStatusResp.setNoReferral(noReferral);
            checkStatusResp.setJurnalSeq("3289331");
            checkStatusResp.setInternalTransferStatus("Payment Success");
            checkStatusResp.setInternalTransferErrorMessage("");
            response.setData(checkStatusResp);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        }

    }


}
