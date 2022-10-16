package com.paymentapi.paymentapi.mappers;


import com.paymentapi.paymentapi.dto.request.ProductDTO;
import com.paymentapi.paymentapi.dto.response.ProductResponseDTO;
import com.paymentapi.paymentapi.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    ProductResponseDTO toProductResponseDTO(Product product);

    Product toProduct(ProductDTO productDTO);

    Product productResponseDTOToProduct(ProductResponseDTO productResponseDTO);

}
