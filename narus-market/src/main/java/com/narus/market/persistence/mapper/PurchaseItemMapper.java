package com.narus.market.persistence.mapper;

import com.narus.market.domain.PurchaseItemDao;
import com.narus.market.persistence.entity.PurchasesProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
        @Mapping(source = "id.productId", target = "productId"),
        @Mapping(source = "status", target = "active")
    })
    PurchaseItemDao toPurchaseItem(PurchasesProductEntity productEntity);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "purchase", ignore = true),
        @Mapping(target = "product", ignore = true),
        @Mapping(target = "id.idPurchase", ignore = true),
    })

    PurchasesProductEntity toPurchasesProduct(PurchaseItemDao item);
}
