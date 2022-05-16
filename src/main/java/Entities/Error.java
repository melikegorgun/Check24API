package Entities;

import java.beans.ConstructorProperties;

public class Error {

    private String statusCode;
    private String message;

    @ConstructorProperties({"statusCode", "message"})
    public Error(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getCode() {
        return statusCode;
    }

    public void setCode(String code) {
        this.statusCode = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
