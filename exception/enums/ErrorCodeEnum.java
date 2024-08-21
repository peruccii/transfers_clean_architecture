package com.example.cleanarch.exception.enums;

public enum ErrorCodeEnum {

    ON0001("TAX NUMBER INVALID", "ON-0001"),

    TR0001("USER SHOPKEEPER DOESNT HAVE PERMISSION TO DO TRANSFERS", "TR-0001"),

    TR0002("INSUFFICIENT BALANCE", "TR-0002"),

    TRP0001("PIN IS INVALID", "TRP-0001"),

    ;

    private String message;

    private String code;


    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
