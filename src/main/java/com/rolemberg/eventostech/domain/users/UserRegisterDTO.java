package com.rolemberg.eventostech.domain.users;

public record UserRegisterDTO(
   String name,
   String email,
   String password
) {}
