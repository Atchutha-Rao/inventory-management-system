package com.ims.inventorymanagementsystem.repositories;

import java.util.Optional;

public interface CategoryRepo {

    Optional<Object> findById(Integer categoryId);
}
