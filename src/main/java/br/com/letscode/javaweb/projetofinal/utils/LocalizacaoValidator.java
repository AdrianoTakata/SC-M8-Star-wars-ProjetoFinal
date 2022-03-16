package br.com.letscode.javaweb.projetofinal.utils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;

public class LocalizacaoValidator implements ConstraintValidator<LocalValid, Localizacao> {


    @Override
    public void initialize(LocalValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Localizacao value, ConstraintValidatorContext context) {
        if(value.getLatitude() != null &&
                value.getLongitude() != null &&
                value.getNomeGalaxia() != null &&
                !value.getNomeGalaxia().isEmpty()) {
            return true;
        }
        return false;
    }
}
