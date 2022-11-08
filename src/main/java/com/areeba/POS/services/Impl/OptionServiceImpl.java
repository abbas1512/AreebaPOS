package com.areeba.POS.services.Impl;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.entity.Options;
import com.areeba.POS.repository.OptionRepository;
import com.areeba.POS.repository.OptionVariationRepository;
import com.areeba.POS.services.OptionService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("OptionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;
    @Autowired
    private final OptionVariationRepository optionVariationRepository;

    private static final Logger log = (Logger) LoggerFactory.getLogger(OptionServiceImpl.class);

    public OptionServiceImpl(OptionVariationRepository optionVariationRepository) {
        this.optionVariationRepository = optionVariationRepository;
    }

    @Override
    public Options createOption(OptionDTO optionDTO){
        Options options = new Options();
        options.setOptionVariationId(optionDTO.getOptionVariationId());
        options.setName(optionDTO.getName());
        return optionRepository.save(options);
    }

    @Override
    public RestCommonResponse updateOption(long Id, OptionDTO optionDTO) {
        return null;
    }

    @Override
    public RestCommonResponse deleteOption(long Id) {
        return null;
    }

    @Override
    public RestCommonResponse saveOption(OptionDTO optionDTO, String name) {
        return null;
    }

    @Override
    public Options findById(long Id) {
        return null;
    }

    @Override
    public Options findByName(String name) {
        return null;
    }

    @Override
    public RestCommonResponse getAll() {
        return null;
    }
}
