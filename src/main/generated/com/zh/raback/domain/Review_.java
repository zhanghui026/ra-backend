package com.zh.raback.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static volatile SingularAttribute<Review, Date> date;
	public static volatile SingularAttribute<Review, Long> productId;
	public static volatile SingularAttribute<Review, Long> customerId;
	public static volatile SingularAttribute<Review, Integer> rating;
	public static volatile SingularAttribute<Review, String> comment;
	public static volatile SingularAttribute<Review, Long> id;
	public static volatile SingularAttribute<Review, Long> commandId;
	public static volatile SingularAttribute<Review, String> status;

	public static final String DATE = "date";
	public static final String PRODUCT_ID = "productId";
	public static final String CUSTOMER_ID = "customerId";
	public static final String RATING = "rating";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String COMMAND_ID = "commandId";
	public static final String STATUS = "status";

}

