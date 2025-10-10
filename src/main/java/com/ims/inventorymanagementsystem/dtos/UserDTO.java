package com.ims.inventorymanagementsystem.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ims.inventorymanagementsystem.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private int id;

    private String username;

    private String email;

    private String phoneNumber;

    @JsonIgnore
    private String password;
    private UserRole role;

    private List<TransactionDTO> transactions;

    private LocalDateTime createdAt;
}
