package com.codefs.LibraryManager.API.repository;

import com.codefs.LibraryManager.API.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorDAO extends JpaRepository<Autor, UUID> {
}
