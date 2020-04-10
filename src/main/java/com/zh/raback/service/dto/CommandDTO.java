package com.zh.raback.service.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.Instant;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Command} entity.
 */
@ApiModel(description = "The Command entity.\n@author A true hipster")
public class CommandDTO implements Serializable {

    @Data
    public static class Basket {
        private Long productId;
        private int quantity;
    }

    private Long id;

    private String reference;

    private String date;

    private Long customerId;

    private List<Basket> basket;

    private Float totalExTaxes;

    private Float deliveryFees;

    private Float taxRate;

    private Float taxes;

    private Float total;

    private String status;

    private Boolean returned;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Basket> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }

    public Float getTotalExTaxes() {
        return totalExTaxes;
    }

    public void setTotalExTaxes(Float totalExTaxes) {
        this.totalExTaxes = totalExTaxes;
    }

    public Float getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(Float deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommandDTO commandDTO = (CommandDTO) o;
        if (commandDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), commandDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommandDTO{" +
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
