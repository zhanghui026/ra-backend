package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * The 艺术馆\n@author A true hipster
 */
@Entity
@Table(name = "museum")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Museum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rs_name")
    private String rsName;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "rs_full_name")
    private String rsFullName;

    @Column(name = "en_full_name")
    private String enFullName;

    @Column(name = "address")
    private String address;

    @Column(name = "rs_address")
    private String rsAddress;

    @Column(name = "en_address")
    private String enAddress;

    @Column(name = "brief")
    private String brief;

    @Column(name = "en_brief")
    private String enBrief;

    @Column(name = "rs_brief")
    private String rsBrief;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "main_img")
    private String mainImg;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Museum name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRsName() {
        return rsName;
    }

    public Museum rsName(String rsName) {
        this.rsName = rsName;
        return this;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName;
    }

    public String getEnName() {
        return enName;
    }

    public Museum enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFullName() {
        return fullName;
    }

    public Museum fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRsFullName() {
        return rsFullName;
    }

    public Museum rsFullName(String rsFullName) {
        this.rsFullName = rsFullName;
        return this;
    }

    public void setRsFullName(String rsFullName) {
        this.rsFullName = rsFullName;
    }

    public String getEnFullName() {
        return enFullName;
    }

    public Museum enFullName(String enFullName) {
        this.enFullName = enFullName;
        return this;
    }

    public void setEnFullName(String enFullName) {
        this.enFullName = enFullName;
    }

    public String getAddress() {
        return address;
    }

    public Museum address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRsAddress() {
        return rsAddress;
    }

    public Museum rsAddress(String rsAddress) {
        this.rsAddress = rsAddress;
        return this;
    }

    public void setRsAddress(String rsAddress) {
        this.rsAddress = rsAddress;
    }

    public String getEnAddress() {
        return enAddress;
    }

    public Museum enAddress(String enAddress) {
        this.enAddress = enAddress;
        return this;
    }

    public void setEnAddress(String enAddress) {
        this.enAddress = enAddress;
    }

    public String getBrief() {
        return brief;
    }

    public Museum brief(String brief) {
        this.brief = brief;
        return this;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getEnBrief() {
        return enBrief;
    }

    public Museum enBrief(String enBrief) {
        this.enBrief = enBrief;
        return this;
    }

    public void setEnBrief(String enBrief) {
        this.enBrief = enBrief;
    }

    public String getRsBrief() {
        return rsBrief;
    }

    public Museum rsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
        return this;
    }

    public void setRsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Museum phoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public Museum contactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Museum createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public Museum updateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getMainImg() {
        return mainImg;
    }

    public Museum mainImg(String mainImg) {
        this.mainImg = mainImg;
        return this;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Museum)) {
            return false;
        }
        return id != null && id.equals(((Museum) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Museum{" +
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
