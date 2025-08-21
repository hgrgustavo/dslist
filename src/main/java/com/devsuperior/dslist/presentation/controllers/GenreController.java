package com.devsuperior.dslist.presentation.controllers;

import com.devsuperior.dslist.application.services.GameService;
import com.devsuperior.dslist.application.services.GenreService;
import com.devsuperior.dslist.infrastructure.dto.GameMinDTO;
import com.devsuperior.dslist.infrastructure.dto.GenreDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/genres")
@AllArgsConstructor
public class GenreController {
    private GenreService genreService;
    private GameService gameService;

    @GetMapping
    public List<GenreDTO> findAll() {
        return genreService.findAll();
    }

    @GetMapping(value = "/{genreId}/games")
    public List<GameMinDTO> findByGenre(@PathVariable Long genreId) {
        return gameService.findByGenre(genreId);
    }
}
