package com.devsuperior.dslist.application.dto;

import com.devsuperior.dslist.infrastructure.persistence.Game;
import com.devsuperior.dslist.infrastructure.projections.GameMinProjection;
import lombok.Getter;

@Getter
public class GameMinDTO {
    private final Long id;
    private final String title;
    private final Integer year;
    private final String imageUrl;
    private final String shortDescription;

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imageUrl = entity.getImageUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getReleaseYear();
        this.imageUrl = projection.getImageUrl();
        this.shortDescription = projection.getShortDescription();
    }
}