package com.zh.raback.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.FileManager} entity.
 */
public class FileManagerDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String fileNo;

    private String bizCode;

    private String defaultUrl;

    private String defaultPath;

    private String defaultFileName;

    private Boolean isImg;

    private Long size;

    private Boolean isThumbnail;

    private Boolean isCommit;

    private Instant createTime;

    private Instant updateTime;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public void setDefaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public String getDefaultFileName() {
        return defaultFileName;
    }

    public void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }

    public Boolean isIsImg() {
        return isImg;
    }

    public void setIsImg(Boolean isImg) {
        this.isImg = isImg;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Boolean isIsThumbnail() {
        return isThumbnail;
    }

    public void setIsThumbnail(Boolean isThumbnail) {
        this.isThumbnail = isThumbnail;
    }

    public Boolean isIsCommit() {
        return isCommit;
    }

    public void setIsCommit(Boolean isCommit) {
        this.isCommit = isCommit;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FileManagerDTO fileManagerDTO = (FileManagerDTO) o;
        if (fileManagerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fileManagerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FileManagerDTO{" +
            "id=" + getId() +
            ", fileNo='" + getFileNo() + "'" +
            ", bizCode='" + getBizCode() + "'" +
            ", defaultUrl='" + getDefaultUrl() + "'" +
            ", defaultPath='" + getDefaultPath() + "'" +
            ", defaultFileName='" + getDefaultFileName() + "'" +
            ", isImg='" + isIsImg() + "'" +
            ", size=" + getSize() +
            ", isThumbnail='" + isIsThumbnail() + "'" +
            ", isCommit='" + isIsCommit() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
