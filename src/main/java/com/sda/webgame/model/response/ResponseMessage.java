package com.sda.webgame.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseMessage<T> {

    private StatusResponse status;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T body;

    public ResponseMessage() {
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public ResponseMessage(StatusResponse status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }
}
