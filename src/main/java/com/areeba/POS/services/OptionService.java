package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.entity.OptionVariations;
import com.areeba.POS.entity.Options;

import java.util.List;

public interface OptionService {

    Options createOption(OptionDTO optionDTO);

    RestCommonResponse updateOption(long Id, OptionDTO optionDTO);

    RestCommonResponse deleteOption(long Id);

    RestCommonResponse saveOption(OptionDTO optionDTO, String name);

    Options findById(long Id);

    Options findByName(String name);

    RestCommonResponse getAll();

}
