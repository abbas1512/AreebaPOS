package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;

public interface CustomerService {
    Customers createCustomer(CustomerDTO customerDTO);

    RestCommonResponse updateCustomer(long Id, CustomerDTO customerDTO);

    RestCommonResponse deleteCustomer(long Id);

    RestCommonResponse saveCustomer(CustomerDTO customerDTO, String name);

    Customers findById(long Id);

    Customers findByName(String name);

    RestCommonResponse getAll();

}
