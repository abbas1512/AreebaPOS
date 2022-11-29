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

    @GetMapping({"/id/{id}"})
    public Taxes getTax(@PathVariable long id) {
        return this.taxService.getTax(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllTaxes() {
        return this.taxService.getAllTaxes();
    }

    @GetMapping({"/name/{name}"})
    public Taxes getTaxName(@PathVariable String name) {
        return this.taxService.getTaxName(name);
    }

    @PostMapping({"/create"})
    public Taxes createTax(@RequestBody TaxDTO taxDTO) {
        return this.taxService.createTax(taxDTO);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateTax(@PathVariable("id") long id, @RequestBody TaxDTO taxDTO) {
        return this.taxService.updateTax(id, taxDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteTax(@PathVariable("id") long id) {
        return this.taxService.deleteTax(id);
    }

}
