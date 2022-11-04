package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.entity.OptionVariations;
import com.areeba.POS.entity.Options;
import com.areeba.POS.repository.OptionRepository;
import com.areeba.POS.repository.OptionVariationRepository;
import com.areeba.POS.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OptionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    OptionVariationRepository optionVariationRepository;

    @Override
    public void createOption(OptionDTO optionDTO) throws Exception {
        Options options = new Options();
        options.setOptionVariationId(optionDTO.getOptionVariationId());
        options.setName(optionDTO.getName());
        optionRepository.save(options);
    }

    @Override
    public void createOptionVariation(OptionVariationDTO optionVariationDTO) throws Exception {
        OptionVariations optionVariations = new OptionVariations();
        optionVariations.setVariationId(optionVariationDTO.getVariationId());
        optionVariations.setOptionId(optionVariationDTO.getOptionId());
        optionVariations.setName(optionVariationDTO.getName());
        optionVariationRepository.save(optionVariations);
    }

    @Override
    public void updateOption(OptionDTO optionDTO, long Id) {
        Options optionById = optionRepository.findById(Id);
        optionById.setOptionVariationId(optionDTO.getOptionVariationId());
        optionById.setName(optionDTO.getName());
        optionRepository.save(optionById);
    }

    @Override
    public void updateOptionVariation(OptionVariationDTO optionVariationDTO, long Id) {
        OptionVariations optionVariationById = optionVariationRepository.findById(Id);
        optionVariationById.setVariationId(optionVariationDTO.getVariationId());
        optionVariationById.setOptionId(optionVariationDTO.getOptionId());
        optionVariationById.setName(optionVariationDTO.getName());
        optionVariationRepository.save(optionVariationById);
    }

    @Override
    public void deleteOption(long Id) {
        optionRepository.deleteById(Id);
    }

    @Override
    public void deleteOptionVariation(long Id) {
        optionVariationRepository.deleteById(Id);
    }

    @Override
    public Options findById(long Id) {
        return optionRepository.findById(Id);
    }

    @Override
    public OptionVariations findOptionVariationById(long Id) {
        return optionVariationRepository.findById(Id);
    }

    @Override
    public Options findByName(String name) {
        return optionRepository.findByName(name);
    }

    @Override
    public OptionVariations findOptionVariationByName(String name) {
        return optionVariationRepository.findByName(name);
    }

    @Override
    public List<Options> getAll() {
        return optionRepository.findAll();
    }

    @Override
    public List<OptionVariations> getAllOptionVariations() {
        return optionVariationRepository.findAll();
    }

}
