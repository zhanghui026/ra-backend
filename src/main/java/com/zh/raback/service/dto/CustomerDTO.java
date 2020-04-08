package com.zh.raback.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.Instant;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Customer} entity.
 */
@ApiModel(description = "The Customer entity.\n@author A true hipster")
public class CustomerDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String zipcode;

    private String city;

    private String avatar;

    private String birthday;

    private String firstSeen;

    private String lastSeen;

    private Boolean hasOrdered;

    private String latestPurchase;

    private Boolean hasNewsletter;

    private List<String> groups;

    private Integer nbCommands;

    private Integer totalSpend;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Boolean isHasOrdered() {
        return hasOrdered;
    }

    public void setHasOrdered(Boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
    }

    public String getLatestPurchase() {
        return latestPurchase;
    }

    public void setLatestPurchase(String latestPurchase) {
        this.latestPurchase = latestPurchase;
    }

    public Boolean isHasNewsletter() {
        return hasNewsletter;
    }

    public void setHasNewsletter(Boolean hasNewsletter) {
        this.hasNewsletter = hasNewsletter;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public Integer getNbCommands() {
        return nbCommands;
    }

    public void setNbCommands(Integer nbCommands) {
        this.nbCommands = nbCommands;
    }

    public Integer getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(Integer totalSpend) {
        this.totalSpend = totalSpend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerDTO customerDTO = (CustomerDTO) o;
        if (customerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", zipcode='" + getZipcode() + "'" +
            ", city='" + getCity() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", firstSeen='" + getFirstSeen() + "'" +
            ", lastSeen='" + getLastSeen() + "'" +
            ", hasOrdered='" + isHasOrdered() + "'" +
            ", latestPurchase='" + getLatestPurchase() + "'" +
            ", hasNewsletter='" + isHasNewsletter() + "'" +
            ", groups='" + getGroups() + "'" +
            ", nbCommands=" + getNbCommands() +
            ", totalSpend=" + getTotalSpend() +
            "}";
    }
}
