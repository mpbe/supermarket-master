package com.mb.supermarket_master.domain.dto;


import com.mb.supermarket_master.domain.entities.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private ProductCategory category;
    private Integer stock;
}
