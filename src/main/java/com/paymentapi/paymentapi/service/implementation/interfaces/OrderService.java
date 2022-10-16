package com.paymentapi.paymentapi.service.interfaces;

import com.paymentapi.paymentapi.dto.request.OrderDTO;
import com.paymentapi.paymentapi.dto.response.ItemResponseDTO;
import com.paymentapi.paymentapi.dto.response.OrderResponseDTO;
import com.paymentapi.paymentapi.enums.OrderStatus;
import com.paymentapi.paymentapi.model.Item;
import com.paymentapi.paymentapi.model.OrderItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface OrderService {

    Optional<OrderItem> findById(Integer id);

    Optional<Page<OrderItem>> findAll(Pageable pageable);

    Optional<Page<OrderItem>> findOrderItemByClient(Integer id, Pageable pageable);

    void deleteById(Integer id);

    OrderItem save(OrderDTO orderItem);

    OrderItem save(OrderItem orderItem);

    Page<OrderItem> findAll(Example example, Pageable pageable);

    BigDecimal findPriceTotal(Integer id);

    OrderItem updateById(Integer id, OrderItem orderItem);

    Optional<OrderItem> getOrderComplete(Integer id);

    OrderResponseDTO convertOrder(OrderItem order);

    List<ItemResponseDTO> convertToItemDTO(List<Item> items);

    Page<OrderResponseDTO> convertListOrder(Page<OrderItem> order);

    void updateStatus(Integer id, OrderStatus status);
}
