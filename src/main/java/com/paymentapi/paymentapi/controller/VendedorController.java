package com.paymentapi.paymentapi.controller;

import com.paymentapi.paymentapi.model.Vendedor;
import com.paymentapi.paymentapi.service.interfaces.VendedorService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/vendedores")
@Api("Api Vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updated a vendedor by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vendedor updated successfully"),
            @ApiResponse(code = 400, message = "Validation Error"),
            @ApiResponse(code = 404, message = "Vendedor not found by the given id"),
    })
    public Vendedor updateById(@PathVariable Integer id,
                             @RequestBody @Valid Vendedor vendedor) {
        return vendedorService.findById(id)
                .map(c -> {
                    vendedor.setId(c.getId());
                    vendedorService.save(vendedor);
                    return vendedor;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor not found"));
    }

    @GetMapping
    @ApiOperation("Search all vendedores")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vendedores found successfully"),
            @ApiResponse(code = 404, message = "Vendedores not found"),
    })
    public ResponseEntity<Page<Vendedor>> findAll(@PageableDefault(size = 5)  Pageable pageable, Client filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        Page<Vendedor> vendedores = vendedorService.findAll(example, pageable);
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for a vendedor by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vendedor found successfully"),
            @ApiResponse(code = 404, message = "Vendedor not found by the given id"),
    })
    public ResponseEntity findById(@PathVariable Integer id) {
        Optional<Vendedor> vendedor = vendedorService.findById(id);
        return vendedor.map(value -> new ResponseEntity(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byName/{name}")
    @ApiOperation("Search for a Vendedor by name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vendedor found successfully"),
            @ApiResponse(code = 404, message = "Vendedor not found by the given name"),
    })
    public ResponseEntity<Page<Vendedor>> findByName(@PathVariable String name, @PageableDefault(size = 5) Pageable pageable) {
        Page<Vendedor> vendedores = vendedorService.findByName(name, pageable);
        return ResponseEntity.ok(vendedores);
    }

    @PostMapping
    @ApiOperation("Save a new vendedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Vendedor saved successfully"),
            @ApiResponse(code = 400, message = "Validation Error"),
    })
    public ResponseEntity<Vendedor> save(@RequestBody @Valid Vendedor vendedor) {
        return new ResponseEntity<>(vendedorService.save(vendedor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a vendedor by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vendedor found successfully"),
            @ApiResponse(code = 404, message = "Vendedor not found by the given id"),
    })
    public ResponseEntity deleteById(@PathVariable Integer id) {
        if (clientService.findById(id).isPresent()) {
            clientService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}