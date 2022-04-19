package br.edu.ufal.estudo.carros.api.exception;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({
		EmptyResultDataAccessException.class
	})
	public ResponseEntity<?> erroNotFound(Exception ex){
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({
		IllegalArgumentException.class
	})
	public ResponseEntity<?> erroBadRequest(Exception ex){
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler({
		AccessDeniedException.class
    })
	public ResponseEntity<?> accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Acesso Negado!"));
    }
	
	
}

class Error {
    public String error;

    public Error(String error) {
        this.error = error;
    }
}
