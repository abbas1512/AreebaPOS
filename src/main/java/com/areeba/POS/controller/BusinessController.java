package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.services.BusinessService;
import com.areeba.POS.services.Impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/business"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class BusinessController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final BusinessService businessService;
    @Autowired
    private final BusinessServiceImpl businessServiceImpl;

    public BusinessController(AuthenticationManager authenticationManager, BusinessService businessService, BusinessServiceImpl businessServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.businessService = businessService;
        this.businessServiceImpl = businessServiceImpl;
    }

    @GetMapping
    public Business getBusiness(long Id) {
        return this.businessService.getBusiness(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllBusiness() {
        return this.businessService.getAllBusiness();
    }

    @GetMapping({"/name"})
    public Business getBusinessName(String name) {
        return this.businessService.getBusinessName(name);
    }

    @GetMapping({"/register"})
    public Business createBusiness(BusinessDTO businessDTO) {
        return this.businessService.createBusiness(businessDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateBusiness(@PathVariable("Id") long Id, @RequestBody BusinessDTO businessDTO) {
        return this.businessService.updateBusiness(Id, businessDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteBusiness(@PathVariable("Id") long Id) {
        return this.businessService.deleteBusiness(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveBusiness(@RequestBody BusinessDTO businessDTO) {
        return this.businessService.saveBusiness(businessDTO, businessDTO.getName());
    }

//    @PostMapping
//    public RestCommonResponse assignBusinessToUser(@RequestBody BusinessToUserForm form) {
//        return this.businessService.assignBusinessToUser(form.getUserId(), form.getBusinessName());
//    }
}
