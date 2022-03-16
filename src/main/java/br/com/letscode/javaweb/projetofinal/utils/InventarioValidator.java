package br.com.letscode.javaweb.projetofinal.utils;

import br.com.letscode.javaweb.projetofinal.model.Inventario;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventarioValidator implements ConstraintValidator<InventarioValid, Inventario> {
    @Override
    public void initialize(InventarioValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Inventario value, ConstraintValidatorContext context) {
        if(value.getNumeroAgua() >= 0 &&
            value.getNumeroArma() >= 0 &&
            value.getNumeroComida() >= 0 &&
            value.getNumeroMunicao() >= 0){
            return true;
        }
        return false;
    }
}
