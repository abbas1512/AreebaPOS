package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemDTO;
import com.areeba.pos.entity.Items;

public interface ItemService {

    Items createItem(ItemDTO itemDTO);

    RestCommonResponse updateItem(long id, ItemDTO itemDTO);

    RestCommonResponse deleteItem(long id);

    Items getItem(long itemId);

    Items getItemName(String name);

    Items getItemCategory(String category);

    RestCommonResponse getAll();

}
