package com.devsuperior.dslist.application.dto;

import com.devsuperior.dslist.infrastructure.persistence.Genre;
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
