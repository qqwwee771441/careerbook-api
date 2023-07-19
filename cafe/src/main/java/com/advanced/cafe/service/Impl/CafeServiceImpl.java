package com.advanced.cafe.service.Impl;

import com.advanced.cafe.DTO.ItemDTO;
import com.advanced.cafe.DTO.BeverageDTO;
import com.advanced.cafe.entity.Beverage;
import com.advanced.cafe.entity.Item;
import com.advanced.cafe.entity.OrderList;
import com.advanced.cafe.repository.ItemRepository;
import com.advanced.cafe.repository.BeverageRepository;
import com.advanced.cafe.repository.OrderRepository;
import com.advanced.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CafeServiceImpl implements CafeService {
    private final ItemRepository itemRepository;
    private final BeverageRepository beverageRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public CafeServiceImpl(ItemRepository itemRepository, BeverageRepository beverageRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.beverageRepository = beverageRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Beverage getBeverage(BeverageDTO beverageDTO) {
        List<Beverage> beverages = beverageRepository.findAll();
        for(Beverage beverage : beverages) {
            if(beverageDTO.getName().equals(beverage.getName()) && beverageDTO.getType().equals(beverage.getType())) {
                return beverage;
            }
        }
        return null;
    }

    @Override
    public List<BeverageDTO> getAllBeverage() {
        List<Beverage> beverages = beverageRepository.findAll();
        List<BeverageDTO> beverageDTOS = new ArrayList<>();

        for(Beverage beverage : beverages) {
            BeverageDTO beverageDTO = new BeverageDTO();
            beverageDTO.setName(beverage.getName());
            beverageDTO.setType(beverage.getType());

            beverageDTOS.add(beverageDTO);
        }

        return beverageDTOS;
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        Beverage newBeverage = this.getBeverage(itemDTO.getBeverageDTO());
        Item newItem = new Item();
        newItem.setBeverage(newBeverage);
        newItem.setSize(itemDTO.getSize());
        newItem.setQuantity(itemDTO.getQuantity());

        itemRepository.save(newItem);
    }

    @Override
    public int saveOrder() {
        OrderList newOrder = new OrderList();
        newOrder.setItems(itemRepository.findAll());

        int sum = newOrder.sumPrice();

        orderRepository.save(newOrder);
        itemRepository.deleteAll();

        return sum;
    }

}
