package com.paymentapi.paymentapi.mappers;


import com.paymentapi.paymentapi.dto.request.VendedorDTO;
import com.paymentapi.paymentapi.dto.response.VendedorResponseDTO;
import com.paymentapi.paymentapi.model.Vendedor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VendedorMapper {

    VendedorDTO vendedorToVendedorDTO(Vendedor vendedor);

    VendedorResponseDTO vendedorToVendedorResponseDTO(Vendedor vendedor);

    Vendedor vendedorDTOToVendedor(VendedorDTO vendedorDTO);

    Vendedor vendedorResponseDTOToVendedor(VendedorResponseDTO vendedorResponseDTO);

    //Page<VendedorResponseDTO> toPageResponseDTO(Page<Vendedor> vendedorPage);

}