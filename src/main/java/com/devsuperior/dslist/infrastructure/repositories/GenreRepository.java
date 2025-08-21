package com.devsuperior.dslist.infrastructure.repositories;

import com.devsuperior.dslist.infrastructure.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
