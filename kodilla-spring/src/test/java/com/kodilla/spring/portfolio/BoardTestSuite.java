package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        String toDoTask = "task to do";
        String inProgressTask = "task in progress";
        String doneTask = "task done";

        //When
        board.getToDoList().getTasks().add(toDoTask);
        board.getInProgressList().getTasks().add(inProgressTask);
        board.getDoneList().getTasks().add(doneTask);

        //Then
        assertTrue(board.getToDoList().getTasks().contains(toDoTask));
        assertTrue(board.getInProgressList().getTasks().contains(inProgressTask));
        assertTrue(board.getDoneList().getTasks().contains(doneTask));

        System.out.println("To Do: " + board.getToDoList().getTasks());
        System.out.println("In Progress: " + board.getInProgressList().getTasks());
        System.out.println("Done: " + board.getDoneList().getTasks());
    }
}
