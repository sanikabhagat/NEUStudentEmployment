package com.me.myprojectapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myprojectapp.pojo.User;

	
	public class LoginValidator implements Validator {

		 @Override
		    public boolean supports(Class<?> type) {
		        return type.isAssignableFrom(User.class);
		    }

		    @Override
		    public void validate(Object o, Errors errors) {
		        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "empty-email", "email cannot be blank");
		        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password", "password cannot be blank");
		    }
		
	}
