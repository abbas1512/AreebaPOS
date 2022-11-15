package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.DiscountDTO;
import com.areeba.POS.entity.Discounts;
import com.areeba.POS.services.DiscountService;
import com.areeba.POS.services.Impl.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/discount"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class DiscountController {

    @Autowired
    private final DiscountService discountService;
    @Autowired
    private final DiscountServiceImpl discountServiceImpl;

    public DiscountController(DiscountService discountService, DiscountServiceImpl discountServiceImpl) {
        this.discountService = discountService;
        this.discountServiceImpl = discountServiceImpl;
    }

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

    @GetMapping({"/create"})
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
