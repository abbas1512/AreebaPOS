package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemSaleDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.ItemSales;
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

    @GetMapping
    public Sales getSale(long Id) {
        return this.saleService.getSale(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllSales() {
        return this.saleService.getAllSales();
    }

    @PostMapping({"/addItem"})
    public ItemSales addItem(ItemSaleDTO itemSaleDTO) {
        return this.saleService.addItem(itemSaleDTO);
    }

    @DeleteMapping({"/removeItem/{Id}"})
    public RestCommonResponse removeItem(@PathVariable("Id") long Id) {
        return this.saleService.removeItem(Id);
    }

    @GetMapping({"/create"})
    public Sales createSale(SaleDTO saleDTO) {
        return this.saleService.createSale(saleDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse cancelSale(@PathVariable("Id") long Id) {
        return this.saleService.cancelSale(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse confirmSale(@RequestBody SaleDTO saleDTO) {
        return this.saleService.confirmSale(saleDTO, saleDTO.getId());
    }
}
