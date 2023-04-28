package com.Java_Proyect.Spring.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString @EqualsAndHashCode
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "surname")
    @Getter @Setter
    private String surname;

    @Column(name = "email")
    @Getter @Setter
    private String email;


    @Column(name = "phone")
    @Getter @Setter
    private String phone;

    @Column(name = "password")
    @Getter @Setter
    private String password;


}
