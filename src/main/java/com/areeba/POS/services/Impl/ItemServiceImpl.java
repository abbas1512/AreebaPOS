package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.entity.Items;
import com.areeba.POS.repository.ItemRepository;
import com.areeba.POS.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createItem(ItemDTO itemDTO) {
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
        itemRepository.save(item);
    }

    @Override
    public void updateItem(ItemDTO itemDTO, long Id) {
        Items itemById = itemRepository.findById(Id);
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
        itemRepository.save(itemById);
    }

    @Override
    public void deleteItem(long Id) {
        itemRepository.deleteById(Id);
    }

    @Override
    public Items findById(long Id) {
        return itemRepository.findById(Id);
    }

    @Override
    public Items findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Items> getAll() {
        return itemRepository.findAll();
    }
}
