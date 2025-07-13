package com.example.kanban.repository;

import com.example.kanban.entity.Board;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("""
        SELECT DISTINCT b FROM Board b
        LEFT JOIN FETCH b.columns c
        LEFT JOIN FETCH c.tasks
        WHERE b.id = :boardId
    """)
    Optional<Board> findByIdWithColumnsAndTasks(@Param("boardId") Long boardId);
}