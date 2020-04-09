package com.zh.raback.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> reference;
	public static volatile SingularAttribute<Product, String> image;
	public static volatile SingularAttribute<Product, String> thumbnail;
	public static volatile SingularAttribute<Product, Float> price;
	public static volatile SingularAttribute<Product, Long> width;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Long> stock;
	public static volatile SingularAttribute<Product, Long> categoryId;
	public static volatile SingularAttribute<Product, Long> height;

	public static final String REFERENCE = "reference";
	public static final String IMAGE = "image";
	public static final String THUMBNAIL = "thumbnail";
	public static final String PRICE = "price";
	public static final String WIDTH = "width";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String STOCK = "stock";
	public static final String CATEGORY_ID = "categoryId";
	public static final String HEIGHT = "height";

}

