package br.com.fiap.spoiledgirlsclub.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TamanhoValidator implements ConstraintValidator<Tamanho, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("PP") || value.equals("P") || value.equals("M") || value.equals("G") || value.equals("GG");
    }

}
