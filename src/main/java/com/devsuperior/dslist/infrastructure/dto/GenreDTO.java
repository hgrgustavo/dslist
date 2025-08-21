package com.devsuperior.dslist.infrastructure.dto;

import com.devsuperior.dslist.infrastructure.entities.Genre;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String name;

    public GenreDTO(Genre entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
