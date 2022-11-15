package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.entity.User;
import com.areeba.POS.repository.BusinessRepository;
import com.areeba.POS.repository.UserRepository;
import com.areeba.POS.services.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        business.setUserId(businessDTO.getUserId());
        business.setItemId(businessDTO.getItemId());
        business.setName(businessDTO.getName());
        business.setType(businessDTO.getType());
        business.setCategory(businessDTO.getCategory());
        business.setAddress(businessDTO.getAddress());
        business.setCity(businessDTO.getCity());
        business.setPostalCode(businessDTO.getPostalCode());
        return businessRepository.save(business);
    }

    @Override
    public RestCommonResponse updateBusiness(long Id, BusinessDTO businessDTO) {
        if (this.businessRepository.findById(Id) != null) {
            Business businessById = this.businessRepository.findById(Id);
            businessById.setUserId(businessDTO.getUserId());
            businessById.setItemId(businessDTO.getItemId());
            businessById.setName(businessDTO.getName());
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
    public RestCommonResponse deleteBusiness(long Id) {
        if (this.businessRepository.findById(Id) != null) {
            this.businessRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse saveBusiness(BusinessDTO businessDTO, String name) {
        Business business = this.businessRepository.findByName(name);
        if (business == null) {
            log.info("Saving business to the database");
            return new RestCommonResponse(true, this.businessRepository.save(business));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public RestCommonResponse assignBusinessToUser(long userId, long businessId) {
        if (this.userRepository.findById(userId) != null) {
            User user = this.userRepository.findById(userId);
            Business business = this.businessRepository.findById(businessId);
            user.setBusinessId(business);
            return new RestCommonResponse(true, "Business Assigned");
        } else {
            return new RestCommonResponse(false, ErrorResponseApisEnum.DoesNotExist);
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
