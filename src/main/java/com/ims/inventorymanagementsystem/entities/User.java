package com.ims.inventorymanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "Phone Number cannot be empty")
    private long phoneNumber;

    @OneToMany(mappedBy = "users")
    private List<Transaction> transactions;
    private final LocalDateTime created = LocalDateTime.now();

}
