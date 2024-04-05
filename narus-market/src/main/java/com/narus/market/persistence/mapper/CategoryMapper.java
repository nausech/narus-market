package com.narus.market.persistence.mapper;

import com.narus.market.domain.CategoryDao;
import com.narus.market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "name", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    CategoryDao toCategoryEntity(CategoryEntity categoryEntity);
    @InheritInverseConfiguration
    CategoryEntity toCategoryDao(CategoryDao category);
}
