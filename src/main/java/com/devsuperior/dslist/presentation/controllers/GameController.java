package com.devsuperior.dslist.presentation.controllers;

import com.devsuperior.dslist.application.services.GameService;
import com.devsuperior.dslist.infrastructure.dto.GameDTO;
import com.devsuperior.dslist.infrastructure.dto.GameMinDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/games")
public class GameController {
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }
}
