package com.siyama.legends.controller;

import com.siyama.legends.dtos.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("required-items/")
public class RequiredItemsController {
    @PostMapping(value = "{eventId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addItem(@PathVariable("eventId") String eventId, @RequestBody Item item){

        return item + " for " +  eventId + " saved successfully";
    }
}
