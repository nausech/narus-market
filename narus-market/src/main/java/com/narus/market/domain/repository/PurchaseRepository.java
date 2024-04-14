package com.narus.market.domain.repository;

import com.narus.market.domain.PurchaseDao;

import java.util.List;

public interface PurchaseRepository {
    List<PurchaseDao> getAll();
    List<PurchaseDao> getByClient(String clientId);
    PurchaseDao save(PurchaseDao purchase);
}
