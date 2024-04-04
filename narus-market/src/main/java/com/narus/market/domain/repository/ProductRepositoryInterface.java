package com.narus.market.domain.repository;

import com.narus.market.domain.ProductDao;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {

    List<ProductDao> getAll();
    Optional<List<ProductDao>> getByCategory(int categoryId);
    Optional<List<ProductDao>> getScarseProducts(int quantity);
    Optional<ProductDao> getProduct(int productId);
    ProductDao save(ProductDao product);
    void delete(int productId);

}
