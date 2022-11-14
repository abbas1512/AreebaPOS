package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemSaleDTO;
import com.areeba.POS.dto.SaleDTO;
import com.areeba.POS.entity.ItemSales;
import com.areeba.POS.entity.Sales;
import com.areeba.POS.services.Impl.SaleServiceImpl;
import com.areeba.POS.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/sale"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class SaleController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final SaleService saleService;
    @Autowired
    private final SaleServiceImpl saleServiceImpl;

    public SaleController(AuthenticationManager authenticationManager, SaleService saleService, SaleServiceImpl saleServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.saleService = saleService;
        this.saleServiceImpl = saleServiceImpl;
    }

    @GetMapping
    public Sales getSale(long Id) {
        return this.saleService.getSale(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllSales() {
        return this.saleService.getAllSales();
    }

    @GetMapping({"/addItem"})
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
