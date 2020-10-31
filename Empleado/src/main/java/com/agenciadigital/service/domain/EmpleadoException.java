package com.agenciadigital.service.domain;

public class EmpleadoException extends RuntimeException {
	
	public EmpleadoException() {
        super();
    }

	public EmpleadoException(String message) {
        super(message);
    }

	public EmpleadoException(String message, Throwable cause) {
        super(message, cause);
    }

	public EmpleadoException(Throwable cause) {
        super(cause);
    }

	protected EmpleadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
