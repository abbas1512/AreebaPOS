package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/customer"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping({"/id/{id}"})
    public Customers getCustomer(@PathVariable long id) {
        return this.customerService.findById(id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllCustomers() {
        return this.customerService.getAll();
    }

    @GetMapping({"/phoneNumber/{phoneNumber}"})
    public Customers getCustomerPhone(@PathVariable String phoneNumber) {
        return this.customerService.findByNumber(phoneNumber);
    }

    @PostMapping({"/create"})
    public Customers createCustomer(@RequestBody CustomerDTO customerDTO) {
        return this.customerService.createCustomer(customerDTO);
    }

    @PutMapping(value = {"/update/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDTO customerDTO) {
        return this.customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping({"/delete/{id}"})
    public RestCommonResponse deleteCustomer(@PathVariable("id") long id) {
        return this.customerService.deleteCustomer(id);
    }
}
