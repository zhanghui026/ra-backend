package com.zh.raback.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * A FileManager.
 */
@Entity
@Table(name = "file_manager")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FileManager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "file_no", nullable = false)
    private String fileNo;

    @Column(name = "biz_code")
    private String bizCode;

    @Column(name = "default_url")
    private String defaultUrl;

    @Column(name = "default_path")
    private String defaultPath;

    @Column(name = "default_file_name")
    private String defaultFileName;

    @Column(name = "is_img")
    private Boolean isImg;

    @Column(name = "size")
    private Long size;

    @Column(name = "is_thumbnail")
    private Boolean isThumbnail;

    @Column(name = "is_commit")
    private Boolean isCommit;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_time")
    private Instant updateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNo() {
        return fileNo;
    }

    public FileManager fileNo(String fileNo) {
        this.fileNo = fileNo;
        return this;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getBizCode() {
        return bizCode;
    }

    public FileManager bizCode(String bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public FileManager defaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
        return this;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public FileManager defaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
        return this;
    }

    public void setDefaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public String getDefaultFileName() {
        return defaultFileName;
    }

    public FileManager defaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
        return this;
    }

    public void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }

    public Boolean isIsImg() {
        return isImg;
    }

    public FileManager isImg(Boolean isImg) {
        this.isImg = isImg;
        return this;
    }

    public void setIsImg(Boolean isImg) {
        this.isImg = isImg;
    }

    public Long getSize() {
        return size;
    }

    public FileManager size(Long size) {
        this.size = size;
        return this;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Boolean isIsThumbnail() {
        return isThumbnail;
    }

    public FileManager isThumbnail(Boolean isThumbnail) {
        this.isThumbnail = isThumbnail;
        return this;
    }

    public void setIsThumbnail(Boolean isThumbnail) {
        this.isThumbnail = isThumbnail;
    }

    public Boolean isIsCommit() {
        return isCommit;
    }

    public FileManager isCommit(Boolean isCommit) {
        this.isCommit = isCommit;
        return this;
    }

    public void setIsCommit(Boolean isCommit) {
        this.isCommit = isCommit;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public FileManager createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public FileManager updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileManager)) {
            return false;
        }
        return id != null && id.equals(((FileManager) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FileManager{" +
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
