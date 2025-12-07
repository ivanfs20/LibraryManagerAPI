package com.codefs.LibraryManager.API.service;

import com.codefs.LibraryManager.API.dto.LibroRequestDTO;
import com.codefs.LibraryManager.API.dto.LibroResponseDTO;

import java.util.List;

public interface ILibroService {
    List<LibroResponseDTO> findAll();
    LibroResponseDTO findById(Long id);
    LibroResponseDTO save(LibroRequestDTO libroRequestDTO);
    LibroResponseDTO update(Long id, LibroRequestDTO libroRequestDTO);
    void delete(Long id);
}
