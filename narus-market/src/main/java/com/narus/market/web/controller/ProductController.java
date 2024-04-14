package com.narus.market.web.controller;

import com.narus.market.domain.ProductDao;
import com.narus.market.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<ProductDao>> getAll() {
        return new ResponseEntity<>(productService.getAll(), null, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDao> getProduct(@PathVariable int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductDao> save(@RequestBody  ProductDao product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDao>> getByCategory(@PathVariable int categoryId) {
        return productService.getByCategory(categoryId);
    }
}
