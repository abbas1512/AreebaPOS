package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CartDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.Cart;
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

    @DeleteMapping({"/removeItem/{cartId}"})
    public RestCommonResponse removeItem(@PathVariable("cartId") long cartId) {
        return this.saleService.removeItem(cartId);
    }

    @GetMapping({"/viewCart/{id}"})
    public Cart viewCart(@PathVariable("id") long id) {
        return this.saleService.viewCart(id);
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
    public Sales getSale(@PathVariable("id") long id) {
        return this.saleService.getSale(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllSales() {
        return this.saleService.getAllSales();
    }
}
