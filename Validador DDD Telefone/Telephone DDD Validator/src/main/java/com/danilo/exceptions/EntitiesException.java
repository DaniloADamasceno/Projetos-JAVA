package com.danilo.exceptions;

import java.io.Serial;

public class EntitiesException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntitiesException(String messageException) {
        super(messageException);
    }
}
