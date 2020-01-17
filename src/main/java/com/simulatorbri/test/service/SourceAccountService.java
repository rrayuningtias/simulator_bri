package com.simulatorbri.test.service;

import com.simulatorbri.test.dto.SourceAccountResp;
import com.simulatorbri.test.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Slf4j
public class SourceAccountService {

    @Autowired
    private Environment env;

    public ResponseEntity<Response> doValidate (@RequestParam String sourceAccount, @RequestParam String beneficiaryAccount){
        SourceAccountResp sourceAccountResp = new SourceAccountResp();
        Response response = new Response();

        String fourDigit = sourceAccount.substring(sourceAccount.length() - 4);
        String errorCode = env.getProperty("err.code." + fourDigit);
        String successMsg = env.getProperty("success.code.0300");

        if ( errorCode != null){
            response.setResponseCode(fourDigit);
            response.setResponseDescription(errorCode);
            response.setErrorDescription("");
            response.setData(sourceAccountResp);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        } else {
            response.setResponseCode(fourDigit);
            response.setResponseDescription(successMsg);
            response.setErrorDescription("");
            sourceAccountResp.setSourceAccount(sourceAccount);
            sourceAccountResp.setSourceAccountName("BRIAPI SANDBOX");
            sourceAccountResp.setSourceAccountStatus("Rekening Aktif.");
            sourceAccountResp.setSourceAccountBalance("258544125122.98");
            sourceAccountResp.setRegistrationStatus("Rekening terdaftar an. bri");
            sourceAccountResp.setBeneficiaryAccount(beneficiaryAccount);
            sourceAccountResp.setBeneficiaryAccountName("BRIAPI SANDBOX 2");
            sourceAccountResp.setBeneficiaryAccountStatus("Rekening Aktif.");
            response.setData(sourceAccountResp);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
        }
    }

}
