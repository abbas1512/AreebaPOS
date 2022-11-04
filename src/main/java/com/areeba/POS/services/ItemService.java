package com.areeba.POS.services;

import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.entity.Items;

import java.util.List;

public interface ItemService {

    void createItem(ItemDTO itemDTO);

    void updateItem(ItemDTO itemDTO, long Id);

    void deleteItem(long Id);

    Items findById(long Id);

    Items findByName(String name);

    List<Items> getAll();

}
