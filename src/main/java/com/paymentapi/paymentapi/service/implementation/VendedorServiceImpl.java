package com.paymentapi.paymentapi.service.implementation;

import com.paymentapi.paymentapi.exception.BusinessRuleException;
import com.paymentapi.paymentapi.model.Vendedor;
import com.paymentapi.paymentapirepository.VendedorRepository;
import com.paymentapi.paymentapi.service.interfaces.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    @Override
    public Vendedor findByNameLike(String name) {
        Optional<Vendedor> vendedor = vendedorRepository.findByNameLike(name);
        return vendedor.orElseThrow(()-> new BusinessRuleException("Vendedor not found"));
    }

    @Override
    public Optional<Vendedor> findById(Integer id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        return vendedor;
    }

    @Override
    public Page<Vendedor> findByName(String name, Pageable pageable) {
        Page<vendedore> vendedores = vendedorRepository.findByName(name, pageable);
        return vendedor;
    }

    @Override
    public Page<Vendedor> findAll(Example example, Pageable pageable) {
        Optional<Page<Vendedor>> vendedores = Optional.ofNullable(vendedorRepository.findAll(example, pageable));
        return vendedores.orElseThrow(()-> new BusinessRuleException("Vendedor not found"));
    }

    @Override
    public Vendedor findClientFetchOrderItem(Integer id) {
        Optional<Vendedor> vendedor = clientRepository.findClientFetchOrderItem(id);
        return vendedor.orElseThrow(()-> new BusinessRuleException("Vendedor not found"));
    }

    @Override
    public boolean existsByName(String name) {
        return vendedorRepository.existsByName(name);
    }

    @Override
    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public void deleteByName(String name) {
        vendedorRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        vendedorRepository.deleteById(id);
    }

    @Override
    public Vendedor updateById(Integer id, Vendedor vendedor) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isPresent()) {
            vendedorOptional.get().setName(vendedor.getName());
            return vendedorRepository.save(vendedorOptional.get());
        }
        return vendedorRepository.save(vendedor);
    }
    public List<vendedor> findAll(Example example){
        return vendedorRepository.findAll(example);
    }

}