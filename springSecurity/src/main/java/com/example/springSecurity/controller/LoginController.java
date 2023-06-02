package com.example.springSecurity.controller;

import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        ResponseEntity response= null;
                try{
                    String hashPassword = passwordEncoder.encode(user.getPassword());
                    user.setPassword(hashPassword);
                    //role eka hasRole krmayata gnimata
                    user.setRole("ROLE_"+user.getRole());
                    User saveUser = userRepo.save(user);
                    if(saveUser.getId()>0){
                        response = ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body("saved users");
                    }

                }catch (Exception ex){
                    response = ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body("An exception is " + ex);

                }
                return response;
    }
}
