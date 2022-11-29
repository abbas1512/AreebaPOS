package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CategoryDTO;
import com.areeba.pos.dto.ItemDTO;
import com.areeba.pos.entity.Category;
import com.areeba.pos.entity.Items;
import com.areeba.pos.services.Impl.ItemServiceImpl;
import com.areeba.pos.services.ItemService;
import com.mchange.util.AlreadyExistsException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping({"/item"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping({"/id/{id}"})
    public Items getItem(@PathVariable long id) {
        return this.itemService.getItem(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllItems() {
        return this.itemService.getAll();
    }

    @GetMapping({"/name/{name}"})
    public Items getItemName(@PathVariable String name) {
        return this.itemService.getItemName(name);
    }

    @GetMapping({"/category/{category}"})
    public Items getItemCategory(@PathVariable String category) {
        return this.itemService.getItemCategory(category);
    }

    @PostMapping({"/create"})
    public Items createItem(@RequestBody ItemDTO itemDTO) {
        return this.itemService.createItem(itemDTO);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateItem(@PathVariable("id") long id, @RequestBody ItemDTO itemDTO) {
        return this.itemService.updateItem(id, itemDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteItem(@PathVariable("id") long id) {
        return this.itemService.deleteItem(id);
    }

}
