package com.zh.raback.service.mapper;

import com.zh.raback.domain.Product;
import com.zh.raback.service.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-01T02:12:22+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setCategoryId( dto.getCategoryId() );
        product.setDescription( dto.getDescription() );
        product.setHeight( dto.getHeight() );
        product.setImage( dto.getImage() );
        product.setPrice( dto.getPrice() );
        product.setReference( dto.getReference() );
        product.setStock( dto.getStock() );
        product.setThumbnail( dto.getThumbnail() );
        product.setWidth( dto.getWidth() );

        return product;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( entity.getId() );
        productDTO.setCategoryId( entity.getCategoryId() );
        productDTO.setDescription( entity.getDescription() );
        productDTO.setHeight( entity.getHeight() );
        productDTO.setImage( entity.getImage() );
        productDTO.setPrice( entity.getPrice() );
        productDTO.setReference( entity.getReference() );
        productDTO.setStock( entity.getStock() );
        productDTO.setThumbnail( entity.getThumbnail() );
        productDTO.setWidth( entity.getWidth() );

        return productDTO;
    }

    @Override
    public List<Product> toEntity(List<ProductDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtoList.size() );
        for ( ProductDTO productDTO : dtoList ) {
            list.add( toEntity( productDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductDTO> toDto(List<Product> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( entityList.size() );
        for ( Product product : entityList ) {
            list.add( toDto( product ) );
        }

        return list;
    }
}
