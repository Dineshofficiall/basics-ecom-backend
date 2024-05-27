package com.springbootprojectdress.Basics.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KartDetails {

    private Long userId;

    private Products products;

    private Long kartId;
}
