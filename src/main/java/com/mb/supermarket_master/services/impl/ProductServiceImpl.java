package com.mb.supermarket_master.services.impl;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.domain.entities.Product;
import com.mb.supermarket_master.mappers.ProductMapper;
import com.mb.supermarket_master.repositories.ProductRepository;
import com.mb.supermarket_master.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> listAllProducts() {

        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> allProductsDto = new ArrayList<>();
        for (Product product : allProducts) {
            allProductsDto.add(productMapper.mapTo(product));
        }

        return allProductsDto;

    }

    @Override
    public ProductDto createNewProduct(ProductDto productDto) {

        //save the product in the database
        Product savedProduct = productRepository.save(productMapper.mapFrom(productDto));
        //TODO need to handle errors if ID is null, or my other non nullables

        //hand back the saved product
        return productMapper.mapTo(savedProduct);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto fullUpdateProduct(Long id, ProductDto productDto) {

        Product productToUpdate = productRepository.findById(id).orElseThrow();
        //TODO handle exceptions

        productToUpdate.setName(productDto.getName());
        productToUpdate.setDescription(productDto.getDescription());
        productToUpdate.setPrice(productDto.getPrice());
        productToUpdate.setCategory(productDto.getCategory());

        return productMapper.mapTo(productRepository.save(productToUpdate));

    }

    @Override
    public ProductDto findProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow();
        //TODO handle not found exception

        return productMapper.mapTo(product);

    }

    @Override
    @Transactional
    public ProductDto partialUpdateProduct(Long id, ProductDto productDto) {

        Product productToUpdate = productRepository.findById(id).orElseThrow();
        //todo exception

        if (productDto.getName() != null) {
            productToUpdate.setName(productDto.getName());
        }
        if (productDto.getCategory() != null) {
            productToUpdate.setCategory(productDto.getCategory());
        }
        if (productDto.getDescription() != null) {
            productToUpdate.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() != null) {
            productToUpdate.setPrice(productDto.getPrice());
        }
        if (productDto.getStock() != null) {
            productToUpdate.setStock(productDto.getStock());
        }
        Product savedProduct = productRepository.save(productToUpdate);

        return productMapper.mapTo(savedProduct);

    }
}
