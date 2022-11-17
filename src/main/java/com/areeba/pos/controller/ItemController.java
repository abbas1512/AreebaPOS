package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemDTO;
import com.areeba.pos.entity.Items;
import com.areeba.pos.services.Impl.ItemServiceImpl;
import com.areeba.pos.services.ItemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/item"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@Api(tags = "item controller")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping
    public Items getItem(long Id) {
        return this.itemService.getItem(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllItems() {
        return this.itemService.getAll();
    }

    @GetMapping({"/name"})
    public Items getItemName(String name) {
        return this.itemService.getItemName(name);
    }

    @PostMapping({"/create"})
    public Items createItem(ItemDTO itemDTO) {
        return this.itemService.createItem(itemDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateItem(@PathVariable("Id") long Id, @RequestBody ItemDTO itemDTO) {
        return this.itemService.updateItem(Id, itemDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteItem(@PathVariable("Id") long Id) {
        return this.itemService.deleteItem(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveItem(@RequestBody ItemDTO itemDTO) {
        return this.itemService.saveItem(itemDTO, itemDTO.getName());
    }
}
