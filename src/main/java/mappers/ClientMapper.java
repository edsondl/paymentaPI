package com.paymentapi.paymentapi.mappers;


import com.paymentapi.paymentapi.dto.request.ClientDTO;
import com.paymentapi.paymentapi.dto.response.ClientResponseDTO;
import com.paymentapi.paymentapi.model.Client;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO clientToClientDTO(Client client);

    ClientResponseDTO clientToClientResponseDTO(Client client);

    Client clientDTOToClient(ClientDTO clientDTO);

    Client clientResponseDTOToClient(ClientResponseDTO clientResponseDTO);

    //Page<ClientResponseDTO> toPageResponseDTO(Page<Client> clientPage);

}