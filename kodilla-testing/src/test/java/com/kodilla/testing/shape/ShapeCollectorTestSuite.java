package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test shape - adding, getting and removing")
    class testAddAndRemoveFigure {

        @Test
        @DisplayName("Test adding a figure to the collection")
        void testAddFigure() {
            //Given
            ShapeCollector sc = new ShapeCollector();
            Shape circle = new Circle();
            Shape square = new Square();
            Shape triangle = new Triangle();
            // When
            sc.addFigure(circle);
            sc.addFigure(square);
            sc.addFigure(triangle);
            // Then
            Assertions.assertEquals(circle, sc.getFigure(0));
            Assertions.assertEquals(square, sc.getFigure(1));
            Assertions.assertEquals(triangle, sc.getFigure(2));
            Assertions.assertEquals(2, sc.getShapes().size()-1);
        }

        @Test
        @DisplayName("Test getting a figure from the collection")
        void testGetFigure() {
            //Given
            ShapeCollector sc = new ShapeCollector();
            Shape circle = new Circle();
            sc.addFigure(circle);
            //When
            sc.getFigure(sc.getShapes().size()-1);
            //Then
            Assertions.assertEquals(circle, sc.getFigure(sc.getShapes().size()-1));

        }

        @Test
        @DisplayName("Test removing a figure from the collection")
        void testRemoveFigure() {
            //Given
            ShapeCollector sc = new ShapeCollector();
            Shape circle = new Circle();
            sc.addFigure(circle);
            //When
            sc.removeFigure(circle);
            //Then
            Assertions.assertFalse(sc.getShapes().contains(circle));
        }

    }

    @Nested
    @DisplayName("Test showing figures in String")
    class testShowFiguresString {
        @Test
        @DisplayName("Test to show figures in String")
        void testShowFigures() {
            //Given
            ShapeCollector sc = new ShapeCollector();
            Shape circle = new Circle();
            Shape square = new Square();
            Shape triangle = new Triangle();
            sc.addFigure(circle);
            sc.addFigure(square);
            sc.addFigure(triangle);
            //When
            sc.showFigures();
            //Then
            Assertions.assertEquals("Circle, Square, Triangle.", sc.showFigures());
        }
    }
}