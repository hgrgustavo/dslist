package com.devsuperior.dslist.infrastructure.projections;

public interface GameMinProjection {
    Long getId();
    Integer getYear();
    String getTitle();
    String getImgUlr();
    String getShortDescription();
}