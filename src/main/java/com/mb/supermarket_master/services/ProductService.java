package com.mb.supermarket_master.services;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.domain.entities.Product;
import com.mb.supermarket_master.domain.entities.ProductCategory;

import java.util.List;

public interface ProductService {

    List<ProductDto> listAllProducts();
    ProductDto createNewProduct(ProductDto productDto);
    void deleteProduct(Long id);
    ProductDto fullUpdateProduct(Long id, ProductDto productDto);
    ProductDto findProductById(Long id);
    ProductDto partialUpdateProduct(Long id, ProductDto productDto);
    List<ProductDto> searchByName(String name);
    List<ProductDto> searchProducts(String searchTerm);
    List<ProductDto> search(String searchTerm, ProductCategory category, Double priceMin, Double priceMax);
}
