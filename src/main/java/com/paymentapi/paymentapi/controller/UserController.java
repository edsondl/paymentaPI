package com.paymentapi.paymentapi.controller;

import com.paymentapi.paymentapi.dto.request.CredentialsRequestDTO;
import com.paymentapi.paymentapi.dto.request.UserLoginDTO;
import com.paymentapi.paymentapi.dto.response.TokenDTO;
import com.paymentapi.paymentapi.dto.response.UserLoginResponseDTO;
import com.paymentapi.paymentapi.exception.InvalidPasswordException;
import com.paymentapi.paymentapi.mappers.UserMapper;
import com.paymentapi.paymentapi.model.UserLogin;
import com.paymentapi.paymentapi.security.jwt.JwtService;
import com.paymentapi.paymentapi.service.implementation.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Api("Api Users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping
    @ApiOperation("Save a new user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Client saved successfully"),
            @ApiResponse(code = 400, message = "Validation Error"),
    })
    public ResponseEntity<UserLoginResponseDTO> save(@RequestBody @Valid UserLoginDTO userLogin) {
        return new ResponseEntity<>(
                userService.save(userLogin),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/auth")
    @ApiOperation("Generates a token")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Token successfully created"),
            @ApiResponse(code = 400, message = "Validation Error"),
    })
    public TokenDTO authenticate(@RequestBody @Valid CredentialsRequestDTO userLogin, HttpSession session) {
        try {
            UserLogin user = UserLogin.builder()
                    .login(userLogin.getLogin())
                    .password(userLogin.getPassword())
                    .build();
            UserDetails authenticate = userService.authenticate(user);
            String token = jwtService.createToken(user);
            return new TokenDTO(userLogin.getLogin(), token);

        } catch (UsernameNotFoundException | InvalidPasswordException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}