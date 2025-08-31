package com.devsuperior.dslist.application.dto;

import com.devsuperior.dslist.infrastructure.persistence.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Getter
public class GenreDTO {
    private final Long id;
    private final String name;

    public GenreDTO(Genre entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
