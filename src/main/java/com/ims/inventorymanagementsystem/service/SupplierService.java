//package com.ims.inventorymanagementsystem.service;
//
//import com.ims.inventorymanagementsystem.dtos.Response;
//import com.ims.inventorymanagementsystem.dtos.SupplierDTO;
//import com.ims.inventorymanagementsystem.entities.Supplier;
//import com.ims.inventorymanagementsystem.exceptions.NotFoundException;
//import com.ims.inventorymanagementsystem.repositories.SupplierRepo;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class SupplierService{
//
//
//    private final SupplierRepo supplierRepository;
//    private final ModelMapper modelMapper;
//
//
//
//    public Response addSupplier(SupplierDTO supplierDTO) {
//
//        Supplier supplierToSave = modelMapper.map(supplierDTO, Supplier.class);
//
//        supplierRepository.save(supplierToSave);
//
//        return Response.builder()
//                .status(200)
//                .message("Supplier Saved Successfully")
//                .build();
//    }
//
//
//    public Response updateSupplier(Long id, SupplierDTO supplierDTO) {
//
//        Supplier existingSupplier = supplierRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));
//
//        if (supplierDTO.getName() != null) existingSupplier.setName(supplierDTO.getName());
//        if (supplierDTO.getContactInfo() != null) existingSupplier.setContactInfo(supplierDTO.getContactInfo());
//        if (supplierDTO.getAddress() != null) existingSupplier.setAddress(supplierDTO.getAddress());
//
//        supplierRepository.save(existingSupplier);
//
//        return Response.builder()
//                .status(200)
//                .message("Supplier Was Successfully Updated")
//                .build();
//    }
//
//
//    public Response getAllSupplier() {
//
//        List<Supplier> suppliers = supplierRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//
//        List<SupplierDTO> supplierDTOList = modelMapper.map(suppliers, new TypeToken<List<SupplierDTO>>() {
//        }.getType());
//
//        return Response.builder()
//                .status(200)
//                .message("success")
//                .suppliers(supplierDTOList)
//                .build();
//    }
//
//
//    public Response getSupplierById(Long id) {
//
//        Supplier supplier = supplierRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));
//
//        SupplierDTO supplierDTO = modelMapper.map(supplier, SupplierDTO.class);
//
//        return Response.builder()
//                .status(200)
//                .message("success")
//                .supplier(supplierDTO)
//                .build();
//    }
//
//
//    public Response deleteSupplier(Long id) {
//
//        supplierRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));
//
//        supplierRepository.deleteById(id);
//
//        return Response.builder()
//                .status(200)
//                .message("Supplier Was Successfully Deleted")
//                .build();
//    }
//}


package com.ims.inventorymanagementsystem.service;

import com.ims.inventorymanagementsystem.dtos.Response;
import com.ims.inventorymanagementsystem.dtos.SupplierDTO;
import com.ims.inventorymanagementsystem.entities.Supplier;
import com.ims.inventorymanagementsystem.exceptions.NotFoundException;
import com.ims.inventorymanagementsystem.repositories.SupplierRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplierService {

    private final SupplierRepo supplierRepository;
    private final ModelMapper modelMapper;

    public Response addSupplier(SupplierDTO supplierDTO) {
        Supplier supplierToSave = modelMapper.map(supplierDTO, Supplier.class);
        supplierRepository.save(supplierToSave);

        return Response.builder()
                .status(200)
                .message("Supplier Saved Successfully")
                .build();
    }

    public Response updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));

        if (supplierDTO.getSupplierName() != null) existingSupplier.setName(supplierDTO.getSupplierName());
        if (supplierDTO.getSupplierContactInfo() != null) existingSupplier.setContactInfo(supplierDTO.getSupplierContactInfo());
        if (supplierDTO.getSupplierAddress() != null) existingSupplier.setAddress(supplierDTO.getSupplierAddress());

        supplierRepository.save(existingSupplier);

        return Response.builder()
                .status(200)
                .message("Supplier Was Successfully Updated")
                .build();
    }

    public Response getAllSupplier() {
        List<Supplier> suppliers = supplierRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<SupplierDTO> supplierDTOList = modelMapper.map(suppliers, new TypeToken<List<SupplierDTO>>() {}.getType());

        return Response.builder()
                .status(200)
                .message("Success")
                .suppliers(supplierDTOList)
                .build();
    }

    public Response getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));

        SupplierDTO supplierDTO = modelMapper.map(supplier, SupplierDTO.class);

        return Response.builder()
                .status(200)
                .message("Success")
                .supplier(supplierDTO)
                .build();
    }

    public Response deleteSupplier(Long id) {
        supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier Not Found"));

        supplierRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("Supplier Was Successfully Deleted")
                .build();
    }
}