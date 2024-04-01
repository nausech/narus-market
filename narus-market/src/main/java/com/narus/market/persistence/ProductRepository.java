package com.narus.market.persistence;

import com.narus.market.persistence.crud.ProductCrudRepository;
import com.narus.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int categoryId){
        return  productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
    }

    public Optional<List<Product>> getShortage(int quantity){
        return productCrudRepository.findByStockLessThanAndStatus(quantity, true);
    }

    public Optional<Product> getProduct(int productId){
        return productCrudRepository.findById(productId);
    }

    public Product save(Product product){
        return productCrudRepository.save(product);
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }



}
