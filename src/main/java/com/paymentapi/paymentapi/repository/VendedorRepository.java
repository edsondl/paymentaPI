package com.paymentapi.paymentapi.repository;

import com.paymentapi.paymentapi.model.Vendedor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    @Query("Select c from Vendedor c where c.name =:name ")
    Page<Vendedor> findByName(@Param("name") String name, Pageable pageable);

   // @Query("Delete from Vendedor v where v.name = :name")
    void deleteByName( String name);

    boolean existsByName(String name);

    @Query("Select v from Vendedor v left join fetch v.orderItems where v.id = :id")
    Optional<Vendedor> findClientFetchOrderItem(@Param("id") Integer id);

    @Query("Select v from Vendedor v where v.name like %:name%")
    Optional<Vendedor> findByNameLike(@Param("name") String name);

    Optional<Vendedor> findById(Integer id);

    Page<Vendedor> findAll(Example example, Pageable pageable);

}
