package com.ims.inventorymanagementsystem.service;

import com.ims.inventorymanagementsystem.entities.Category;
import com.ims.inventorymanagementsystem.entities.Product;
import com.ims.inventorymanagementsystem.repositories.CategoryRepo;
import com.ims.inventorymanagementsystem.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Optional<Product> getById(long id) {
        return productRepo.findById(id);
    }

    public Product create(Product product, Integer categoryId) {
        if (categoryId != null) {
            Category cat = (Category) categoryRepo.findById(categoryId).orElse(null);
            product.setCategory(cat);
        }
        return productRepo.save(product);
    }

    public Optional<Product> update(long id, Product updated, Integer categoryId) {
        return productRepo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setPrice(updated.getPrice());
            existing.setQuantity(updated.getQuantity());
            if (categoryId != null) {
                Object cat = categoryRepo.findById(categoryId).orElse(null);

                existing.setCategory((Category) cat);
            }
            return productRepo.save(existing);
        });
    }

    public void delete(long id) {

        productRepo.deleteById(id);
    }
}
