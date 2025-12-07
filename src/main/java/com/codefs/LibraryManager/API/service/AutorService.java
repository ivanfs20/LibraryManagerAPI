package com.codefs.LibraryManager.API.service;

import com.codefs.LibraryManager.API.dto.AutorRequestDTO;
import com.codefs.LibraryManager.API.dto.AutorResponseDTO;
import com.codefs.LibraryManager.API.excepcion.NotFoundException;
import com.codefs.LibraryManager.API.mapper.Mapper;
import com.codefs.LibraryManager.API.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codefs.LibraryManager.API.repository.AutorDAO;
import com.codefs.LibraryManager.API.repository.LibroDAO;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService implements IAutorService{

    @Autowired
    private AutorDAO autorDAO;
    @Autowired
    private LibroDAO libroDAO;

    @Override
    public List<AutorResponseDTO> findAll() {
        return autorDAO.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public AutorResponseDTO findById(UUID id) {
        return Mapper.toDTO(autorDAO.findById(id).orElseThrow(()->{return new NotFoundException("No se encontro el autor");}));
    }

    @Override
    public AutorResponseDTO save(AutorRequestDTO autorRequestDTO) {
        Autor autor = Autor.builder().
                name(autorRequestDTO.getName()).
                nationality(autorRequestDTO.getNationality()).
                birthDate(autorRequestDTO.getBirthDate()).
                biography(autorRequestDTO.getBiography()).
                build();
        return Mapper.toDTO(autorDAO.save(autor));
    }

    @Override
    public AutorResponseDTO update(UUID id, AutorRequestDTO autorRequestDTO) {

        Autor autor = autorDAO.findById(autorRequestDTO.getId()).orElseThrow(() -> {return new NotFoundException("El autor no existe");});

        autor.setName(autorRequestDTO.getName());
        autor.setNationality(autorRequestDTO.getNationality());
        autor.setBiography(autorRequestDTO.getBiography());
        autor.setBirthDate(autorRequestDTO.getBirthDate());


        return Mapper.toDTO(autorDAO.save(autor));
    }

    @Override
    public void delete(UUID id) {
        Autor autor = autorDAO.findById(id).orElse(null);

        if(autor == null){
            throw new NotFoundException("El autor no existe");
        }

        autorDAO.deleteById(id);
    }
}
