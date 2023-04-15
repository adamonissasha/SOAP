package org.example.entity;

import lombok.Getter;

@Getter
public enum Genre {
    NOVEL("Роман"),
    DETECTIVE("Детектив"),
    THRILLER("Триллер"),
    ADVENTURE("Приключение");

    private final String prefix;
    Genre(String prefix) {
        this.prefix = prefix;
    }
}
