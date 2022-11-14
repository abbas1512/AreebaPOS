package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.BusinessDTO;
import com.areeba.POS.entity.Business;

public interface BusinessService {

    Business createBusiness(BusinessDTO businessDTO);

    RestCommonResponse updateBusiness(long Id, BusinessDTO businessDTO);

    RestCommonResponse deleteBusiness(long Id);

    RestCommonResponse saveBusiness(BusinessDTO businessDTO, String name);

    RestCommonResponse assignBusinessToUser(long userId, long businessId);

    Business getBusiness(long businessId);

    Business getBusinessName(String name);

    RestCommonResponse getAllBusiness();

}
