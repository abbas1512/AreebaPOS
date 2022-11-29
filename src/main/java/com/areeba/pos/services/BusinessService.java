package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.BusinessDTO;
import com.areeba.pos.entity.Business;

public interface BusinessService {

    Business createBusiness(BusinessDTO businessDTO);

    RestCommonResponse updateBusiness(long id, BusinessDTO businessDTO);

    RestCommonResponse deleteBusiness(long id);

    Business getBusiness(long businessId);

    Business getBusinessName(String name);

    RestCommonResponse getAllBusiness();

}
