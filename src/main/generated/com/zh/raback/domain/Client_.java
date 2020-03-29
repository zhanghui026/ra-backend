package com.zh.raback.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, String> website;
	public static volatile SingularAttribute<Client, String> address;
	public static volatile SingularAttribute<Client, String> phone;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, String> company;
	public static volatile SingularAttribute<Client, Long> id;
	public static volatile SingularAttribute<Client, String> email;
	public static volatile SingularAttribute<Client, String> username;

	public static final String WEBSITE = "website";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String COMPANY = "company";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

