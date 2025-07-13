package com.example.kanban.controller;

import com.example.kanban.dto.BoardViewDTO;
import com.example.kanban.entity.Board;
import com.example.kanban.mapper.BoardViewMapper;
import com.example.kanban.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardViewMapper boardViewMapper;

    @GetMapping("/{boardId}/view")
    public ResponseEntity<BoardViewDTO> getFullBoardView(@PathVariable Long boardId) {
        Board board = boardRepository.findByIdWithColumnsAndTasks(boardId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));

        BoardViewDTO dto = boardViewMapper.toDTO(board);
        return ResponseEntity.ok(dto);
    }
}