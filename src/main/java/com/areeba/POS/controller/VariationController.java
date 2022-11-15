package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.Variations;
import com.areeba.POS.services.Impl.VariationServiceImpl;
import com.areeba.POS.services.VariationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/variations"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class VariationController {

    @Autowired
    private final VariationServices variationServices;
    @Autowired
    private final VariationServiceImpl variationServicesImpl;

    public VariationController(VariationServices variationServices, VariationServiceImpl variationServiceImpl) {
        this.variationServices = variationServices;
        this.variationServicesImpl = variationServiceImpl;
    }

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

    @GetMapping({"/create"})
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
