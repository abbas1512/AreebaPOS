package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.services.CustomerService;
import com.areeba.pos.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/customer"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public Customers getCustomer(long Id) {
        return this.customerService.findById(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllCustomers() {
        return this.customerService.getAll();
    }

    @GetMapping({"/name"})
    public Customers getCustomerName(String name) {
        return this.customerService.findByName(name);
    }

    @PostMapping({"/create"})
    public Customers createCustomer(CustomerDTO customerDTO) {
        return this.customerService.createCustomer(customerDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateCustomer(@PathVariable("Id") long Id, @RequestBody CustomerDTO customerDTO) {
        return this.customerService.updateCustomer(Id, customerDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteCustomer(@PathVariable("Id") long Id) {
        return this.customerService.deleteCustomer(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return this.customerService.saveCustomer(customerDTO, customerDTO.getName());
    }
}
