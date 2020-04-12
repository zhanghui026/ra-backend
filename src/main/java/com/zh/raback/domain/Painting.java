package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * The Painting\nentity.\n@author A true hipster
 */
@Entity
@Table(name = "painting")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Painting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * painting name
     */
    @Column(name = "name")
    private String name;

    /**
     * painting rsname
     */
    @Column(name = "rs_name")
    private String rsName;

    /**
     * painting enname
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * artistId
     */
    @Column(name = "artist_id")
    private Long artistId;

    /**
     * 材质material id
     */
    @Column(name = "material_id")
    private Long materialId;

    /**
     * 类型
     */
    @Column(name = "art_type_id")
    private Long artTypeId;

    /**
     * 艺术馆id
     */
    @Column(name = "museum_id")
    private Long museumId;

    /**
     * 创作年代
     */
    @Column(name = "age")
    private String age;

    /**
     * 标签
     */
    @Column(name = "tags")
    private String tags;

    @Column(name = "width")
    private Float width;

    @Column(name = "height")
    private Float height;

    @Column(name = "raw_img")
    private String rawImg;

    @Column(name = "web_img")
    private String webImg;

    @Column(name = "thumbnail_img")
    private String thumbnailImg;

    @Column(name = "pin")
    private String pin;

    @Column(name = "pin_img")
    private String pinImg;

    @Column(name = "reference")
    private String reference;

    @Column(name = "category_status_id")
    private Long categoryStatusId;

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
     * 画作详细介绍
     */
    @Column(name = "info")
    private String info;

    @Column(name = "rs_art_info")
    private String rsArtInfo;

    @Column(name = "en_art_info")
    private String enArtInfo;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @NotNull
    @Column(name = "use_artist_info", nullable = false)
    private Boolean useArtistInfo;

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

    public Painting name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRsName() {
        return rsName;
    }

    public Painting rsName(String rsName) {
        this.rsName = rsName;
        return this;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName;
    }

    public String getEnName() {
        return enName;
    }

    public Painting enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Long getArtistId() {
        return artistId;
    }

    public Painting artistId(Long artistId) {
        this.artistId = artistId;
        return this;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public Painting materialId(Long materialId) {
        this.materialId = materialId;
        return this;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getArtTypeId() {
        return artTypeId;
    }

    public Painting artTypeId(Long artTypeId) {
        this.artTypeId = artTypeId;
        return this;
    }

    public void setArtTypeId(Long artTypeId) {
        this.artTypeId = artTypeId;
    }

    public Long getMuseumId() {
        return museumId;
    }

    public Painting museumId(Long museumId) {
        this.museumId = museumId;
        return this;
    }

    public void setMuseumId(Long museumId) {
        this.museumId = museumId;
    }

    public String getAge() {
        return age;
    }

    public Painting age(String age) {
        this.age = age;
        return this;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTags() {
        return tags;
    }

    public Painting tags(String tags) {
        this.tags = tags;
        return this;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Float getWidth() {
        return width;
    }

    public Painting width(Float width) {
        this.width = width;
        return this;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public Painting height(Float height) {
        this.height = height;
        return this;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getRawImg() {
        return rawImg;
    }

    public Painting rawImg(String rawImg) {
        this.rawImg = rawImg;
        return this;
    }

    public void setRawImg(String rawImg) {
        this.rawImg = rawImg;
    }

    public String getWebImg() {
        return webImg;
    }

    public Painting webImg(String webImg) {
        this.webImg = webImg;
        return this;
    }

    public void setWebImg(String webImg) {
        this.webImg = webImg;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public Painting thumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
        return this;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public String getPin() {
        return pin;
    }

    public Painting pin(String pin) {
        this.pin = pin;
        return this;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinImg() {
        return pinImg;
    }

    public Painting pinImg(String pinImg) {
        this.pinImg = pinImg;
        return this;
    }

    public void setPinImg(String pinImg) {
        this.pinImg = pinImg;
    }

    public String getReference() {
        return reference;
    }

    public Painting reference(String reference) {
        this.reference = reference;
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getCategoryStatusId() {
        return categoryStatusId;
    }

    public Painting categoryStatusId(Long categoryStatusId) {
        this.categoryStatusId = categoryStatusId;
        return this;
    }

    public void setCategoryStatusId(Long categoryStatusId) {
        this.categoryStatusId = categoryStatusId;
    }

    public String getSentence() {
        return sentence;
    }

    public Painting sentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getRsSentence() {
        return rsSentence;
    }

    public Painting rsSentence(String rsSentence) {
        this.rsSentence = rsSentence;
        return this;
    }

    public void setRsSentence(String rsSentence) {
        this.rsSentence = rsSentence;
    }

    public String getEnSentence() {
        return enSentence;
    }

    public Painting enSentence(String enSentence) {
        this.enSentence = enSentence;
        return this;
    }

    public void setEnSentence(String enSentence) {
        this.enSentence = enSentence;
    }

    public String getBrief() {
        return brief;
    }

    public Painting brief(String brief) {
        this.brief = brief;
        return this;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRsBrief() {
        return rsBrief;
    }

    public Painting rsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
        return this;
    }

    public void setRsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
    }

    public String getEnBrief() {
        return enBrief;
    }

    public Painting enBrief(String enBrief) {
        this.enBrief = enBrief;
        return this;
    }

    public void setEnBrief(String enBrief) {
        this.enBrief = enBrief;
    }

    public String getInfo() {
        return info;
    }

    public Painting info(String info) {
        this.info = info;
        return this;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRsArtInfo() {
        return rsArtInfo;
    }

    public Painting rsArtInfo(String rsArtInfo) {
        this.rsArtInfo = rsArtInfo;
        return this;
    }

    public void setRsArtInfo(String rsArtInfo) {
        this.rsArtInfo = rsArtInfo;
    }

    public String getEnArtInfo() {
        return enArtInfo;
    }

    public Painting enArtInfo(String enArtInfo) {
        this.enArtInfo = enArtInfo;
        return this;
    }

    public void setEnArtInfo(String enArtInfo) {
        this.enArtInfo = enArtInfo;
    }

    public Integer getRating() {
        return rating;
    }

    public Painting rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Painting createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Painting updateDate(Instant updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean isUseArtistInfo() {
        return useArtistInfo;
    }

    public Painting useArtistInfo(Boolean useArtistInfo) {
        this.useArtistInfo = useArtistInfo;
        return this;
    }

    public void setUseArtistInfo(Boolean useArtistInfo) {
        this.useArtistInfo = useArtistInfo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Painting)) {
            return false;
        }
        return id != null && id.equals(((Painting) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Painting{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", rsName='" + getRsName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", artistId=" + getArtistId() +
            ", materialId=" + getMaterialId() +
            ", artTypeId=" + getArtTypeId() +
            ", museumId=" + getMuseumId() +
            ", age='" + getAge() + "'" +
            ", tags='" + getTags() + "'" +
            ", width=" + getWidth() +
            ", height=" + getHeight() +
            ", rawImg='" + getRawImg() + "'" +
            ", webImg='" + getWebImg() + "'" +
            ", thumbnailImg='" + getThumbnailImg() + "'" +
            ", pin='" + getPin() + "'" +
            ", pinImg='" + getPinImg() + "'" +
            ", reference='" + getReference() + "'" +
            ", categoryStatusId=" + getCategoryStatusId() +
            ", sentence='" + getSentence() + "'" +
            ", rsSentence='" + getRsSentence() + "'" +
            ", enSentence='" + getEnSentence() + "'" +
            ", brief='" + getBrief() + "'" +
            ", rsBrief='" + getRsBrief() + "'" +
            ", enBrief='" + getEnBrief() + "'" +
            ", info='" + getInfo() + "'" +
            ", rsArtInfo='" + getRsArtInfo() + "'" +
            ", enArtInfo='" + getEnArtInfo() + "'" +
            ", rating=" + getRating() +
            ", createDate='" + getCreateDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", useArtistInfo='" + isUseArtistInfo() + "'" +
            "}";
    }
}
