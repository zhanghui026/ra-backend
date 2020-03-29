package com.zh.raback.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Post.class)
public abstract class Post_ {

	public static volatile SingularAttribute<Post, Long> id;
	public static volatile SingularAttribute<Post, String> title;
	public static volatile SingularAttribute<Post, String> body;
	public static volatile SingularAttribute<Post, Long> userId;

	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String BODY = "body";
	public static final String USER_ID = "userId";

}

