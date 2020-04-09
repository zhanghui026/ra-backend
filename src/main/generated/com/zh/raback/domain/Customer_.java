package com.zh.raback.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, Date> birthday;
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, String> address;
	public static volatile SingularAttribute<Customer, Boolean> hasOrdered;
	public static volatile SingularAttribute<Customer, Boolean> hasNewsletter;
	public static volatile SingularAttribute<Customer, String> city;
	public static volatile SingularAttribute<Customer, Date> firstSeen;
	public static volatile SingularAttribute<Customer, String> groups;
	public static volatile SingularAttribute<Customer, String> avatar;
	public static volatile SingularAttribute<Customer, Integer> nbCommands;
	public static volatile SingularAttribute<Customer, String> zipcode;
	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, Date> lastSeen;
	public static volatile SingularAttribute<Customer, Float> totalSpend;
	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, Date> latestPurchase;
	public static volatile SingularAttribute<Customer, String> email;

	public static final String BIRTHDAY = "birthday";
	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String HAS_ORDERED = "hasOrdered";
	public static final String HAS_NEWSLETTER = "hasNewsletter";
	public static final String CITY = "city";
	public static final String FIRST_SEEN = "firstSeen";
	public static final String GROUPS = "groups";
	public static final String AVATAR = "avatar";
	public static final String NB_COMMANDS = "nbCommands";
	public static final String ZIPCODE = "zipcode";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_SEEN = "lastSeen";
	public static final String TOTAL_SPEND = "totalSpend";
	public static final String ID = "id";
	public static final String LATEST_PURCHASE = "latestPurchase";
	public static final String EMAIL = "email";

}

