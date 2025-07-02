package com.mb.supermarket_master.services;

import com.mb.supermarket_master.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> listAllProducts();
    ProductDto createNewProduct(ProductDto productDto);
    void deleteProduct(Long id);
    ProductDto fullUpdateProduct(Long id, ProductDto productDto);
    ProductDto findProductById(Long id);
    ProductDto partialUpdateProduct(Long id, ProductDto productDto);
}
