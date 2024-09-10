package com.rolemberg.eventostech.Domain.Users;

public record UserRegisterDTO(
   String name,
   String email,
   String password
) {}
