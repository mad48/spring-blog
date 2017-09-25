/*
в процессе


package com.mkyong.web.service;


import com.mkyong.web.form.UserForm;
import User;
import org.springframework.security.access.preuser.UserAuthorize;
import org.springframework.security.access.preuser.PreAuthorize;

import java.util.List;


public interface IUserService {
    //@PreAuthorize("hasRole('ROLE_WRITE')")
    public Integer addUser(UserForm userForm);

    //@UserAuthorize("returnObject.owner == authentication.name")
    public User getUser(Integer UserId);

    @PreAuthorize("#user.owner == authentication.name")
    public void deleteUser(User user);

    @PreAuthorize("#user.owner == authentication.name")
    public void updateUser(User user, UserForm userForm);//public void updateUser(Integer userId, UserForm userForm);


    List findAllUsers();//<User>
}*/
