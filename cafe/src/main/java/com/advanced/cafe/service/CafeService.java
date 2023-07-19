package com.advanced.cafe.service;

import com.advanced.cafe.DTO.ItemDTO;
import com.advanced.cafe.DTO.BeverageDTO;
import com.advanced.cafe.entity.Beverage;

import java.util.List;

public interface CafeService {
    Beverage getBeverage(BeverageDTO beverageDTO);
    List<BeverageDTO> getAllBeverage();
    void saveItem(ItemDTO itemDTO);
    int saveOrder();

}
