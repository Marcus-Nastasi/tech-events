package com.rolemberg.eventostech.Controllers.Auth;

import com.rolemberg.eventostech.Domain.Users.LoginRequestDTO;
import com.rolemberg.eventostech.Domain.Users.LoginResponseDTO;
import com.rolemberg.eventostech.Repository.Users.UsersRepo;
import com.rolemberg.eventostech.Services.Auth.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        UserDetails userDetails = usersRepo.findByEmail(data.email());
        if (!passwordEncoder.matches(data.password(), userDetails.getPassword())) return ResponseEntity
            .badRequest()
            .build();
        return ResponseEntity
            .ok(new LoginResponseDTO(tokenService.generate(userDetails.getUsername())));
    }
}
