package com.devsuperior.dslist.application.services;

import com.devsuperior.dslist.application.dto.GenreDTO;
import com.devsuperior.dslist.domain.repositories.GameRepository;
import com.devsuperior.dslist.infrastructure.persistence.Genre;
import com.devsuperior.dslist.domain.repositories.GenreRepository;
import com.devsuperior.dslist.infrastructure.projections.GameMinProjection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private GenreRepository genreRepository;
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> result = genreRepository.findAll();
        return result.stream().map(GenreDTO::new).toList();
    }

    @Transactional
    public void move(Long genreId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByGenre(genreId);
        GameMinProjection removedObject = list.remove(sourceIndex);
        list.add(destinationIndex, removedObject);
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);
        for (int i = min; i <= max; i++) {
            Long gameId = list.get(i).getId();
            genreRepository.updateBelongingPosition(genreId, gameId, i);
        }
    }
}