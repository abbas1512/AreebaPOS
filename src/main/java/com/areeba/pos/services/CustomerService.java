package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;

public interface CustomerService {
    Customers createCustomer(CustomerDTO customerDTO);

    RestCommonResponse updateCustomer(long id, CustomerDTO customerDTO);

    RestCommonResponse deleteCustomer(long id);

    Customers findById(long id);

    Customers findByNumber(String phoneNumber);

    RestCommonResponse getAll();

}
