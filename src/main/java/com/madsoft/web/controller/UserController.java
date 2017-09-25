package com.madsoft.web.controller;

import com.madsoft.web.model.User;
import com.madsoft.web.service.IPostService;
import com.madsoft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private IPostService postService;
    // show user profile
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)

    public String showUserProfile(@PathVariable String username, Model model) {

        User user = userService.getUser(username);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);
        model.addAttribute("postcount", postService.getPostsCountByUser(username));

        return "user/profile";

    }

}

