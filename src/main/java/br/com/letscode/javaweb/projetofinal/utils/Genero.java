package br.com.letscode.javaweb.projetofinal.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy =  GeneroValidator.class)
public @interface Genero {

    String message() default "Genero Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";

}
