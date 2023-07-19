package com.advanced.cafe.entity;

import javax.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    private int tall;
    private int grande;
    private int venti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage)) return false;
        Beverage beverage = (Beverage) o;
        return id.equals(beverage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
