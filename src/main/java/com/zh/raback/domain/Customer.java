package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Customer entity.\n@author A true hipster
 */
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "first_seen")
    private Date firstSeen;

    @Column(name = "last_seen")
    private Date lastSeen;

    @Column(name = "has_ordered")
    private Boolean hasOrdered;

    @Column(name = "latest_purchase")
    private Date latestPurchase;

    @Column(name = "has_newsletter")
    private Boolean hasNewsletter;

    @Column(name = "jhi_groups")
    private String groups;

    @Column(name = "nb_commands")
    private Integer nbCommands;

    @Column(name = "total_spend")
    private Integer totalSpend;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public Customer address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Customer zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public Customer city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public Customer avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Customer birthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getFirstSeen() {
        return firstSeen;
    }

    public Customer firstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
        return this;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public Customer lastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
        return this;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Boolean isHasOrdered() {
        return hasOrdered;
    }

    public Customer hasOrdered(Boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
        return this;
    }

    public void setHasOrdered(Boolean hasOrdered) {
        this.hasOrdered = hasOrdered;
    }

    public Date getLatestPurchase() {
        return latestPurchase;
    }

    public Customer latestPurchase(Date latestPurchase) {
        this.latestPurchase = latestPurchase;
        return this;
    }

    public void setLatestPurchase(Date latestPurchase) {
        this.latestPurchase = latestPurchase;
    }

    public Boolean isHasNewsletter() {
        return hasNewsletter;
    }

    public Customer hasNewsletter(Boolean hasNewsletter) {
        this.hasNewsletter = hasNewsletter;
        return this;
    }

    public void setHasNewsletter(Boolean hasNewsletter) {
        this.hasNewsletter = hasNewsletter;
    }

    public String getGroups() {
        return groups;
    }

    public Customer groups(String groups) {
        this.groups = groups;
        return this;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public Integer getNbCommands() {
        return nbCommands;
    }

    public Customer nbCommands(Integer nbCommands) {
        this.nbCommands = nbCommands;
        return this;
    }

    public void setNbCommands(Integer nbCommands) {
        this.nbCommands = nbCommands;
    }

    public Integer getTotalSpend() {
        return totalSpend;
    }

    public Customer totalSpend(Integer totalSpend) {
        this.totalSpend = totalSpend;
        return this;
    }

    public void setTotalSpend(Integer totalSpend) {
        this.totalSpend = totalSpend;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Customer{" +
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
