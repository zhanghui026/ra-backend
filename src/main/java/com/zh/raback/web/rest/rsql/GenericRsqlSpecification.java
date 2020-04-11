package com.zh.raback.web.rest.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.Predicate;

public class GenericRsqlSpecification<T> implements Specification<T> {
    private static final Logger log = LoggerFactory.getLogger(GenericRsqlSpecification.class);
    private String property;
    private ComparisonOperator operator;
    private List<String> arguments;
    private static final String DATE_PATTERN = "yyyy-MM-dd"; //ISO 8601
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss"; //ISO 8601

    public GenericRsqlSpecification(final String property, final ComparisonOperator operator, final List<String> arguments) {
        super();
        this.property = property;
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Object> args = castArguments(root);
        Object argument = args.get(0);
        switch (RsqlSearchOperation.getSimpleOperator(operator)) {

        case EQUAL: {

            if (argument instanceof String) {
                if (isDateType(argument.toString())){
                    return builder.equal(root.get(property),parseDate(argument.toString()));
                } else {
                    return builder.like(root.get(property), argument.toString().replace('*', '%'));
                }
            } else if (argument == null) {
                return builder.isNull(root.get(property));
            } else {
                return builder.equal(root.get(property), argument);
            }
        }
        case NOT_EQUAL: {
            if (argument instanceof String) {
                if (isDateType(argument.toString())){
                    return builder.notEqual(root.get(property),parseDate(argument.toString()));
                } else {
                    return builder.notLike(root.<String>get(property), argument.toString().replace('*', '%'));
                }
            } else if (argument == null) {
                return builder.isNotNull(root.get(property));
            } else {
                return builder.notEqual(root.get(property), argument);
            }
        }
        case GREATER_THAN: {
            if (isDateType(argument.toString())){
                return builder.greaterThan(root.<Date>get(property),parseDate(argument.toString()));
            } else {
                return builder.greaterThan(root.<String>get(property), argument.toString());
            }
        }
        case GREATER_THAN_OR_EQUAL: {
            if (isDateType(argument.toString())){
                return builder.greaterThanOrEqualTo(root.get(property),parseDate(argument.toString()));
            } else {
                return builder.greaterThanOrEqualTo(root.<String>get(property), argument.toString());
            }
        }
        case LESS_THAN: {
            if (isDateType(argument.toString())){
                return builder.lessThan(root.get(property),parseDate(argument.toString()));
            } else {
                return builder.lessThan(root.<String>get(property), argument.toString());
            }
        }
        case LESS_THAN_OR_EQUAL: {
            if (isDateType(argument.toString())){
                return builder.lessThanOrEqualTo(root.get(property),parseDate(argument.toString()));
            } else {
                return builder.lessThanOrEqualTo(root.<String>get(property), argument.toString());
            }
        }
        case IN:
            return root.get(property).in(args);
        case NOT_IN:
            return builder.not(root.get(property).in(args));
        }

        return null;
    }

    private List<Object> castArguments(final Root<T> root) {

        Class<? extends Object> type = root.get(property).getJavaType();

        List<Object> args = arguments.stream().map(arg -> {
            if (type.equals(Integer.class)) {
               return Integer.parseInt(arg);
            } else if (type.equals(Long.class)) {
               return Long.parseLong(arg);
            } else {
                return arg;
            }
        }).collect(Collectors.toList());

        return args;
    }

    private Date parseDate(String argument) {
        try {
            return new SimpleDateFormat(DATE_TIME_PATTERN).parse(argument);
        } catch (ParseException ex) {
            log.info("Not a date time format, lets try with date format.");
        }
        try {
            return new SimpleDateFormat(DATE_PATTERN).parse(argument);
        } catch (ParseException ex1) {
            throw new IllegalArgumentException(argument);
        }
    }

    public boolean isDateType(String argument){
        if (StringUtils.isNotBlank(argument)) {
            try {
                parseDate(argument);
                return true;
            } catch (Exception e) {
                return false;
            }
        }else {
            return false;
        }
    }

    // standard constructor, getter, setter
}
