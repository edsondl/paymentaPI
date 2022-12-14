package com.paymentapi.paymentapi.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.paymentapi.paymentapi.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO implements Serializable {

    private Integer id;

    private String name;

    private String cpf;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderItem> orderItems;
}
