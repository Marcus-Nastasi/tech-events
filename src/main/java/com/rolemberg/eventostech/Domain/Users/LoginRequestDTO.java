package com.rolemberg.eventostech.Domain.Users;

public record LoginRequestDTO(
   String email,
   String password
) {}
