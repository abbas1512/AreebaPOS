package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.BusinessDTO;
import com.areeba.pos.entity.Business;
import com.areeba.pos.services.BusinessService;
import com.areeba.pos.services.Impl.BusinessServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/business")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private BusinessServiceImpl businessServiceImpl;

    @GetMapping({"/id/{id}"})
    public Business getBusiness(@PathVariable long id) {
        return this.businessService.getBusiness(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllBusiness() {
        return businessService.getAllBusiness();
    }

    @GetMapping({"name/{name}"})
    public Business getBusinessName(@PathVariable String name) {
        return this.businessService.getBusinessName(name);
    }

    @PostMapping({"/register"})
    public Business createBusiness(@RequestBody BusinessDTO businessDTO) {
        return this.businessService.createBusiness(businessDTO);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateBusiness(@PathVariable("id") long id, @RequestBody BusinessDTO businessDTO) {
        return this.businessService.updateBusiness(id, businessDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteBusiness(@PathVariable("id") long id) {
        return this.businessService.deleteBusiness(id);
    }
}
