package com.mb.supermarket_master.mappers.impl;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.domain.entities.Product;
import com.mb.supermarket_master.mappers.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapFrom(ProductDto productDto) {

        return new Product(
            null,
            productDto.getName(),
            productDto.getDescription(),
            productDto.getPrice(),
            productDto.getCategory(),
            productDto.getStock()

        );

    }

    @Override
    public ProductDto mapTo(Product product) {

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getStock()
        );

    }
}
