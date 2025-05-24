package com.mb.supermarket_master.mappers;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.domain.entities.Product;

public interface ProductMapper {

    Product mapFrom(ProductDto productDto);
    ProductDto mapTo(Product product);
}
