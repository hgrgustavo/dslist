package com.devsuperior.dslist.application.services;

import com.devsuperior.dslist.infrastructure.dto.GenreDTO;
import com.devsuperior.dslist.infrastructure.entities.Genre;
import com.devsuperior.dslist.infrastructure.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class GenreService {
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> result = genreRepository.findAll();
        return result.stream().map(GenreDTO::new).toList();
    }
}
