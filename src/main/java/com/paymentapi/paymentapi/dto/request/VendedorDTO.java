package com.paymentapi.paymentapi.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paymentapi.paymentapi.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO implements Serializable {

    @NotEmpty(message = "Name field is required")
    private String name;

    @NotEmpty(message = "CPF field is required")
    @CPF(message = "CPF invalid")
    private String cpf;

    @NotEmpty(message = "E-mail field is required")
    @EMAIL(message = "E-mail invalid")
    private String email;

    @NotEmpty(message = "Telefone field is required")
    @TELEFONE(message = "Telefone invalid")
    private String telefone;

    @JsonIgnore
    private List<OrderItem> orderItems;

}