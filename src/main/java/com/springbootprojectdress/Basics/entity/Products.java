package com.springbootprojectdress.Basics.entity;

import com.springbootprojectdress.Basics.converter.ProductImageConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "categories")
    private String categories;

    @Column(name = "image", columnDefinition = "varchar(800)")
    @Convert(converter = ProductImageConverter.class)
    private List<String> productImage;

    @Column(name = "color")
    private String productColor;

    @Column(name = "type")
    private String productType;

    @Column(name = "gender")
    private String productGender;

    @Column(name = "discount")
    private int productDiscount;
}
