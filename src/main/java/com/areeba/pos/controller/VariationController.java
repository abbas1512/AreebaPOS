package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.VariationDTO;
import com.areeba.pos.entity.Variations;
import com.areeba.pos.services.Impl.VariationServiceImpl;
import com.areeba.pos.services.VariationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/variations"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class VariationController {

    @Autowired
    private VariationServices variationServices;

    @Autowired
    private VariationServiceImpl variationServicesImpl;

    @GetMapping
    public Variations getVariation(long Id) {
        return this.variationServices.findById(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllVariations() {
        return this.variationServices.getAll();
    }

    @GetMapping({"/name"})
    public Variations getVariationName(String name) {
        return this.variationServices.findByName(name);
    }

    @PostMapping({"/create"})
    public Variations createVariation(VariationDTO variationDTO) {
        return this.variationServices.createVariation(variationDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateVariation(@PathVariable("Id") long Id, @RequestBody VariationDTO variationDTO) {
        return this.variationServices.updateVariation(Id, variationDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteVariation(@PathVariable("Id") long Id) {
        return this.variationServices.deleteVariation(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveVariation(@RequestBody VariationDTO variationDTO) {
        return this.variationServices.saveVariation(variationDTO, variationDTO.getName());
    }
}
