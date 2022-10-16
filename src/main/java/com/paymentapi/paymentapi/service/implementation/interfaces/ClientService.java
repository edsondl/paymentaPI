package com.paymentapi.paymentapi.service.interfaces;

import com.paymentapi.paymentapi.dto.request.ClientDTO;
import com.paymentapi.paymentapi.dto.response.ClientResponseDTO;
import com.paymentapi.paymentapi.model.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientService {
    ClientResponseDTO findByNameLike(String name);

    ClientResponseDTO findById(Integer id);

    Page<ClientResponseDTO> findByName(String name, Pageable pageable);

    ClientResponseDTO findClientFetchOrderItem(Integer id);

    boolean existsByName(String name);

    ClientResponseDTO save(ClientDTO clientDTO);

    void deleteByName(String name);

    void deleteById(Integer id);

    ClientResponseDTO updateById(Integer id, ClientDTO clientDTO);

    Page<ClientResponseDTO> findAll(Example example, Pageable pageable);


    Page<ClientResponseDTO> findAllByExample(Pageable pageable, ClientDTO filter);
}