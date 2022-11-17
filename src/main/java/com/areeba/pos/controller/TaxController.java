package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.TaxDTO;
import com.areeba.pos.entity.Taxes;
import com.areeba.pos.services.Impl.TaxServiceImpl;
import com.areeba.pos.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/tax"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class TaxController {

    @Autowired
    private TaxService taxService;

    @Autowired
    private TaxServiceImpl taxServiceImpl;

    @GetMapping
    public Taxes getTax(long Id) {
        return this.taxService.getTax(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllTaxes() {
        return this.taxService.getAllTaxes();
    }

    @GetMapping({"/name"})
    public Taxes getTaxName(String name) {
        return this.taxService.getTaxName(name);
    }

    @PostMapping({"/create"})
    public Taxes createTax(TaxDTO taxDTO) {
        return this.taxService.createTax(taxDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateTax(@PathVariable("Id") long Id, @RequestBody TaxDTO taxDTO) {
        return this.taxService.updateTax(Id, taxDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteTax(@PathVariable("Id") long Id) {
        return this.taxService.deleteTax(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveTax(@RequestBody TaxDTO taxDTO) {
        return this.taxService.saveTax(taxDTO, taxDTO.getName());
    }
}
