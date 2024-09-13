package com.example.cleanarch.exception.enums;

public enum ErrorCodeEnum {

    ON0001("TAX NUMBER INVALID", "ON-0001"),

    ON0002("EMAIL ALREADY EXISTS", "ON-0001"),

    ON0003("TAX NUMBER UNAVAILABILITY", "ON-0001"),

    TR0001("USER SHOPKEEPER DOESNT HAVE PERMISSION TO DO TRANSFERS", "TR-0001"),

    TR0002("INSUFFICIENT BALANCE", "TR-0002"),

    TR0003("Occurred an error during transaction", "TR-0003"),

    TRP0001("PIN IS INVALID", "TRP-0001"),

    WA0001("WALLET NOT FOUND", "WA-0001"),
    ;

    private final String message;

    private final String code;


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
