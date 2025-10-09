package com.ims.inventorymanagementsystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {
    @Positive(message = "Product ID is required")
    private Long productId;

    @Positive(message = "Quantity ID is required")
    private Long quantityId;

    private Long supplierId;

    private String description;
    private String note;
}
