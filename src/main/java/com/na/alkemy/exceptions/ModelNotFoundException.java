package com.na.alkemy.exceptions;

/**
 * @author nestor.agredo
 * @project asmet
 * @class ModelNotFoundException
 */
public class ModelNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ModelNotFoundException(String message) {
        super(message);
    }
}
