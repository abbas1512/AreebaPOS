package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CartDTO;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.entity.Items;
import com.areeba.pos.entity.Sales;
import com.areeba.pos.services.Impl.SaleServiceImpl;
import com.areeba.pos.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/sale"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SaleServiceImpl saleServiceImpl;

    @PostMapping({"/addItem"})
    public Cart addItem(@RequestBody CartDTO cartDTO) {
        return this.saleService.addItem(cartDTO);
    }

    @DeleteMapping({"/removeItem/{id}"})
    public RestCommonResponse removeItem(@PathVariable("id") long id) {
        return this.saleService.removeItem(id);
    }

    @GetMapping({"/viewCart/{cartId}"})
    public Cart viewCart(@PathVariable long cartId) {
        return this.saleService.viewCart(cartId);
    }

    @PostMapping({"/create"})
    public Sales createSale(@RequestBody SaleDTO saleDTO) {
        return this.saleService.createSale(saleDTO);
    }

    @DeleteMapping({"/cancel/{id}"})
    public RestCommonResponse cancelSale(@PathVariable("id") long id) {
        return this.saleService.cancelSale(id);
    }

    @GetMapping({"/id/{id}"})
    public Sales getSale(@PathVariable long id) {
        return this.saleService.getSale(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllSales() {
        return this.saleService.getAllSales();
    }
}
