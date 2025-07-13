package com.example.kanban.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @OrderBy("orderOnBoard ASC")
    private List<Column> columns;

    // Getters and setters...
}