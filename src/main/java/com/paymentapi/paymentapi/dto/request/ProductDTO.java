package com.paymentapi.paymentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @NotEmpty(message = "Description field is required")
    private String description;

    @NotNull(message = "Price field is required")
    private BigDecimal price;
}

UpdteOrderSttusDTO.java

package .dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UpdateOrderStatusDTO implements Serializable {

    private String newStatus;
}
