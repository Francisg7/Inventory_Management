package com.eurekadevops.sabre.web.validation;

import com.eurekadevops.sabre.web.dto.LoginNewDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches a) {
    }

    @Override
    public boolean isValid(Object t, ConstraintValidatorContext cvc) {
        LoginNewDto loginDto = (LoginNewDto) t;
        
        return loginDto.getPassword().equals(loginDto.getConfirmPassword());
    }

}
