package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.BusinessDTO;
import com.areeba.pos.entity.Business;
import com.areeba.pos.entity.User;
import com.areeba.pos.repository.BusinessRepository;
import com.areeba.pos.repository.UserRepository;
import com.areeba.pos.services.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("BusinessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private final BusinessRepository businessRepository;
    @Autowired
    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);

    public BusinessServiceImpl(BusinessRepository businessRepository, UserRepository userRepository) {
        this.businessRepository = businessRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Business createBusiness(BusinessDTO businessDTO) {
        Business business = new Business();
        BeanUtils.copyProperties(businessDTO, business);
        business.setUserId(userRepository.findById(businessDTO.getUserId()));
        return businessRepository.save(business);
    }

    @Override
    public RestCommonResponse updateBusiness(long id, BusinessDTO businessDTO) {
        if (this.businessRepository.findById(id) != null) {
            Business businessById = this.businessRepository.findById(id);
            User user = new User();
            user.setId(businessDTO.getId());
            businessById.setItemId(businessDTO.getItemId());
            businessById.setName(businessDTO.getName());
            businessById.setFirstName(businessDTO.getFirstName());
            businessById.setLastName(businessDTO.getLastName());
            businessById.setType(businessDTO.getType());
            businessById.setCategory(businessDTO.getCategory());
            businessById.setAddress(businessDTO.getAddress());
            businessById.setCity(businessDTO.getCity());
            businessById.setPostalCode(businessDTO.getPostalCode());
            Business updatedBusiness = this.businessRepository.save(businessById);
            return new RestCommonResponse(true, new Business(
                    updatedBusiness.getUserId(),
                    updatedBusiness.getItemId(),
                    updatedBusiness.getName(),
                    updatedBusiness.getFirstName(),
                    updatedBusiness.getLastName(),
                    updatedBusiness.getType(),
                    updatedBusiness.getCategory(),
                    updatedBusiness.getAddress(),
                    updatedBusiness.getCity(),
                    updatedBusiness.getPostalCode()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse deleteBusiness(long id) {
        if (this.businessRepository.findById(id) != null) {
            this.businessRepository.deleteById(id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public Business getBusiness(long businessId) {
        log.info("Fetching Business");
        return this.businessRepository.findById(businessId);
    }

    @Override
    public Business getBusinessName(String name) {
        log.info("Fetching Business");
        return this.businessRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAllBusiness() {
        log.info("Fetching All Business");
        List<Business> businesses = this.businessRepository.findAll();
        return new RestCommonResponse(true, businesses);
    }
}
