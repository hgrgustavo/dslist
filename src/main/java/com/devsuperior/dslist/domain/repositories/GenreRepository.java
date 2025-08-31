package com.devsuperior.dslist.domain.repositories;

import com.devsuperior.dslist.infrastructure.persistence.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Modifying
    @Query(
            nativeQuery = true,
            value = "UPDATE belonging SET position = :newPosition WHERE genre_id = :genreId AND game_id = :gameId"
    )
    void updateBelongingPosition(Long genreId, Long gameId, Integer newPosition);
}
