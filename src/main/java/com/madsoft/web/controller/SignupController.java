package com.madsoft.web.controller;



import com.madsoft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madsoft.web.form.SignupForm;
import com.madsoft.web.form.validator.SignupValidator;

@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private SignupValidator signupValidator;

    @Autowired
    private UserService userService;// = new UserService();//userService;//

    @RequestMapping(method = RequestMethod.GET)
    public String signup(ModelMap model) {
        SignupForm signupForm = new SignupForm();
        model.put("signupForm", signupForm);
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(SignupForm signupForm, BindingResult result) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return "signup";
        }
        System.out.println("go to addUser()");
        Integer id = userService.addUser(signupForm.getUsername(), signupForm.getPassword(), signupForm.getEmail());

        return "signup-success";
    }
}
