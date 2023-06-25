package com.example.autocomplete_case_study.model;

/**
 * This class defines the structure of an error response
 */
public class ErrorResponse {
    String error_code;
    String error_description;
    public ErrorResponse() {}

    public void setErrorCode(String error_code) {
        this.error_code = error_code;
    }

    public void setErrorDescription(String description) {
        this.error_description = description;
    }

    /**
     * Formats the fields of this class in JSON format.
     * @return A String in JSON Format contianing the fields of this class.
     */
    public String getResponse(){
        return String.format("{\"error_code\":  \"%s\"  , \"error_description\": \"%s\"}", this.error_code, this.error_description);
    }
}
