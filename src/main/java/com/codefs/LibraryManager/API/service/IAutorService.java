package com.codefs.LibraryManager.API.service;


import com.codefs.LibraryManager.API.dto.AutorRequestDTO;
import com.codefs.LibraryManager.API.dto.AutorResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IAutorService {
    List<AutorResponseDTO> findAll();
    AutorResponseDTO findById(UUID id);
    AutorResponseDTO save(AutorRequestDTO autorRequestDTO);
    AutorResponseDTO update(UUID id, AutorRequestDTO autorRequestDTO);
    void delete(UUID id);
}
