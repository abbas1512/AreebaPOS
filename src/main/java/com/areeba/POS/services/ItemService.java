package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemDTO;
import com.areeba.POS.entity.Items;

public interface ItemService {

    Items createItem(ItemDTO itemDTO);

    RestCommonResponse updateItem(long Id, ItemDTO itemDTO);

    RestCommonResponse deleteItem(long Id);

    RestCommonResponse saveItem(ItemDTO itemDTO, String name);

    Items getItem(long itemId);

    Items getItemName(String name);

    RestCommonResponse getAll();

}
