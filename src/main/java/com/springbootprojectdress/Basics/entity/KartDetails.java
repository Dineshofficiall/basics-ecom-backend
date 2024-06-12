package com.springbootprojectdress.Basics.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KartDetails {

    private Long kartId;

    private Long userId;

    private Products products;

    private ProductSize productSize;

    private KartQuantity kartQuantity;

}
