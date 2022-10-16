package com.paymentapi.paymentapi.mappers;

import com.paymentapi.paymentapi.dto.request.UserLoginDTO;
import com.paymentapi.paymentapi.dto.response.UserLoginResponseDTO;
import com.paymentapi.paymentapi.model.UserLogin;
import org.mapstruct.Mapper;



@Mapper(componentModel="spring")
public interface UserMapper {


    UserLogin userLoginDTOToUserLogin(UserLoginDTO userLoginDTO);

    UserLoginResponseDTO userLoginToUserLoginResponseDTO(UserLogin userLogin);


}