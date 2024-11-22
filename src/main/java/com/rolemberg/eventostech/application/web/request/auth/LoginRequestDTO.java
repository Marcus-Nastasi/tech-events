package com.rolemberg.eventostech.application.web.request.auth;

public record LoginRequestDTO(
   String email,
   String password
) {}
