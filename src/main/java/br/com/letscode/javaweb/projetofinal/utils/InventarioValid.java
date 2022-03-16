package br.com.letscode.javaweb.projetofinal.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy =  InventarioValidator.class)
public @interface InventarioValid {

    String message() default "INVENTARIO INVALIDO";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";

}
