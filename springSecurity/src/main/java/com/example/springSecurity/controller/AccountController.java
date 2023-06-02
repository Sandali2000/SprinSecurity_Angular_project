package com.example.springSecurity.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountController {

    //step 2 (using Method level security)
    //@Secured("ROLE_ADMIN")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")-------->mekedi methode eka athulata noya condition eka checked krnwa
    //PostAuthorize--------------->methode eka thuladi condition eka checked kryi
    @PostAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/my-account")
    public String getAccountDetails(){
        return ("get account details");
    }

}
