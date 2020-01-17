package com.simulatorbri.test.controller;

import com.simulatorbri.test.dto.CheckStatusBaseResp;
import com.simulatorbri.test.dto.request.CheckStatusReq;
import com.simulatorbri.test.service.CheckStatusService;
import com.simulatorbri.test.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "status")
public class CheckStatusController {

    @Autowired
    CheckStatusService checkStatusService;

//    @PostMapping(produces = "application/json")
//    public ResponseEntity<CheckStatusBaseResp> doCheck (@Validated @RequestBody CheckStatusReq checkStatusReq){
//        return checkStatusService.doCheckStatus(checkStatusReq);
//    }

    @GetMapping
    ResponseEntity<ResponseStatus> doCheckStatus (@RequestParam ("noReferral") String noReferral){
//        ResponseStatus responseStatus = new ResponseStatus();
//        responseStatus.setResponseCode("");
//        responseStatus.setResponseDescription("");
//        responseStatus.setErrorDescription("");
//        responseStatus.setData(checkStatusService.doCheck(noReferral));
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(responseStatus);
        return checkStatusService.doCheck(noReferral);
    }
}
