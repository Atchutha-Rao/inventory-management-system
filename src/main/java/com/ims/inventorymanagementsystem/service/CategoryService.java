package com.ims.inventorymanagementsystem.service;

import com.ims.inventorymanagementsystem.dtos.CategoryDTO;
import com.ims.inventorymanagementsystem.entities.Category;
import com.ims.inventorymanagementsystem.repositories.CategoryRepo;
import jakarta.xml.ws.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepo categoryRepo;

    private ModelMapper modelMapper;

    public <Category>Response createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(CategoryDTO,Category.class);
        category.savedCategory = CategoryRepo.save(categoryTosave);
        return Response.builder()
                .build()
    }
}
