package com.example.kanban.mapper;

import com.example.kanban.dto.*;
import com.example.kanban.entity.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class BoardViewMapper {

    public BoardViewDTO toDTO(Board board) {
        BoardViewDTO dto = new BoardViewDTO();
        dto.boardId = board.getId();
        dto.name = board.getName();

        dto.columns = board.getColumns().stream()
            .sorted(Comparator.comparing(Column::getOrderOnBoard))
            .map(this::toColumnDTO)
            .toList();

        return dto;
    }

    private ColumnDTO toColumnDTO(Column col) {
        ColumnDTO dto = new ColumnDTO();
        dto.columnStrId = col.getColumnStrId();
        dto.name = col.getName();
        dto.orderOnBoard = col.getOrderOnBoard();

        dto.tasks = col.getTasks().stream()
            .sorted(Comparator.comparing(Task::getOrderInColumn))
            .map(this::toTaskDTO)
            .toList();

        return dto;
    }

    private TaskDTO toTaskDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.taskStrId = task.getTaskStrId();
        dto.title = task.getTitle();
        dto.description = task.getDescription();
        dto.orderInColumn = task.getOrderInColumn();
        return dto;
    }
}