package com.example.kanban.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    private String taskStrId;

    private String title;
    private String description;
    private int orderInColumn;

    @ManyToOne
    @JoinColumn(name = "column_str_id")
    private Column column;

    // Getters and setters...
}