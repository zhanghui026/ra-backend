package com.zh.raback.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Painting.class)
public abstract class Painting_ {

	public static volatile SingularAttribute<Painting, String> webImg;
	public static volatile SingularAttribute<Painting, Instant> updateDate;
	public static volatile SingularAttribute<Painting, Integer> rating;
	public static volatile SingularAttribute<Painting, Long> artistId;
	public static volatile SingularAttribute<Painting, String> thumbnailImg;
	public static volatile SingularAttribute<Painting, String> enArtInfo;
	public static volatile SingularAttribute<Painting, String> reference;
	public static volatile SingularAttribute<Painting, Long> museumId;
	public static volatile SingularAttribute<Painting, String> enSentence;
	public static volatile SingularAttribute<Painting, String> rsArtInfo;
	public static volatile SingularAttribute<Painting, String> pin;
	public static volatile SingularAttribute<Painting, String> rsSentence;
	public static volatile SingularAttribute<Painting, String> enName;
	public static volatile SingularAttribute<Painting, Long> id;
	public static volatile SingularAttribute<Painting, Float> height;
	public static volatile SingularAttribute<Painting, String> info;
	public static volatile SingularAttribute<Painting, Instant> createDate;
	public static volatile SingularAttribute<Painting, String> sentence;
	public static volatile SingularAttribute<Painting, String> brief;
	public static volatile SingularAttribute<Painting, String> rsBrief;
	public static volatile SingularAttribute<Painting, String> rsName;
	public static volatile SingularAttribute<Painting, String> rawImg;
	public static volatile SingularAttribute<Painting, String> tags;
	public static volatile SingularAttribute<Painting, String> enBrief;
	public static volatile SingularAttribute<Painting, String> material;
	public static volatile SingularAttribute<Painting, String> pinImg;
	public static volatile SingularAttribute<Painting, String> name;
	public static volatile SingularAttribute<Painting, Float> width;
	public static volatile SingularAttribute<Painting, String> category;
	public static volatile SingularAttribute<Painting, String> age;
	public static volatile SingularAttribute<Painting, Boolean> useArtistInfo;

	public static final String WEB_IMG = "webImg";
	public static final String UPDATE_DATE = "updateDate";
	public static final String RATING = "rating";
	public static final String ARTIST_ID = "artistId";
	public static final String THUMBNAIL_IMG = "thumbnailImg";
	public static final String EN_ART_INFO = "enArtInfo";
	public static final String REFERENCE = "reference";
	public static final String MUSEUM_ID = "museumId";
	public static final String EN_SENTENCE = "enSentence";
	public static final String RS_ART_INFO = "rsArtInfo";
	public static final String PIN = "pin";
	public static final String RS_SENTENCE = "rsSentence";
	public static final String EN_NAME = "enName";
	public static final String ID = "id";
	public static final String HEIGHT = "height";
	public static final String INFO = "info";
	public static final String CREATE_DATE = "createDate";
	public static final String SENTENCE = "sentence";
	public static final String BRIEF = "brief";
	public static final String RS_BRIEF = "rsBrief";
	public static final String RS_NAME = "rsName";
	public static final String RAW_IMG = "rawImg";
	public static final String TAGS = "tags";
	public static final String EN_BRIEF = "enBrief";
	public static final String MATERIAL = "material";
	public static final String PIN_IMG = "pinImg";
	public static final String NAME = "name";
	public static final String WIDTH = "width";
	public static final String CATEGORY = "category";
	public static final String AGE = "age";
	public static final String USE_ARTIST_INFO = "useArtistInfo";

}

