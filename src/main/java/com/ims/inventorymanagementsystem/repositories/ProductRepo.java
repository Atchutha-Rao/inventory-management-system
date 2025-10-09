package com.ims.inventorymanagementsystem.repositories;

import com.ims.inventorymanagementsystem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
