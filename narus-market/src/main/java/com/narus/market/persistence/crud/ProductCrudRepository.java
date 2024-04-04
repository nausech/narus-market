package com.narus.market.persistence.crud;

import com.narus.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<ProductEntity>> findByStockLessThanAndStatus(int stock, boolean status);
}
