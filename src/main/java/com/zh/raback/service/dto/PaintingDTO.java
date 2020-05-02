package com.zh.raback.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Painting} entity.
 */
@ApiModel(description = "The Painting\nentity.\n@author A true hipster")
public class PaintingDTO implements Serializable {

    private Long id;

    /**
     * painting name
     */
    @ApiModelProperty(value = "painting name")
    private String name;

    /**
     * painting rsname
     */
    @ApiModelProperty(value = "painting rsname")
    private String rsName;

    /**
     * painting enname
     */
    @ApiModelProperty(value = "painting enname")
    private String enName;

    /**
     * artistId
     */
    @ApiModelProperty(value = "artistId")
    private Long artistId;

    /**
     * 艺术馆id
     */
    @ApiModelProperty(value = "艺术馆id")
    private Long museumId;

    /**
     * 创作年代
     */
    @ApiModelProperty(value = "创作年代")
    private String age;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String tags;

    private Float width;

    private Float height;

    private String rawImg;

    private String webImg;

    private String thumbnailImg;

    private String pin;

    private String pinImg;

    private String reference;

    private String sentence;

    private String rsSentence;

    private String enSentence;

    private String material;

    /**
     * 画家简介
     */
    @ApiModelProperty(value = "画家简介")
    private String brief;

    /**
     * 俄语简介
     */
    @ApiModelProperty(value = "俄语简介")
    private String rsBrief;

    private String enBrief;

    /**
     * 画作详细介绍
     */
    @ApiModelProperty(value = "画作详细介绍")
    private String info;

    private String rsArtInfo;

    private String enArtInfo;

    private Integer rating;

    private Instant createDate;

    private Instant updateDate;

    @NotNull
    private Boolean useArtistInfo;

    private String category;


    public String getImageNo() {
        return imageNo;
    }

    public void setImageNo(String imageNo) {
        this.imageNo = imageNo;
    }

    private String imageNo;

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

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getMuseumId() {
        return museumId;
    }

    public void setMuseumId(Long museumId) {
        this.museumId = museumId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getRawImg() {
        return rawImg;
    }

    public void setRawImg(String rawImg) {
        this.rawImg = rawImg;
    }

    public String getWebImg() {
        return webImg;
    }

    public void setWebImg(String webImg) {
        this.webImg = webImg;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinImg() {
        return pinImg;
    }

    public void setPinImg(String pinImg) {
        this.pinImg = pinImg;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getRsSentence() {
        return rsSentence;
    }

    public void setRsSentence(String rsSentence) {
        this.rsSentence = rsSentence;
    }

    public String getEnSentence() {
        return enSentence;
    }

    public void setEnSentence(String enSentence) {
        this.enSentence = enSentence;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRsBrief() {
        return rsBrief;
    }

    public void setRsBrief(String rsBrief) {
        this.rsBrief = rsBrief;
    }

    public String getEnBrief() {
        return enBrief;
    }

    public void setEnBrief(String enBrief) {
        this.enBrief = enBrief;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRsArtInfo() {
        return rsArtInfo;
    }

    public void setRsArtInfo(String rsArtInfo) {
        this.rsArtInfo = rsArtInfo;
    }

    public String getEnArtInfo() {
        return enArtInfo;
    }

    public void setEnArtInfo(String enArtInfo) {
        this.enArtInfo = enArtInfo;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean isUseArtistInfo() {
        return useArtistInfo;
    }

    public void setUseArtistInfo(Boolean useArtistInfo) {
        this.useArtistInfo = useArtistInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PaintingDTO paintingDTO = (PaintingDTO) o;
        if (paintingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), paintingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PaintingDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", rsName='" + getRsName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", artistId=" + getArtistId() +
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
            ", category='" + getCategory() + "'" +
            ", material='" + getMaterial() + "'" +
            "}";
    }
}
