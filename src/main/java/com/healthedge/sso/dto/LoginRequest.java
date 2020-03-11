package com.healthedge.sso.dto;

import com.healthedge.sso.exception.ErrorCodes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @ApiModelProperty(value = "Username", required = true)
    @NotNull(message = ErrorCodes.USERNAME_REQUIRED)
    @NotBlank(message = ErrorCodes.USERNAME_REQUIRED)
    private String username;

    @ApiModelProperty(value = "This is the Password", required = true)
    @NotNull(message = ErrorCodes.USERNAME_REQUIRED)
    @NotBlank(message = ErrorCodes.USERNAME_REQUIRED)
    private String password;


}
