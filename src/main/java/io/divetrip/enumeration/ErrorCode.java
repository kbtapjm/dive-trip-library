package io.divetrip.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // COMMON
    INVALID_INPUT_VALUE("C001", "Invalid Input Value", 400),
    INVALID_TYPE_VALUE("C002", "Invalid Type Value", 400),
    RESOURCE_NOT_FOUND("C003", "Resource not found", 404),
    METHOD_NOT_ALLOWED("C004", "Method Not Allowed", 405),
    INTERNAL_SERVER_ERROR("C005", "Internal Server Error", 500);

    // DIVER

    private final String code;
    private final String message;
    private final int status;

}
