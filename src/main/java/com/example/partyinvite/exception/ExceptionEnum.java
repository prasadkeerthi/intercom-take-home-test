package com.example.partyinvite.exception;

public enum ExceptionEnum {
    INPUT_URL_ERROR("File not found at Input url "),
    OUTPUT_FILE_ERROR("Error writing to output file");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return this.message;
    }

}
