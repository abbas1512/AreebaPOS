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

@RestController
@RequestMapping("/business")
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@Api(tags = "business controller")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private BusinessServiceImpl businessServiceImpl;

    @GetMapping
    public Business getBusiness(long Id) {
        return this.businessService.getBusiness(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllBusiness() {
        return businessService.getAllBusiness();
    }

    @GetMapping({"/name"})
    public Business getBusinessName(String name) {
        return this.businessService.getBusinessName(name);
    }

    @PostMapping({"/register"})
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
