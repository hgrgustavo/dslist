package com.devsuperior.dslist.application.dto;

import com.devsuperior.dslist.infrastructure.persistence.Game;
import com.devsuperior.dslist.infrastructure.projections.GameMinProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Getter
@NoArgsConstructor
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imageUrl;
    private String shortDescription;

    public GameMinDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public GameMinDTO(GameMinProjection projection) {
        BeanUtils.copyProperties(projection, this);
    }
}