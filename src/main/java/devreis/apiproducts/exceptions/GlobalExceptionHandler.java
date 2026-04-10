package devreis.apiproducts.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Tratando o erro de produto não encontrado, quando o ID do produto não existe no banco de dados.
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                "Produto não encontrado",
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    //Tratando o erro de tipo de argumento inválido, como por exemplo, quando o ID não é um UUID válido.
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                "ID inválido. Deve ser um UUID",
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    //Tratando o erro de validação dos campos, como por exemplo, quando o nome do produto é vazio ou o preço é negativo.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                "Erro na validação dos campos",
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /*
    Tratando o erro de corpo da requisição inválido,
    como por exemplo, quando o JSON enviado está mal formado ou faltando campos obrigatórios.
    */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                "Corpo da requisição inválido. Verifique os dados enviados.",
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
