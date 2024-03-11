package com.siyama.legends.controller;

import com.siyama.legends.dtos.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("required-items/")
public class RequiredItemsController {
    @PostMapping("{eventId}/")
    public String addItem(@PathVariable("eventId") String eventId, Item item){
        return "Item for " +  eventId + " successfully";
    }
}
