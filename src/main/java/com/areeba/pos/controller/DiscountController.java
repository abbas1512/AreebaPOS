package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.DiscountDTO;
import com.areeba.pos.entity.Discounts;
import com.areeba.pos.services.DiscountService;
import com.areeba.pos.services.Impl.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/discount"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class DiscountController {

    @Autowired
    private DiscountService discountService;
    @Autowired
    private DiscountServiceImpl discountServiceImpl;

    @GetMapping({"/id/{id}"})
    public Discounts getDiscount(@PathVariable long id) {
        return this.discountService.findById(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllDiscounts() {
        return this.discountService.getAll();
    }

    @GetMapping({"/name/{name}"})
    public Discounts getDiscountName(@PathVariable String name) {
        return this.discountService.findByName(name);
    }

    @PostMapping({"/create"})
    public Discounts createDiscount(@RequestBody DiscountDTO discountDTO) {
        return this.discountService.createDiscount(discountDTO);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateDiscount(@PathVariable("id") long id, @RequestBody DiscountDTO discountDTO) {
        return this.discountService.updateDiscount(id, discountDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteDiscount(@PathVariable("id") long id) {
        return this.discountService.deleteDiscount(id);
    }
}
