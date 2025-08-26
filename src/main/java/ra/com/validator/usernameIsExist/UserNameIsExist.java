package ra.com.validator.usernameIsExist;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = UserNameIsExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface UserNameIsExist {
    String message() default "Username is not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
