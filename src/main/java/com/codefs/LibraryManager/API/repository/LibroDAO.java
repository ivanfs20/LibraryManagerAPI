package com.codefs.LibraryManager.API.repository;

import com.codefs.LibraryManager.API.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroDAO extends JpaRepository<Libro, Long> {
}
