package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String listName = "TaskList";
    private static final String description = "This is a test";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(listName, description);
        taskListDao.save(taskList);
        String listNameTaken = taskList.getListName();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listNameTaken);

        //Then
        assertEquals(1, readTaskList.size());

        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }


}
