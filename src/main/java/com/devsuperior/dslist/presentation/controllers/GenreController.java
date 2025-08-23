package com.devsuperior.dslist.presentation.controllers;

import com.devsuperior.dslist.application.services.GameService;
import com.devsuperior.dslist.application.services.GenreService;
import com.devsuperior.dslist.application.dto.GameMinDTO;
import com.devsuperior.dslist.application.dto.GenreDTO;
import com.devsuperior.dslist.presentation.dto.ReplacementDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{genreId}/replacement")
    public void move(@PathVariable Long genreId, @RequestBody ReplacementDTO body) {
        genreService.move(genreId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
