package com.ims.inventorymanagementsystem.repositories;


import com.ims.inventorymanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
