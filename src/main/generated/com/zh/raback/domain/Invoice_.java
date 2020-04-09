package com.zh.raback.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Invoice.class)
public abstract class Invoice_ {

	public static volatile SingularAttribute<Invoice, Date> date;
	public static volatile SingularAttribute<Invoice, Float> taxRate;
	public static volatile SingularAttribute<Invoice, Float> total;
	public static volatile SingularAttribute<Invoice, Long> customerId;
	public static volatile SingularAttribute<Invoice, Float> taxes;
	public static volatile SingularAttribute<Invoice, Long> id;
	public static volatile SingularAttribute<Invoice, Long> commandId;
	public static volatile SingularAttribute<Invoice, Float> deliveryFees;
	public static volatile SingularAttribute<Invoice, Float> totalExTaxes;

	public static final String DATE = "date";
	public static final String TAX_RATE = "taxRate";
	public static final String TOTAL = "total";
	public static final String CUSTOMER_ID = "customerId";
	public static final String TAXES = "taxes";
	public static final String ID = "id";
	public static final String COMMAND_ID = "commandId";
	public static final String DELIVERY_FEES = "deliveryFees";
	public static final String TOTAL_EX_TAXES = "totalExTaxes";

}

