package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.entity.Business;
import com.areeba.POS.repository.BusinessRepository;
import com.areeba.POS.services.BusinessService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("BusinessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private final BusinessRepository businessRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(BusinessServiceImpl.class);

    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
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
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteBusiness(long Id) {
        if (this.businessRepository.findById(Id) != null) {
            this.businessRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
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
    public Business findById(long Id) {
        log.info("Fetching Business");
        return this.businessRepository.findById(Id);
    }

    @Override
    public Business findByName(String name) {
        log.info("Fetching Business");
        return this.businessRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Businesses");
        List<Business> business = this.businessRepository.findAll();
        return new RestCommonResponse(true, business);
    }
}
