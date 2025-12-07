package com.codefs.LibraryManager.API.controller;

import com.codefs.LibraryManager.API.dto.LibroRequestDTO;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codefs.LibraryManager.API.service.ILibroService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(libroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LibroRequestDTO libroRequestDTO){
        return ResponseEntity.ok(libroService.save(libroRequestDTO));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody LibroRequestDTO libroRequestDTO){
        return ResponseEntity.ok(libroService.update(libroRequestDTO.getId(),libroRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            libroService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.ok("El libro no existe");
        }
    }

}
