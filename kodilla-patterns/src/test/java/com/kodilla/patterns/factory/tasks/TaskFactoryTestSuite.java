package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testCreateShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.SHOPPING);

        // Then
        assertNotNull(task);
        assertTrue(task instanceof ShoppingTask);
        assertEquals("Shopping", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        // Execute task
        task.executeTask();
        assertTrue(task.isTaskExecuted());

        // Check additional parameters
        ShoppingTask shoppingTask = (ShoppingTask) task;
        assertEquals("Snacks", shoppingTask.getWhatToBuy());
        assertEquals(2.0, shoppingTask.getQuantity(), 0.01);
    }

    @Test
    void testCreatePaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.PAINTING);

        // Then
        assertNotNull(task);
        assertTrue(task instanceof PaintingTask);
        assertEquals("Painting", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        // Execute task
        task.executeTask();
        assertTrue(task.isTaskExecuted());

        // Check additional parameters
        PaintingTask paintingTask = (PaintingTask) task;
        assertEquals("Blue", paintingTask.getColor());
        assertEquals("Wall", paintingTask.getWhatToPaint());
    }

    @Test
    void testCreateDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.DRIVING);

        // Then
        assertNotNull(task);
        assertTrue(task instanceof DrivingTask);
        assertEquals("Driving", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        // Execute task
        task.executeTask();
        assertTrue(task.isTaskExecuted());

        // Check additional parameters
        DrivingTask drivingTask = (DrivingTask) task;
        assertEquals("Center", drivingTask.getWhere());
        assertEquals("Taxi", drivingTask.getUsing());
    }

    @Test
    void testCreateUnknownTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask("UNKNOWN");

        // Then
        assertNull(task);
    }
}