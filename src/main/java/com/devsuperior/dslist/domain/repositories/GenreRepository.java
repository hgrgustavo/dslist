package com.devsuperior.dslist.domain.repositories;

import com.devsuperior.dslist.infrastructure.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
