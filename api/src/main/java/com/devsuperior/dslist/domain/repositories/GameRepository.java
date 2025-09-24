package com.devsuperior.dslist.domain.repositories;


import com.devsuperior.dslist.infrastructure.persistence.Game;
import com.devsuperior.dslist.infrastructure.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true,
            value = """
                     SELECT
                         game.id,
                         game.title,
                         game.release_year,
                         game.image_url,
                         game.short_description,
                         belonging.position
                     FROM game
                     INNER JOIN belonging
                     ON game.id = belonging.game_id
                     WHERE belonging.genre_id = :genreId
                     ORDER BY belonging.position
                    \s""")
    List<GameMinProjection> searchByGenre(Long genreId);
}