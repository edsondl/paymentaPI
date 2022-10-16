package com.paymentapi.paymentapi.service.interfaces;

import com.paymentapi.paymentapi.dto.request.VendedorDTO;
import com.paymentapi.paymentapi.dto.response.VendedorResponseDTO;
import com.paymentapi.paymentapi.model.Vendedor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VendedorService {
    VendedorResponseDTO findByNameLike(String name);

    VendedorResponseDTO findById(Integer id);

    Page<VendedorResponseDTO> findByName(String name, Pageable pageable);

    VendedorResponseDTO findVendedorFetchOrderItem(Integer id);

    boolean existsByName(String name);

    VendedorResponseDTO save(VendedorDTO vendedorDTO);

    void deleteByName(String name);

    void deleteById(Integer id);

    VendedorResponseDTO updateById(Integer id, VendedorDTO VendedorDTO);

    Page<VendedorResponseDTO> findAll(Example example, Pageable pageable);


    Page<VendedorResponseDTO> findAllByExample(Pageable pageable, VendedorDTO filter);
}
