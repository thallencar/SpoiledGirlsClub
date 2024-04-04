package br.com.fiap.spoiledgirlsclub.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TamanhoValidator.class)
public @interface Tamanho {

    String message() default "Utilize uma opção valida sendo elas PP, P, M, G, GG";

    Class<?>[] groups() default{};

    Class<? extends Payload> [] payload() default{};

}
