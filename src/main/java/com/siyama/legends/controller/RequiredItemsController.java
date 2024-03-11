package com.siyama.legends.controller;

import com.siyama.legends.dtos.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("required-items/")
public class RequiredItemsController {
    @PostMapping(value = "{eventId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addItem(@PathVariable("eventId") String eventId,Item item){

        return item + " for " +  eventId + " saved successfully";
    }
}
