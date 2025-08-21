package com.devsuperior.dslist.infrastructure.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "belonging")
public class Belonging {
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {}
    public Belonging(Game game, Genre genre, Integer position) {
        id.setGame(game);
        id.setGenre(genre);
        this.position = position;
    }
}