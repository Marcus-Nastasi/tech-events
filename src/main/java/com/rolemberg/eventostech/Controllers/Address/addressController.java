package com.rolemberg.eventostech.Controllers.Address;

import com.rolemberg.eventostech.Domain.Address.AddressEventResponseDTO;
import com.rolemberg.eventostech.Services.Address.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, List<AddressEventResponseDTO>>> get() {
        return ResponseEntity.ok(Map.of("data", addressService.get()));
    }

    /*
    @PostMapping(value = "/create/{event_id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an addresses")
    @ApiResponse(responseCode = "201", description = "Creating the addresses")
    public ResponseEntity<Address> create(
            @PathVariable UUID event_id,
            @RequestBody EventRegisterDTO data
    ) {
        Address a = addressService.create(event_id, data);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }*/
}
