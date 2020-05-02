package com.zh.raback.service.mapper;

import com.zh.raback.domain.Review;
import com.zh.raback.service.dto.ReviewDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-02T12:57:25+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toEntity(ReviewDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Review review = new Review();

        review.setId( dto.getId() );
        if ( dto.getDate() != null ) {
            review.setDate( Date.from( dto.getDate() ) );
        }
        review.setStatus( dto.getStatus() );
        review.setCustomerId( dto.getCustomerId() );
        review.setCommandId( dto.getCommandId() );
        review.setProductId( dto.getProductId() );
        review.setRating( dto.getRating() );
        review.setComment( dto.getComment() );

        return review;
    }

    @Override
    public ReviewDTO toDto(Review entity) {
        if ( entity == null ) {
            return null;
        }

        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setId( entity.getId() );
        if ( entity.getDate() != null ) {
            reviewDTO.setDate( entity.getDate().toInstant() );
        }
        reviewDTO.setStatus( entity.getStatus() );
        reviewDTO.setCustomerId( entity.getCustomerId() );
        reviewDTO.setCommandId( entity.getCommandId() );
        reviewDTO.setProductId( entity.getProductId() );
        reviewDTO.setRating( entity.getRating() );
        reviewDTO.setComment( entity.getComment() );

        return reviewDTO;
    }

    @Override
    public List<Review> toEntity(List<ReviewDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Review> list = new ArrayList<Review>( dtoList.size() );
        for ( ReviewDTO reviewDTO : dtoList ) {
            list.add( toEntity( reviewDTO ) );
        }

        return list;
    }

    @Override
    public List<ReviewDTO> toDto(List<Review> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReviewDTO> list = new ArrayList<ReviewDTO>( entityList.size() );
        for ( Review review : entityList ) {
            list.add( toDto( review ) );
        }

        return list;
    }
}
