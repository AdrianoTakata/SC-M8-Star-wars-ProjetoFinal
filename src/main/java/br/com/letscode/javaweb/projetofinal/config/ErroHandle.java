package br.com.letscode.javaweb.projetofinal.config;

import br.com.letscode.javaweb.projetofinal.exception.ErroValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroHandle {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacao> manipularErroValidacao(MethodArgumentNotValidException exception){
        List<ErroValidacao> erros = new ArrayList<>();
        List<FieldError> camposErro = exception.getBindingResult().getFieldErrors();
        camposErro.forEach(e ->{
            String mensagem =  messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroValidacao erro = new ErroValidacao(e.getField(), mensagem);
            erros.add(erro);
        });
        return  erros;
    }



}
