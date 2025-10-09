package com.ims.inventorymanagementsystem.repositories;

import com.ims.inventorymanagementsystem.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepo extends JpaRepository<Supplier,Long> {
}
