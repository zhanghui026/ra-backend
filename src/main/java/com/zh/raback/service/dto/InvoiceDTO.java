package com.zh.raback.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Invoice} entity.
 */
@ApiModel(description = "The Invoice entity.\n@author A true hipster")
public class InvoiceDTO implements Serializable {

    private Long id;

    private String date;

    private Long customerId;

    private Long commandId;

    private Float totalExTaxes;

    private Float deliveryFees;

    private Float taxRate;

    private Float taxes;

    private Float total;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InvoiceDTO invoiceDTO = (InvoiceDTO) o;
        if (invoiceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoiceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
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
