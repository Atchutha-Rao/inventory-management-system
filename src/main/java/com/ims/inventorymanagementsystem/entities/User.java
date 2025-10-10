package com.ims.inventorymanagementsystem.entities;

import com.ims.inventorymanagementsystem.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    private final LocalDateTime created = LocalDateTime.now();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", role=" + role +
                ", created=" + created +
                '}';
    }
}
