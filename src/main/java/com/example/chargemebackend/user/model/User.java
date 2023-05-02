package com.example.chargemebackend.user.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name= "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Enumerated
    @Column(name = "role")
    private Role role;

    public User() {
    }


    public User(UUID id, String firstName, String lastName, String email, String password, String phoneNumber, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

}
