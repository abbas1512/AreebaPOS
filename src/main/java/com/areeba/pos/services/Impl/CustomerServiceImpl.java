package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.repository.CustomerRepository;
import com.areeba.pos.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;
    private final Logger log = LoggerFactory.getLogger(DiscountServiceImpl.class);

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customers createCustomer(CustomerDTO customerDTO) {
        Customers customers = new Customers();
        customers.setSaleId(customerDTO.getSaleId());
        customers.setName(customerDTO.getName());
        customers.setPhoneNumber(customerDTO.getPhoneNumber());
        customers.setEmail(customerDTO.getEmail());
        customers.setAddress(customerDTO.getAddress());
        customers.setCompany(customerDTO.getCompany());
        customers.setBirthday(customerDTO.getBirthday());
        return customerRepository.save(customers);
    }

    @Override
    public RestCommonResponse updateCustomer(long Id, CustomerDTO customerDTO) {
        if (this.customerRepository.findById(Id) != null) {
            Customers customerById = this.customerRepository.findById(Id);
            customerById.setSaleId(customerDTO.getSaleId());
            customerById.setName(customerDTO.getName());
            customerById.setPhoneNumber(customerDTO.getPhoneNumber());
            customerById.setEmail(customerDTO.getEmail());
            customerById.setAddress(customerDTO.getAddress());
            customerById.setCompany(customerDTO.getCompany());
            customerById.setBirthday(customerDTO.getBirthday());
            Customers updatedCustomer = this.customerRepository.save(customerById);
            return new RestCommonResponse(true, new Customers(
                    updatedCustomer.getSaleId(),
                    updatedCustomer.getName(),
                    updatedCustomer.getPhoneNumber(),
                    updatedCustomer.getEmail(),
                    updatedCustomer.getAddress(),
                    updatedCustomer.getCompany(),
                    updatedCustomer.getBirthday()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse deleteCustomer(long Id) {
        if (this.customerRepository.findById(Id) != null) {
            this.customerRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse saveCustomer(CustomerDTO customerDTO, String name) {
        Customers customer = this.customerRepository.findByName(name);
        if (customer == null) {
            log.info("Saving customer to the database");
            return new RestCommonResponse(true, this.customerRepository.save(customer));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Customers findById(long Id) {
        log.info("Fetching Customer");
        return this.customerRepository.findById(Id);
    }

    @Override
    public Customers findByName(String name) {
        log.info("Fetching Customer");
        return this.customerRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Customers");
        List<Customers> customers = this.customerRepository.findAll();
        return new RestCommonResponse(true, customers);
    }
}
