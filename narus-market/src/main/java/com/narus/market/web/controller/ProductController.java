package com.narus.market.web.controller;

import com.narus.market.domain.ProductDao;
import com.narus.market.domain.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDao> getAll() {
        return productService.getAll();
    }

    public Optional<ProductDao> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    public ProductDao save(ProductDao product) {
        return productService.save(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }

    public Optional<List<ProductDao>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId);
    }
}
