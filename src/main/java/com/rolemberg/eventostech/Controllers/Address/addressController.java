package com.rolemberg.eventostech.Controllers.Address;

import com.rolemberg.eventostech.Domain.Address.AddressEventResponseDTO;
import com.rolemberg.eventostech.Domain.Address.AddressUpdateDTO;
import com.rolemberg.eventostech.Services.Address.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public ResponseEntity<Map<String, List<AddressEventResponseDTO>>> get(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(Map.of("data", addressService.get(page, size)));
    }

    @PostMapping(value = "/create/{event_id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an addresses")
    @ApiResponse(responseCode = "201", description = "Creating the addresses")
    public ResponseEntity<Map<String, AddressEventResponseDTO>> create(
            @PathVariable UUID event_id,
            @RequestBody AddressUpdateDTO data
    ) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Map.of("data", addressService.create(event_id, data)));
    }

    @PatchMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an address")
    @ApiResponse(responseCode = "200", description = "Updating the address")
    public ResponseEntity<Map<String, AddressEventResponseDTO>> update(
            @PathVariable("id") UUID id,
            @RequestBody AddressUpdateDTO data
    ) {
        AddressEventResponseDTO a = addressService.update(id, data);
        return ResponseEntity.ok(Map.of("data", a));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete an address")
    @ApiResponse(responseCode = "200", description = "Deleting the address")
    public ResponseEntity<Map<String, AddressEventResponseDTO>> delete(@PathVariable("id") UUID id) {
        AddressEventResponseDTO a = addressService.delete(id);
        return ResponseEntity.ok(Map.of("data", a));
    }
}
