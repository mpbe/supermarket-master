package com.mb.supermarket_master.models;

import com.mb.supermarket_master.domain.entities.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchModel {

    private String searchTerm;
    private ProductCategory category;
    private Double priceMin;
    private Double priceMax;
}
