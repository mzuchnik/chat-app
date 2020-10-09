package pl.mzuchnik.communicatorserver.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface UniqueUsername {

    String message() default "This username is already taken";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}