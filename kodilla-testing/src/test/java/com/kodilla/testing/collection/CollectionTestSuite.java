package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    OddNumbersExterminator exterminator = new OddNumbersExterminator();

    @DisplayName("when OddNumbersExterminator is given an empty list, " +
            "then it should return an empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> emptyList = Arrays.asList();

        //When
        List<Integer> evenNumbers = exterminator.exterminate(emptyList);

        //Then
        Assertions.assertTrue(evenNumbers.isEmpty());
    }

    @DisplayName("when OddNumbersExterminator is given a list with even and odd numbers, " +
            "then it should return a list containing only even numbers")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedEvenNumbers = Arrays.asList(2, 4, 6, 8, 10);

        //When
        List<Integer> evenNumbers = exterminator.exterminate(numberList);

        //Then
        Assertions.assertEquals(expectedEvenNumbers, evenNumbers);
    }
}
