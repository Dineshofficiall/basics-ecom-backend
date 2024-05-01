package com.springbootprojectdress.Basics.entity;

import jakarta.persistence.*;

@Entity
public class Kart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "user_id")
    private Long user_id;
}
