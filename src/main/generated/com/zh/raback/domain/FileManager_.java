package com.zh.raback.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileManager.class)
public abstract class FileManager_ {

	public static volatile SingularAttribute<FileManager, String> defaultPath;
	public static volatile SingularAttribute<FileManager, Boolean> isImg;
	public static volatile SingularAttribute<FileManager, Long> size;
	public static volatile SingularAttribute<FileManager, String> fileNo;
	public static volatile SingularAttribute<FileManager, Instant> createTime;
	public static volatile SingularAttribute<FileManager, String> bizCode;
	public static volatile SingularAttribute<FileManager, String> defaultFileName;
	public static volatile SingularAttribute<FileManager, Boolean> isThumbnail;
	public static volatile SingularAttribute<FileManager, Instant> updateTime;
	public static volatile SingularAttribute<FileManager, Long> id;
	public static volatile SingularAttribute<FileManager, String> defaultUrl;
	public static volatile SingularAttribute<FileManager, Boolean> isCommit;

	public static final String DEFAULT_PATH = "defaultPath";
	public static final String IS_IMG = "isImg";
	public static final String SIZE = "size";
	public static final String FILE_NO = "fileNo";
	public static final String CREATE_TIME = "createTime";
	public static final String BIZ_CODE = "bizCode";
	public static final String DEFAULT_FILE_NAME = "defaultFileName";
	public static final String IS_THUMBNAIL = "isThumbnail";
	public static final String UPDATE_TIME = "updateTime";
	public static final String ID = "id";
	public static final String DEFAULT_URL = "defaultUrl";
	public static final String IS_COMMIT = "isCommit";

}

