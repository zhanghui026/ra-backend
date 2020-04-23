package com.zh.raback.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Museum} entity.
 */
@ApiModel(description = "The 艺术馆\n@author A true hipster")
public class MuseumDTO implements Serializable {
    
    private Long id;

    /**
     * name
     */
    @NotNull
    @ApiModelProperty(value = "name", required = true)
    private String name;

    private String rsName;

    private String enName;

    private String fullName;

    private String rsFullName;

    private String enFullName;

    private String address;

    private String rsAddress;

    private String enAddress;

    private String brief;

    private String enBrief;

    private String rsBrief;

    private String phoneNum;

    private String contactPerson;

    private LocalDate createDate;

    private LocalDate updateDate;

    private String mainImg;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRsName() {
        return rsName;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRsFullName() {
        return rsFullName;
    }

    public void setRsFullName(String rsFullName) {
        this.rsFullName = rsFullName;
    }

    public String getEnFullName() {
        return enFullName;
    }

    public void setEnFullName(String enFullName) {
        this.enFullName = enFullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRsAddress() {
        return rsAddress;
    }

    public void setRsAddress(String rsAddress) {
        this.rsAddress = rsAddress;
    }

    public String getEnAddress() {
        return enAddress;
    }

    public void setEnAddress(String enAddress) {
        this.enAddress = enAddress;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getEnBrief() {
        return enBrief;
    }

    public void setEnBrief(String enBrief) {
        this.enBrief = enBrief;
    }

    public String getRsBrief() {
        return rsBrief;
    }

    public void setRsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MuseumDTO museumDTO = (MuseumDTO) o;
        if (museumDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), museumDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MuseumDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", rsName='" + getRsName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", rsFullName='" + getRsFullName() + "'" +
            ", enFullName='" + getEnFullName() + "'" +
            ", address='" + getAddress() + "'" +
            ", rsAddress='" + getRsAddress() + "'" +
            ", enAddress='" + getEnAddress() + "'" +
            ", brief='" + getBrief() + "'" +
            ", enBrief='" + getEnBrief() + "'" +
            ", rsBrief='" + getRsBrief() + "'" +
            ", phoneNum='" + getPhoneNum() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", mainImg='" + getMainImg() + "'" +
            "}";
    }
}
