package com.teammansasung.careerbookapi.domain.company;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
