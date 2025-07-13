package com.example.kanban.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Column {
    @Id
    private String columnStrId;

    private String name;
    private int orderOnBoard;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    @OrderBy("orderInColumn ASC")
    private List<Task> tasks;

    // Getters and setters...
}