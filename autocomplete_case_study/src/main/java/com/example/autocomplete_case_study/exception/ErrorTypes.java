package com.example.autocomplete_case_study.exception;

/**
 * Enum defining the error_code and error_description for each supported custom exception.
 */
public enum ErrorTypes {
    ILLEGAL_CHARACTER("Only alphabetical characters are allowed.", "001"),
    INPUT_TOO_LONG("Input length exceeds length of possible matches.", "002"),
    INPUT_TOO_SHORT("At least 3 characters need to be provided.", "003"),
    ITEM_NOT_FOUND("No suggestions for given term.", "004");
    private final String description;
    private final String code;

    ErrorTypes(String description, String code) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
