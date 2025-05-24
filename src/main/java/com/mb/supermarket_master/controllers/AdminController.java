package com.mb.supermarket_master.controllers;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

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

}
