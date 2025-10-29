package com.FirstAdi.demo.pojo;

public class ApiResponseVo {
    private String status;
    private String message;

    public ApiResponseVo(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponseVo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
