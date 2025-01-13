package br.com.alura.forumhub.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
          return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();  
        
        return ResponseEntity.badRequest().body(erros.stream().map(DadosValidation::new).toList());
    }

    private record DadosValidation(String campo, String mensagem){
        public DadosValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }     
        
    }
}
