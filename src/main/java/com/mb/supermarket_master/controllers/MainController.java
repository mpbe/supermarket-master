package com.mb.supermarket_master.controllers;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @GetMapping
    public String displayHomePage() {
        return "home.html";
    }

    @GetMapping("/list")
    public List<ProductDto> listAllProducts() {
        return productService.listAllProducts();
    }



}
