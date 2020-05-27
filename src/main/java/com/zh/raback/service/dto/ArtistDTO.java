package com.zh.raback.service.dto;

import com.zh.raback.domain.Artist;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Artist} entity.
 */
@ApiModel(description = "The Artist entity.艺术家\n@author A true hipster")
public class ArtistDTO implements Serializable {

    private Long id;

    /**
     * author name
     */
    @ApiModelProperty(value = "author name")
    private String name;

    /**
     * russian name
     */
    @ApiModelProperty(value = "russian name")
    private String rsName;

    /**
     * 英语名
     */
    @ApiModelProperty(value = "英语名")
    private String enName;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 国籍
     */
    @ApiModelProperty(value = "国籍")
    private String citizenship;

    /**
     * 年代
     */
    @ApiModelProperty(value = "年代")
    private String bornAge;

    private String sentence;

    private String rsSentence;

    private String enSentence;

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
     * 画家详细介绍
     */
    @ApiModelProperty(value = "画家详细介绍")
    private String artInfo;

    private String rsArtInfo;

    private String enArtInfo;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Instant createDate;

    /**
     * 修改日期
     */
    @ApiModelProperty(value = "修改日期")
    private Instant updateDate;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getBornAge() {
        return bornAge;
    }

    public void setBornAge(String bornAge) {
        this.bornAge = bornAge;
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

    public String getArtInfo() {
        return artInfo;
    }

    public void setArtInfo(String artInfo) {
        this.artInfo = artInfo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArtistDTO artistDTO = (ArtistDTO) o;
        if (artistDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), artistDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
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
