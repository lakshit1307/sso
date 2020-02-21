package com.healthedge.sso.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends BaseResponse {

    @ApiModelProperty(value = "Token returned for succesful login")
    private String token;

}
