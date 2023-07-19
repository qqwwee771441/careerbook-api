package com.advanced.cafe.controller;


import com.advanced.cafe.DTO.ItemDTO;
import com.advanced.cafe.DTO.BeverageDTO;
import com.advanced.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CafeController {
    CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("/all")
    public List<BeverageDTO> allBeverage() {
        return cafeService.getAllBeverage();
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody ItemDTO itemDTO) {
        cafeService.saveItem(itemDTO);
    }

    @PostMapping("/order")
    public String order() {
        int sum = cafeService.saveOrder();
        return "주문완료! " + sum + "원 입니다.";
    }
}
