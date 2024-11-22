package com.rolemberg.eventostech.application.web.request.users;

public record UserRequestDto(
   String name,
   String email,
   String password
) {}
