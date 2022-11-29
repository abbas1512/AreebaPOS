package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemDTO;
import com.areeba.pos.entity.Business;
import com.areeba.pos.entity.Items;
import com.areeba.pos.entity.User;
import com.areeba.pos.repository.BusinessRepository;
import com.areeba.pos.repository.ItemRepository;
import com.areeba.pos.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final BusinessRepository businessRepository;
    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    public ItemServiceImpl(ItemRepository itemRepository, BusinessRepository businessRepository) {
        this.itemRepository = itemRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public Items createItem(ItemDTO itemDTO) {
        Items item = new Items();
        BeanUtils.copyProperties(itemDTO, item);
        Business business = businessRepository.findById(itemDTO.getBusinessId());
        item.setBusinessId(business);
        return itemRepository.save(item);
    }

    @Override
    public RestCommonResponse updateItem(long id, ItemDTO itemDTO) {
        if (this.itemRepository.findById(id) != null) {
            Items itemById = this.itemRepository.findById(id);
            Business business = new Business();
            business.setId(itemDTO.getId());
            itemById.setTaxId(itemDTO.getTaxId());
            itemById.setCategory(itemDTO.getCategory());
            itemById.setName(itemDTO.getName());
            itemById.setImage(itemDTO.getImage());
            itemById.setSKU(itemDTO.getSKU());
            itemById.setUnit(itemDTO.getUnit());
            itemById.setPrice(itemDTO.getPrice());
            itemById.setStock(itemDTO.getStock());
            Items updatedItems = this.itemRepository.save(itemById);
            return new RestCommonResponse(true, new Items(
                    updatedItems.getBusinessId(),
                    updatedItems.getTaxId(),
                    updatedItems.getCategory(),
                    updatedItems.getName(),
                    updatedItems.getImage(),
                    updatedItems.getSKU(),
                    updatedItems.getUnit(),
                    updatedItems.getPrice(),
                    updatedItems.getStock()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public RestCommonResponse deleteItem(long id) {
        if (this.itemRepository.findById(id) != null) {
            this.itemRepository.deleteById(id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public Items getItem(long itemId) {
        log.info("Fetching Item");
        return this.itemRepository.findById(itemId);
    }

    @Override
    public Items getItemName(String name) {
        log.info("Fetching Item");
        return this.itemRepository.findByName(name);
    }

    @Override
    public Items getItemCategory(String category) {
        log.info("Fetching Item By Category");
        return this.itemRepository.findByCategory(category);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Items");
        List<Items> items = this.itemRepository.findAll();
        return new RestCommonResponse(true, items);
    }
}
