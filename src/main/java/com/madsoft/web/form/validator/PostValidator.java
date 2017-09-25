package com.madsoft.web.form.validator;

import com.madsoft.web.form.PostForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class PostValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return PostForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        PostForm postForm = (PostForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "title must not be empty.");
        String title = postForm.getTitle();
        if ((title.length()) < 3) {
            errors.rejectValue("title", "title.tooShort", "Title must not less than 3 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.empty", "Text must not be empty.");

    }
}
