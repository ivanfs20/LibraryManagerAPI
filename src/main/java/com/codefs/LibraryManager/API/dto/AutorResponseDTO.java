package com.codefs.LibraryManager.API.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AutorResponseDTO {
    private UUID id;
    private String name;
    private String nationality;
    private LocalDate birthDate;
    private String biography;
    private List<LibroResponseDTO> libroDTOS = new ArrayList<>();
}
