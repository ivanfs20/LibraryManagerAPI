package com.codefs.LibraryManager.API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AutorRequestDTO {
    private UUID id;
    @NotNull
    @NotBlank
    private String name;
    private String nationality;
    private LocalDate birthDate;
    private String biography;
}
