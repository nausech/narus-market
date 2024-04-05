package com.narus.market.domain.service;

import com.narus.market.domain.ProductDao;
import com.narus.market.domain.repository.ProductRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepositoryInterface productRepository;

    public ProductService(ProductRepositoryInterface productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDao> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDao> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public ProductDao save(ProductDao product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        Optional<ProductDao> product = productRepository.getProduct(productId);
        if (product.isEmpty()) {
            return false;
        } else {
            productRepository.delete(productId);
            return true;
        }
    }

    public Optional<List<ProductDao>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }
}
