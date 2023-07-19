package com.advanced.cafe.entity;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<Item> items = new ArrayList<>();

    public int sumPrice() {
        int sum = 0;
        for(Item item : items) {
            sum += item.calculatePrice();
        }
        return sum;
    }

}
