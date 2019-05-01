package com.bsuir.course.rest;


import com.bsuir.course.domain.Role;
import com.bsuir.course.domain.User;
import com.bsuir.course.service.UserService;
import com.bsuir.course.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/account")
public class RegistrationApi {
    @Autowired
    private UserService userService;

    // request method to create a new account by a guest
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            return new ResponseEntity<>(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole(Role.USER.toString());

        return new ResponseEntity<>(userService.save(newUser), HttpStatus.CREATED);
    }

    // this is the login api/service
    @GetMapping("/login")
    public Principal user(Principal principal) {
        return principal;
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }


}
