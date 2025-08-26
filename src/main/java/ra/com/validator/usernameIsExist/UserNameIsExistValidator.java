package ra.com.validator.usernameIsExist;

import org.springframework.beans.factory.annotation.Autowired;
import ra.com.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameIsExistValidator implements ConstraintValidator<UserNameIsExist, String> {

    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.checkUserName(s);
    }
}
