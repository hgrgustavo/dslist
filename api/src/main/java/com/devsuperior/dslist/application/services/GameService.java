package com.devsuperior.dslist.application.services;

import com.devsuperior.dslist.application.dto.GameDTO;
import com.devsuperior.dslist.infrastructure.persistence.Game;
import com.devsuperior.dslist.application.dto.GameMinDTO;
import com.devsuperior.dslist.infrastructure.projections.GameMinProjection;
import com.devsuperior.dslist.domain.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGenre(Long genreId) {
        List<GameMinProjection> result = gameRepository.searchByGenre(genreId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}