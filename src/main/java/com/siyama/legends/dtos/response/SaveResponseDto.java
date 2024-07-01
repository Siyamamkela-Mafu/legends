package com.siyama.legends.dtos.response;

public class SaveResponseDto {
    private final String savedObject;

    public SaveResponseDto(String savedObject) {
        this.savedObject = savedObject;
    }

    public String successful() {
        return "{\"success\": \"" + savedObject + " saved successfully\"}";
    }
    public String alreadyExists() {
        return "{\"message\": \"The " + savedObject + " already exists. Do you want to continue creating a new record? Add 'force=true' to the request.\"}";

    }
}
