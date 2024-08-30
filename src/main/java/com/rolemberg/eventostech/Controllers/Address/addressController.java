package com.rolemberg.eventostech.Controllers.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Services.Address.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/address")
@RestControllerAdvice
public class addressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all addresses")
    @ApiResponse(responseCode = "200", description = "Found the addresses")
    public ResponseEntity<List<Address>> get() {
        return ResponseEntity.ok(addressService.get());
    }
}
