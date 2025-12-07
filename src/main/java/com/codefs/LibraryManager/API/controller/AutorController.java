package com.codefs.LibraryManager.API.controller;

import com.codefs.LibraryManager.API.dto.AutorRequestDTO;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codefs.LibraryManager.API.service.IAutorService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    @Autowired
    private IAutorService autorService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody AutorRequestDTO autorRequestDTO){
        return new ResponseEntity<>(autorService.save(autorRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AutorRequestDTO autorRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(autorService.update(autorRequestDTO.getId(), autorRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try{
            autorService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID no valida");
        }
    }
}
