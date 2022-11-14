package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.entity.Items;
import com.areeba.POS.services.Impl.ItemServiceImpl;
import com.areeba.POS.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/item"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class ItemController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final ItemService itemService;
    @Autowired
    private final ItemServiceImpl itemServiceImpl;

    public ItemController(AuthenticationManager authenticationManager, ItemService itemService, ItemServiceImpl itemServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.itemService = itemService;
        this.itemServiceImpl = itemServiceImpl;
    }

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

    @GetMapping({"/create"})
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
