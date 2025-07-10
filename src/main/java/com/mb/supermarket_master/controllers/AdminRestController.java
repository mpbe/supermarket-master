package com.mb.supermarket_master.controllers;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AdminRestController {

    private final ProductService productService;

    @GetMapping("/list")
    public List<ProductDto> listAllProductsAdmin() {
        return productService.listAllProducts();
    }

    @PostMapping("/new_product")
    public ProductDto createNewProduct(@RequestBody ProductDto productDto) {
        return productService.createNewProduct(productDto);
    }

    @DeleteMapping("/delete_product/{id}")
    public void deleteProductById(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/update_product/{id}")
    public ProductDto fullUpdateProduct(@PathVariable(name = "id")Long id,
                                        @RequestBody ProductDto productDto) {

        return productService.fullUpdateProduct(id, productDto);
    }


    @GetMapping("/search/{id}")
    public ProductDto findProductById(@PathVariable(name = "id") Long id) {
        return productService.findProductById(id);
    }

    @PutMapping("patch_product/{id}")
    public ProductDto partialUpdateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductDto productDto) {
        return productService.partialUpdateProduct(id, productDto);
    }

}

