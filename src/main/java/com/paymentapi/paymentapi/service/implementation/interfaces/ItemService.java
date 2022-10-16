package com.paymentapi.paymentapi.service.interfaces;

import com.paymentapi.paymentapi.model.Item;

import java.util.List;


public interface ItemService {
    List<Item> saveAll(Iterable<Item> iterable);
}