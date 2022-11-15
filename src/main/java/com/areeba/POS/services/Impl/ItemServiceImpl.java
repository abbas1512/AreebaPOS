package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.entity.*;
import com.areeba.POS.repository.ItemRepository;
import com.areeba.POS.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;
    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Items createItem(ItemDTO itemDTO) {
        Items item = new Items();
        item.setBusinessId(itemDTO.getBusinessId());
        item.setCategoryId(itemDTO.getCategoryId());
        item.setVariationId(itemDTO.getVariationId());
        item.setTaxId(itemDTO.getTaxId());
        item.setItemSaleId(itemDTO.getItemSaleId());
        item.setName(itemDTO.getName());
        item.setImage(itemDTO.getImage());
        item.setSKU(itemDTO.getSKU());
        item.setUnit(itemDTO.getUnit());
        item.setPrice(itemDTO.getPrice());
        item.setStock(itemDTO.getStock());
        return itemRepository.save(item);
    }

    @Override
    public RestCommonResponse updateItem(long Id, ItemDTO itemDTO) {
        if (this.itemRepository.findById(Id) != null) {
            Items itemById = this.itemRepository.findById(Id);
            itemById.setBusinessId(itemDTO.getBusinessId());
            itemById.setCategoryId(itemDTO.getCategoryId());
            itemById.setVariationId(itemDTO.getVariationId());
            itemById.setTaxId(itemDTO.getTaxId());
            itemById.setItemSaleId(itemDTO.getItemSaleId());
            itemById.setName(itemDTO.getName());
            itemById.setImage(itemDTO.getImage());
            itemById.setSKU(itemDTO.getSKU());
            itemById.setUnit(itemDTO.getUnit());
            itemById.setPrice(itemDTO.getPrice());
            itemById.setStock(itemDTO.getStock());
            Items updatedItems = this.itemRepository.save(itemById);
            return new RestCommonResponse(true, new Items(
                    updatedItems.getBusinessId(),
                    updatedItems.getCategoryId(),
                    updatedItems.getVariationId(),
                    updatedItems.getTaxId(),
                    updatedItems.getItemSaleId(),
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
    public RestCommonResponse deleteItem(long Id) {
        if (this.itemRepository.findById(Id) != null) {
            this.itemRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public RestCommonResponse saveItem(ItemDTO itemDTO, String name) {
        Items items = this.itemRepository.findByName(name);
        if (items == null) {
            log.info("Saving item to the database");
            return new RestCommonResponse(true, this.itemRepository.save(items));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
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
    public RestCommonResponse getAll() {
        log.info("Fetching All Items");
        List<Items> items = this.itemRepository.findAll();
        return new RestCommonResponse(true, items);
    }
}
