package com.rolemberg.eventostech.Controllers.Users;

import com.rolemberg.eventostech.Domain.Users.User;
import com.rolemberg.eventostech.Domain.Users.UserRegisterDTO;
import com.rolemberg.eventostech.Services.Users.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Getting all users", description = "You can get all users.")
    @ApiResponse(responseCode = "200", description = "Getting the user")
    public ResponseEntity<List<User>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size < 1) size = 10;
        return ResponseEntity.ok(this.userService.getAll(page, size));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating user", description = "You can create a user.")
    @ApiResponse(responseCode = "201", description = "Creating the user")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterDTO user) {
         return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.register(user));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deleting user", description = "You can delete a user.")
    @ApiResponse(responseCode = "200", description = "Deleting the user")
    public ResponseEntity<User> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
