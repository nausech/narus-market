package com.narus.market.persistence.crud;

import com.narus.market.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {

}
