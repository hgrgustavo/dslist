package com.devsuperior.dslist.infrastructure.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getReleaseYear();
    String getImageUrl();
    String getShortDescription();
}