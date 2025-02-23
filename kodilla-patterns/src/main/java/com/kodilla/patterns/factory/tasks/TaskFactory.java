package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task createTask(final String taskName) {
        return switch (taskName) {
            case DRIVING -> new DrivingTask("Driving", "Center", "Taxi");
            case PAINTING -> new PaintingTask("Painting", "Blue", "Wall");
            case SHOPPING -> new ShoppingTask("Shopping", "Snacks", 2);
            default -> null;
        };
    }
}