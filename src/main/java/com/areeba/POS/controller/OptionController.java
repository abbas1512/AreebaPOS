package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.entity.*;
import com.areeba.POS.entity.Options;
import com.areeba.POS.services.Impl.OptionServiceImpl;
import com.areeba.POS.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/option"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class OptionController {
    @Autowired
    private final OptionService optionService;
    @Autowired
    private final OptionServiceImpl optionServiceImpl;

    public OptionController(OptionService optionService, OptionServiceImpl optionServiceImpl) {
        this.optionService = optionService;
        this.optionServiceImpl = optionServiceImpl;
    }

    @GetMapping
    public Options getOption(long Id) {
        return this.optionService.getOption(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllOptions() {
        return this.optionService.getAllOptions();
    }

    @GetMapping({"/name"})
    public Options getOptionName(String name) {
        return this.optionService.getOptionName(name);
    }

    @GetMapping({"/create"})
    public Options createOption(OptionDTO optionDTO) {
        return this.optionService.createOption(optionDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateOption(@PathVariable("Id") long Id, @RequestBody OptionDTO optionDTO) {
        return this.optionService.updateOption(Id, optionDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteOption(@PathVariable("Id") long Id) {
        return this.optionService.deleteOption(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveOption(@RequestBody OptionDTO optionDTO) {
        return this.optionService.saveOption(optionDTO, optionDTO.getName());
    }

    @GetMapping({"/variation"})
    public OptionVariations getVariation(long Id) {
        return this.optionService.getVariation(Id);
    }

    @GetMapping({"/variation/all"})
    public RestCommonResponse getAllVariations() {
        return this.optionService.getAllVariations();
    }

    @GetMapping({"/variation/name"})
    public OptionVariations getVariationName(String name) {
        return this.optionService.getVariationName(name);
    }

    @GetMapping({"/variation/create"})
    public OptionVariations createVariation(OptionVariationDTO optionVariationDTO) {
        return this.optionService.createVariation(optionVariationDTO);
    }

    @PutMapping(value = {"/variation/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateVariation(@PathVariable("Id") long Id, @RequestBody OptionVariationDTO optionVariationDTO) {
        return this.optionService.updateVariation(Id, optionVariationDTO);
    }

    @DeleteMapping({"/variation/{Id}"})
    public RestCommonResponse deleteVariation(@PathVariable("Id") long Id) {
        return this.optionService.deleteVariation(Id);
    }

    @PostMapping({"/variation/save"})
    public RestCommonResponse saveVariation(@RequestBody OptionVariationDTO optionVariationDTO) {
        return this.optionService.saveVariation(optionVariationDTO, optionVariationDTO.getName());
    }
}
