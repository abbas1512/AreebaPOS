package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.OptionDTO;
import com.areeba.pos.dto.OptionVariationDTO;
import com.areeba.pos.entity.OptionVariations;
import com.areeba.pos.entity.Options;
import com.areeba.pos.services.Impl.OptionServiceImpl;
import com.areeba.pos.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/option"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class OptionController {

    @Autowired
    private OptionService optionService;

    @Autowired
    private OptionServiceImpl optionServiceImpl;

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

    @PostMapping({"/create"})
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
