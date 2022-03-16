package br.com.letscode.javaweb.projetofinal.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GeneroValidator implements ConstraintValidator<Genero, Character> {


    @Override
    public void initialize(Genero constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Character value, ConstraintValidatorContext context) {
        if (value == 'M' || value == 'm' || value == 'F' || value == 'f'){
            return true;
        }
        return false;
    }
}
