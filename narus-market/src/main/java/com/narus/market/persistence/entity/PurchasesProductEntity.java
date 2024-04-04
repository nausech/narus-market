package com.narus.market.persistence.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "compras_productos")
public class PurchasesProductEntity {

    @EmbeddedId
    private PurchasesProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity product;

    public PurchasesProductPK getId() {
        return id;
    }

    public void setId(PurchasesProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
