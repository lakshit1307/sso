package com.healthedge.sso.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    @ApiModelProperty(value = "Status of the request", example = "Success")
    private String status;

    @ApiModelProperty(value = "Additional message", example = "Entity created/updated successfully")
    private String message;
}
