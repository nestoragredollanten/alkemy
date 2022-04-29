package com.na.alkemy.exceptions;

/**
 * @author nestor.agredo
 * @project asmet
 * @class ArgumentRequiredException
 */
public class ArgumentRequiredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ArgumentRequiredException(String mensaje) {
        super(mensaje);
    }

}
