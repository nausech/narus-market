package com.narus.market.persistence.mapper;

import com.narus.market.domain.ProductDao;
import com.narus.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductDao toProductEntity(ProductEntity product);
    List<ProductDao> toProductsEntity(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductDao(ProductDao product);
}
