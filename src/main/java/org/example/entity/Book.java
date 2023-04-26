package org.example.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private long id;
    private String name;
    private String author;
    private Genre genre;
}