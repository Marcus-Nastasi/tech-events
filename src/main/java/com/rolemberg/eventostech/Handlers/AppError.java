package com.rolemberg.eventostech.Handlers;

import java.io.Serial;

public class AppError extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public AppError(String message) {
        super(message);
    }
}
