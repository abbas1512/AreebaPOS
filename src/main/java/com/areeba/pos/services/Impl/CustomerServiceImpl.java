package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CustomerDTO;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.repository.CustomerRepository;
import com.areeba.pos.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(customerDTO, customers);
        return customerRepository.save(customers);
    }

    @Override
    public RestCommonResponse updateCustomer(long id, CustomerDTO customerDTO) {
        if (this.customerRepository.findById(id) != null) {
            Customers customerById = this.customerRepository.findById(id);
            BeanUtils.copyProperties(customerDTO, customerById);
            Customers updatedCustomer = this.customerRepository.save(customerById);
            return new RestCommonResponse(true, new Customers(
                    updatedCustomer.getSaleId(),
                    updatedCustomer.getFirstName(),
                    updatedCustomer.getLastName(),
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
    public RestCommonResponse deleteCustomer(long id) {
        if (this.customerRepository.findById(id) != null) {
            this.customerRepository.deleteById(id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public Customers findById(long id) {
        log.info("Fetching Customer");
        return this.customerRepository.findById(id);
    }

    @Override
    public Customers findByNumber(String phoneNumber) {
        log.info("Fetching Customer");
        return this.customerRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Customers");
        List<Customers> customers = this.customerRepository.findAll();
        return new RestCommonResponse(true, customers);
    }
}
