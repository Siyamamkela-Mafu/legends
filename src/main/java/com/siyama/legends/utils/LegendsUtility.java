package com.siyama.legends.utils;

import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.exception.ObjectAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LegendsUtility {
    private LegendsUtility() {
    }

    public static void objectExistsAndNotForced(String name) {
        var response = new SaveResponseDto(name).alreadyExists();
        log.error(String.format("ERROR %s", response));
        throw new ObjectAlreadyExistsException(response);
    }

}
