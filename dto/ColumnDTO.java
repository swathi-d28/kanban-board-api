package com.example.kanban.dto;

import java.util.List;

public class ColumnDTO {
    public String columnStrId;
    public String name;
    public int orderOnBoard;
    public List<TaskDTO> tasks;
}