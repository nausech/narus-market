package com.narus.market.persistence.mapper;

import com.narus.market.domain.PurchaseDao;
import com.narus.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "IdPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "products", target = "items"),

    })
    PurchaseDao toPurchase(PurchaseEntity purchaseEntity);

    List<PurchaseDao> toPurchases(List<PurchaseEntity> purchaseEntities);


    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseDao purchaseDao);
}
