package com.me.myprojectapp.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.myprojectapp.pojo.Student;




public class UserValidator implements Validator {

	 @Override
	    public boolean supports(Class<?> type) {
	        return type.isAssignableFrom(Student.class);
	    }

	    @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "empty-firstname", "first name cannot be blank");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "empty-lastname", "last name cannot be blank");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nuid", "empty-nuid", "nuid cannot be blank");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password", "password cannot be blank");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "empty-email", "email cannot be blank");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "program", "empty-program", "program cannot be blank");
	    }
	
}
