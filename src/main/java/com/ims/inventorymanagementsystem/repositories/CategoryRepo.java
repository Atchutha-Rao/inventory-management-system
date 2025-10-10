package com.ims.inventorymanagementsystem.repositories;

import com.ims.inventorymanagementsystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    Optional<Category> findById(Long categoryId);
}
