package com.siyama.legends.utils;

import com.siyama.legends.dtos.response.SaveResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class LegendsUtility {
    private LegendsUtility() {
    }

    public static ResponseEntity<String> objectExistsAndNotForced(String name) {
        var response = new SaveResponseDto(name).alreadyExists();
        log.error(String.format("ERROR %s", response));
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

}
