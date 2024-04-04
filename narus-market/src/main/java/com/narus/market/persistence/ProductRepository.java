package com.narus.market.persistence;

import com.narus.market.domain.ProductDao;
import com.narus.market.domain.repository.ProductRepositoryInterface;
import com.narus.market.persistence.crud.ProductCrudRepository;
import com.narus.market.persistence.entity.ProductEntity;
import com.narus.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDao> getAll() {
        List<ProductEntity> product = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProductsEntity(product);
    }

    @Override
    public Optional<List<ProductDao>> getByCategory(int categoryId) {
        List<ProductEntity> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsEntity(products));
    }

    @Override
    public Optional<List<ProductDao>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProductsEntity(prods));
    }

    @Override
    public Optional<ProductDao> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductEntity(product));
    }

    @Override
    public ProductDao save(ProductDao product) {
        ProductEntity productEntity = mapper.toProductDao(product);
        return mapper.toProductEntity(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}