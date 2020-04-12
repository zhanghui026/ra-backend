package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * The Artist entity.艺术家\n@author A true hipster
 */
@Entity
@Table(name = "artist")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * author name
     */
    @Column(name = "name")
    private String name;

    /**
     * russian name
     */
    @Column(name = "rs_name")
    private String rsName;

    /**
     * 英语名
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 国籍
     */
    @Column(name = "citizenship")
    private String citizenship;

    /**
     * 年代
     */
    @Column(name = "born_age")
    private String bornAge;

    @Column(name = "sentence")
    private String sentence;

    @Column(name = "rs_sentence")
    private String rsSentence;

    @Column(name = "en_sentence")
    private String enSentence;

    /**
     * 画家简介
     */
    @Column(name = "brief")
    private String brief;

    /**
     * 俄语简介
     */
    @Column(name = "rs_brief")
    private String rsBrief;

    @Column(name = "en_brief")
    private String enBrief;

    /**
     * 画家详细介绍
     */
    @Column(name = "art_info")
    private String artInfo;

    @Column(name = "rs_art_info")
    private String rsArtInfo;

    @Column(name = "en_art_info")
    private String enArtInfo;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Instant createDate;

    /**
     * 修改日期
     */
    @Column(name = "update_date")
    private Instant updateDate;

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

    public Artist name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRsName() {
        return rsName;
    }

    public Artist rsName(String rsName) {
        this.rsName = rsName;
        return this;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName;
    }

    public String getEnName() {
        return enName;
    }

    public Artist enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getAvatar() {
        return avatar;
    }

    public Artist avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public Artist citizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getBornAge() {
        return bornAge;
    }

    public Artist bornAge(String bornAge) {
        this.bornAge = bornAge;
        return this;
    }

    public void setBornAge(String bornAge) {
        this.bornAge = bornAge;
    }

    public String getSentence() {
        return sentence;
    }

    public Artist sentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getRsSentence() {
        return rsSentence;
    }

    public Artist rsSentence(String rsSentence) {
        this.rsSentence = rsSentence;
        return this;
    }

    public void setRsSentence(String rsSentence) {
        this.rsSentence = rsSentence;
    }

    public String getEnSentence() {
        return enSentence;
    }

    public Artist enSentence(String enSentence) {
        this.enSentence = enSentence;
        return this;
    }

    public void setEnSentence(String enSentence) {
        this.enSentence = enSentence;
    }

    public String getBrief() {
        return brief;
    }

    public Artist brief(String brief) {
        this.brief = brief;
        return this;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRsBrief() {
        return rsBrief;
    }

    public Artist rsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
        return this;
    }

    public void setRsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
    }

    public String getEnBrief() {
        return enBrief;
    }

    public Artist enBrief(String enBrief) {
        this.enBrief = enBrief;
        return this;
    }

    public void setEnBrief(String enBrief) {
        this.enBrief = enBrief;
    }

    public String getArtInfo() {
        return artInfo;
    }

    public Artist artInfo(String artInfo) {
        this.artInfo = artInfo;
        return this;
    }

    public void setArtInfo(String artInfo) {
        this.artInfo = artInfo;
    }

    public String getRsArtInfo() {
        return rsArtInfo;
    }

    public Artist rsArtInfo(String rsArtInfo) {
        this.rsArtInfo = rsArtInfo;
        return this;
    }

    public void setRsArtInfo(String rsArtInfo) {
        this.rsArtInfo = rsArtInfo;
    }

    public String getEnArtInfo() {
        return enArtInfo;
    }

    public Artist enArtInfo(String enArtInfo) {
        this.enArtInfo = enArtInfo;
        return this;
    }

    public void setEnArtInfo(String enArtInfo) {
        this.enArtInfo = enArtInfo;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Artist createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Artist updateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Artist)) {
            return false;
        }
        return id != null && id.equals(((Artist) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Artist{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", rsName='" + getRsName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", citizenship='" + getCitizenship() + "'" +
            ", bornAge='" + getBornAge() + "'" +
            ", sentence='" + getSentence() + "'" +
            ", rsSentence='" + getRsSentence() + "'" +
            ", enSentence='" + getEnSentence() + "'" +
            ", brief='" + getBrief() + "'" +
            ", rsBrief='" + getRsBrief() + "'" +
            ", enBrief='" + getEnBrief() + "'" +
            ", artInfo='" + getArtInfo() + "'" +
            ", rsArtInfo='" + getRsArtInfo() + "'" +
            ", enArtInfo='" + getEnArtInfo() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            "}";
    }
}
