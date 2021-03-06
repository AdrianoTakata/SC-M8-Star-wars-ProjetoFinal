package br.com.letscode.javaweb.projetofinal.utils;

import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy =  LocalizacaoValidator.class)
public @interface LocalValid {
    String message() default "LOCALIZACAO INVALIDA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";

}
