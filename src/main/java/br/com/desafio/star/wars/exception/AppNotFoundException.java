package br.com.desafio.star.wars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AppNotFoundException() {
        super();
    }
    public AppNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AppNotFoundException(String message) {
        super(message);
    }
    public AppNotFoundException(Throwable cause) {
        super(cause);
    }
}
