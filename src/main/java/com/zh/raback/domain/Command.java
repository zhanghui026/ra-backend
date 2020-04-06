package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * The Command entity.\n@author A true hipster
 */
@Entity
@Table(name = "command")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "date")
    private Instant date;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "basket")
    private String basket;

    @Column(name = "total_ex_taxes")
    private Float totalExTaxes;

    @Column(name = "delivery_fees")
    private Float deliveryFees;

    @Column(name = "tax_rate")
    private Float taxRate;

    @Column(name = "taxes")
    private Float taxes;

    @Column(name = "total")
    private Float total;

    @Column(name = "status")
    private String status;

    @Column(name = "returned")
    private Boolean returned;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public Command reference(String reference) {
        this.reference = reference;
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Instant getDate() {
        return date;
    }

    public Command date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Command customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getBasket() {
        return basket;
    }

    public Command basket(String basket) {
        this.basket = basket;
        return this;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }

    public Float getTotalExTaxes() {
        return totalExTaxes;
    }

    public Command totalExTaxes(Float totalExTaxes) {
        this.totalExTaxes = totalExTaxes;
        return this;
    }

    public void setTotalExTaxes(Float totalExTaxes) {
        this.totalExTaxes = totalExTaxes;
    }

    public Float getDeliveryFees() {
        return deliveryFees;
    }

    public Command deliveryFees(Float deliveryFees) {
        this.deliveryFees = deliveryFees;
        return this;
    }

    public void setDeliveryFees(Float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public Command taxRate(Float taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getTaxes() {
        return taxes;
    }

    public Command taxes(Float taxes) {
        this.taxes = taxes;
        return this;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public Float getTotal() {
        return total;
    }

    public Command total(Float total) {
        this.total = total;
        return this;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public Command status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isReturned() {
        return returned;
    }

    public Command returned(Boolean returned) {
        this.returned = returned;
        return this;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Command)) {
            return false;
        }
        return id != null && id.equals(((Command) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Command{" +
            "id=" + getId() +
            ", reference='" + getReference() + "'" +
            ", date='" + getDate() + "'" +
            ", customerId=" + getCustomerId() +
            ", basket='" + getBasket() + "'" +
            ", totalExTaxes=" + getTotalExTaxes() +
            ", deliveryFees=" + getDeliveryFees() +
            ", taxRate=" + getTaxRate() +
            ", taxes=" + getTaxes() +
            ", total=" + getTotal() +
            ", status='" + getStatus() + "'" +
            ", returned='" + isReturned() + "'" +
            "}";
    }
}
