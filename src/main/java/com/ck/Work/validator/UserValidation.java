package com.ck.Work.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ck.Work.models.User;

@Component
public class UserValidation implements Validator{
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	@Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
