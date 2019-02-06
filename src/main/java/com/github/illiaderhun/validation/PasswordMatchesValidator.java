package com.github.illiaderhun.validation;

import com.github.illiaderhun.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    public void initialize(PasswordMatches constraint) {
    }

    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
