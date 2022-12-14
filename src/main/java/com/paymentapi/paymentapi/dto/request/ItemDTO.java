package com.paymentapi.paymentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

    private Integer product;

    private Integer quantity;


}