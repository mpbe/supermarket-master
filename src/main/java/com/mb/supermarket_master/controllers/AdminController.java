package com.mb.supermarket_master.controllers;

import com.mb.supermarket_master.domain.dto.ProductDto;
import com.mb.supermarket_master.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    @GetMapping
    public String listAllProducts(Model model) {

        List<ProductDto> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "admin.html";

    }

    @PostMapping("/edit_form")
    public String editForm(ProductDto productDto, Model model) {


        model.addAttribute("product", productDto);
        return "edit_product.html";
    }

    @PostMapping("/patch_product")
    public String patchProduct(ProductDto productDto, Model model) {

        productService.partialUpdateProduct(productDto.getId(), productDto);

        List<ProductDto> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "admin.html";

    }

    @GetMapping("/delete_product")
    public String deleteProduct(ProductDto productDto, Model model) {

        productService.deleteProduct(productDto.getId());
        List<ProductDto> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "admin.html";
    }

    @GetMapping("/add_new_product")
    public String newProductForm(Model model, ProductDto productDto) {

        model.addAttribute("product", productDto);
        return "add_product.html";
    }

    @PostMapping("/add_new_product/new")
    public String addProduct(ProductDto productDto, Model model) {
        productService.createNewProduct(productDto);
        List<ProductDto> productDtoList = productService.listAllProducts();
        model.addAttribute("products", productDtoList);
        return "admin.html";
    }

}
