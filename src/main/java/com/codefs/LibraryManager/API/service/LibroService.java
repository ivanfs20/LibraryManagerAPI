package com.codefs.LibraryManager.API.service;

import com.codefs.LibraryManager.API.dto.LibroRequestDTO;
import com.codefs.LibraryManager.API.dto.LibroResponseDTO;
import com.codefs.LibraryManager.API.excepcion.NotFoundException;
import com.codefs.LibraryManager.API.mapper.Mapper;
import com.codefs.LibraryManager.API.model.Autor;
import com.codefs.LibraryManager.API.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codefs.LibraryManager.API.repository.AutorDAO;
import com.codefs.LibraryManager.API.repository.LibroDAO;

import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private LibroDAO libroDAO;
    @Autowired
    private AutorDAO autorDAO;

    @Override
    public List<LibroResponseDTO> findAll() {
        return libroDAO.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public LibroResponseDTO findById(Long id) {
        return Mapper.toDTO(libroDAO.findById(id).orElseThrow(() -> new NotFoundException("Libro no encontrado")));
    }

    @Override
    public LibroResponseDTO save(LibroRequestDTO libroRequestDTO) {
        Autor autor = autorDAO.findById(libroRequestDTO.getAutorDTO().getId()).orElseThrow(() -> new NotFoundException("Autor no encontrado"));

        Libro libro = Libro.builder().
                title(libroRequestDTO.getTitle()).
                genre(libroRequestDTO.getGenre()).
                stock(libroRequestDTO.getStock()).
                autor(autor).
                build();

        return Mapper.toDTO(libroDAO.save(libro));
    }

    @Override
    public LibroResponseDTO update(Long id, LibroRequestDTO libroRequestDTO) {

        Libro libro = libroDAO.findById(id).orElseThrow(() -> new NotFoundException("No se encontro el libro"));

        Autor autor = autorDAO.findById(libroRequestDTO.getAutorDTO().getId()).orElseThrow(() -> new NotFoundException("No se encontro el autor"));

        libro.setTitle(libroRequestDTO.getTitle());
        libro.setGenre(libroRequestDTO.getGenre());
        libro.setStock(libroRequestDTO.getStock());
        libro.setAutor(autor);
        return Mapper.toDTO(libroDAO.save(libro));
    }

    @Override
    public void delete(Long id) {

        Libro libro = libroDAO.findById(id).orElse(null);

        if(libro == null) throw  new NotFoundException("El libro no existe");

        libroDAO.deleteById(id);
    }
}
