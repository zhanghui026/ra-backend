package com.zh.raback.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Command.class)
public abstract class Command_ {

	public static volatile SingularAttribute<Command, String> reference;
	public static volatile SingularAttribute<Command, Date> date;
	public static volatile SingularAttribute<Command, String> basket;
	public static volatile SingularAttribute<Command, Float> taxRate;
	public static volatile SingularAttribute<Command, Float> total;
	public static volatile SingularAttribute<Command, Long> customerId;
	public static volatile SingularAttribute<Command, Float> taxes;
	public static volatile SingularAttribute<Command, Long> id;
	public static volatile SingularAttribute<Command, Boolean> returned;
	public static volatile SingularAttribute<Command, Float> deliveryFees;
	public static volatile SingularAttribute<Command, Float> totalExTaxes;
	public static volatile SingularAttribute<Command, String> status;

	public static final String REFERENCE = "reference";
	public static final String DATE = "date";
	public static final String BASKET = "basket";
	public static final String TAX_RATE = "taxRate";
	public static final String TOTAL = "total";
	public static final String CUSTOMER_ID = "customerId";
	public static final String TAXES = "taxes";
	public static final String ID = "id";
	public static final String RETURNED = "returned";
	public static final String DELIVERY_FEES = "deliveryFees";
	public static final String TOTAL_EX_TAXES = "totalExTaxes";
	public static final String STATUS = "status";

}

