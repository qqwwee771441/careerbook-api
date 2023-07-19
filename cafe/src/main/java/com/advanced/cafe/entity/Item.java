package com.advanced.cafe.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Beverage beverage;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private int quantity;

    public int calculatePrice() {
        switch (size.toUpperCase()) {
            case "TALL": return beverage.getTall() * quantity;
            case "GRANDE": return beverage.getGrande() * quantity;
            case "VENTI": return beverage.getVenti() * quantity;
            default: return 0;
        }
    }
}
