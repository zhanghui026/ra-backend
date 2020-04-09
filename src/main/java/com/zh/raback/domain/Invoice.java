package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Invoice entity.\n@author A true hipster
 */
@Entity
@Table(name = "invoice")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "command_id")
    private Long commandId;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Invoice date(Date date) {
        this.date = date;
        return this;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Invoice customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCommandId() {
        return commandId;
    }

    public Invoice commandId(Long commandId) {
        this.commandId = commandId;
        return this;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Float getTotalExTaxes() {
        return totalExTaxes;
    }

    public Invoice totalExTaxes(Float totalExTaxes) {
        this.totalExTaxes = totalExTaxes;
        return this;
    }

    public void setTotalExTaxes(Float totalExTaxes) {
        this.totalExTaxes = totalExTaxes;
    }

    public Float getDeliveryFees() {
        return deliveryFees;
    }

    public Invoice deliveryFees(Float deliveryFees) {
        this.deliveryFees = deliveryFees;
        return this;
    }

    public void setDeliveryFees(Float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public Invoice taxRate(Float taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getTaxes() {
        return taxes;
    }

    public Invoice taxes(Float taxes) {
        this.taxes = taxes;
        return this;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public Float getTotal() {
        return total;
    }

    public Invoice total(Float total) {
        this.total = total;
        return this;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Invoice)) {
            return false;
        }
        return id != null && id.equals(((Invoice) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", customerId=" + getCustomerId() +
            ", commandId=" + getCommandId() +
            ", totalExTaxes=" + getTotalExTaxes() +
            ", deliveryFees=" + getDeliveryFees() +
            ", taxRate=" + getTaxRate() +
            ", taxes=" + getTaxes() +
            ", total=" + getTotal() +
            "}";
    }
}
