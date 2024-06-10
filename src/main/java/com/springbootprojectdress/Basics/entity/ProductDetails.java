package com.springbootprojectdress.Basics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {

    private Products products;

    private List<ProductSize> productSize;
}
