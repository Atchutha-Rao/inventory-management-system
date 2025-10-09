package com.ims.inventorymanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Suppliers")
@Data
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    @NotBlank(message = "Name is required")
    private String supplierName;
    @NotBlank(message = " supplierContactInfo is required")
    private String supplierContactInfo;
    @NotBlank(message = "supplierAddress is required")
    private String supplierAddress;



}
