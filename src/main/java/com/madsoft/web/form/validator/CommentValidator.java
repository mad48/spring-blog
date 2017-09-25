package com.madsoft.web.form.validator;

import com.madsoft.web.form.CommentForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CommentValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return CommentForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        CommentForm commentForm = (CommentForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "name must not be empty.");
        String name = commentForm.getName();
        if ((name.length()) < 1) {
            errors.rejectValue("name", "name.tooShort", "Title must not less than 1 characters.");
        }


        if (commentForm.getEmail().length() > 0) {
            if (!EmailValidator.getInstance().isValid(commentForm.getEmail())) {
                errors.rejectValue("email", "email.notValid", "Email address is not valid.");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.empty", "Text must not be empty.");

    }
}
