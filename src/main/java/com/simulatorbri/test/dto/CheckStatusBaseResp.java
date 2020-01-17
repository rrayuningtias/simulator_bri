package com.simulatorbri.test.dto;

import com.simulatorbri.test.entity.BaseResponse;
import lombok.Data;

@Data
public class CheckStatusBaseResp {
    BaseResponse<CheckStatusResp> getCheckStatusResponse;
}
