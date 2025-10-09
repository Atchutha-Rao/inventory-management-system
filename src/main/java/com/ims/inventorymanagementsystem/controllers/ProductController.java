package com.ims.inventorymanagementsystem.controllers;

import com.ims.inventorymanagementsystem.dto.ProductDTO;
import com.ims.inventorymanagementsystem.entities.Product;
import com.ims.inventorymanagementsystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> list() {
        return productService.getAll().stream().map(ProductDTO::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable long id) {
        return productService.getById(id)
                .map(ProductDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDto, @RequestParam(required = false) Integer categoryId) {
        Product entity = productDto.toEntity();
        Product saved = productService.create(entity, categoryId);
        return ResponseEntity.created(URI.create("/api/products/" + saved.getId())).body(ProductDTO.fromEntity(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable long id, @Valid @RequestBody ProductDTO productDto, @RequestParam(required = false) Integer categoryId) {
        Product entity = productDto.toEntity();
        return productService.update(id, entity, categoryId)
                .map(ProductDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
