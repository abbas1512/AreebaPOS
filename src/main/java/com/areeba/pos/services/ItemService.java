package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.ItemDTO;
import com.areeba.pos.entity.Items;

public interface ItemService {

    Items createItem(ItemDTO itemDTO);

    RestCommonResponse updateItem(long Id, ItemDTO itemDTO);

    RestCommonResponse deleteItem(long Id);

    RestCommonResponse saveItem(ItemDTO itemDTO, String name);

    Items getItem(long itemId);

    Items getItemName(String name);

    RestCommonResponse getAll();

}
