package med.voll.API.REST.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    // Data not found
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    // Invalid fields
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return  ResponseEntity.badRequest().body(errors.stream().map(DataNotValidException::new).toList());
    }

    private record DataNotValidException(String field, String message) {
        public DataNotValidException(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
