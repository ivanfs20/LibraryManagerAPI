package com.codefs.LibraryManager.API.mapper;

import com.codefs.LibraryManager.API.dto.AutorResponseDTO;
import com.codefs.LibraryManager.API.dto.LibroRequestDTO;
import com.codefs.LibraryManager.API.dto.LibroResponseDTO;
import com.codefs.LibraryManager.API.model.Autor;
import com.codefs.LibraryManager.API.model.Libro;

import java.util.List;

public class Mapper {

    public static AutorResponseDTO toDTO(Autor autor){
        if(autor==null) return null;

        var libros = (autor.getLibros() == null ? List.<Libro>of() : autor.getLibros())
                .stream()
                .map(l ->
                        LibroResponseDTO.builder()
                                .id(l.getId())
                                .title(l.getTitle())
                                .genre(l.getGenre())
                                .stock(l.getStock())
                                .autor(l.getAutor().getName())
                                .build()
                ).toList();

        return AutorResponseDTO.builder().
                id(autor.getId()).
                name(autor.getName()).
                nationality(autor.getNationality()).
                birthDate(autor.getBirthDate()).
                biography(autor.getBiography()).
                libroDTOS(libros).
                build();
    }

    public static LibroResponseDTO toDTO(Libro libro){
        if(libro==null) return null;

        String autor = libro.getAutor().getName();

        return LibroResponseDTO.builder().
                id(libro.getId()).
                title(libro.getTitle()).
                genre(libro.getGenre()).
                stock(libro.getStock()).
                autor(autor).
                build();
    }
}
