package com.ims.inventorymanagementsystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ims.inventorymanagementsystem.entities.Product;
import com.ims.inventorymanagementsystem.entities.Supplier;
import com.ims.inventorymanagementsystem.entities.User;
import com.ims.inventorymanagementsystem.enums.TransactionStatus;
import com.ims.inventorymanagementsystem.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
    private long id;
    private int totalProducts;
    private double totalPrice;

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private String description;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProductDTO product;

    private UserDTO user;

    private SupplierDTO supplier;
}