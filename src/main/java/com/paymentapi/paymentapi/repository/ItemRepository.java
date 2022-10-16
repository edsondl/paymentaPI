package com.paymentapi.paymentapi.repository;

import com.paymentapi.paymentapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}