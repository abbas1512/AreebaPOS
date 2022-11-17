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

    @GetMapping
    public Discounts getDiscount(long Id) {
        return this.discountService.findById(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllDiscounts() {
        return this.discountService.getAll();
    }

    @GetMapping({"/name"})
    public Discounts getDiscountName(String name) {
        return this.discountService.findByName(name);
    }

    @PostMapping({"/create"})
    public Discounts createDiscount(DiscountDTO discountDTO) {
        return this.discountService.createDiscount(discountDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateDiscount(@PathVariable("Id") long Id, @RequestBody DiscountDTO discountDTO) {
        return this.discountService.updateDiscount(Id, discountDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteDiscount(@PathVariable("Id") long Id) {
        return this.discountService.deleteDiscount(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveDiscount(@RequestBody DiscountDTO discountDTO) {
        return this.discountService.saveDiscount(discountDTO, discountDTO.getName());
    }
}
