package com.example.springSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column(name = "password", length = 100 , nullable = false)
    private String  password;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "role", length = 100 , nullable = false)
    private String  role;


}
