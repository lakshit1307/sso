package com.healthedge.sso.common.exception.handler;

import io.swagger.annotations.ApiModelProperty;

public class Response {

    @ApiModelProperty(value = "Status code of the request", required = true, example = "301")
    private String statusCode;

    @ApiModelProperty(value = "response message", required = false)
    private String statusMessage;
    private String description;
    private String transactionId;

    public Response(){

    }
    public Response(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public Response(String statusCode, String statusMessage, String description) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.description = description;
    }

    public Response(String statusCode, String statusMessage, String description, String transactionId) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.description = description;
        this.transactionId = transactionId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
