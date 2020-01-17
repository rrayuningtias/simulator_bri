package com.simulatorbri.test.controller;

import com.simulatorbri.test.dto.SourceBaseResp;
import com.simulatorbri.test.dto.request.SourceAccountReq;
import com.simulatorbri.test.service.SourceAccountService;
import com.simulatorbri.test.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "account")
public class SourceAccountController {

    @Autowired
    SourceAccountService sourceAccountService;

//    @PostMapping(produces = "application/json")
//    public ResponseEntity<SourceBaseResp> doValidate(@Validated @RequestBody SourceAccountReq sourceAccountReq){
//        return sourceAccountService.doValidateSA(sourceAccountReq);
//    }

    @GetMapping
    ResponseEntity<Response> doValidate (@RequestParam ("sourceAccount") String sourceAccount, @RequestParam ("beneficiaryAccount") String beneficiaryAccount){
        return sourceAccountService.doValidate(sourceAccount, beneficiaryAccount);
    }

}
