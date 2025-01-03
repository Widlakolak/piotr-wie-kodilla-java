package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {


        //Given
        int[] numbers = new int[] {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

        //When
        double average = ArrayOperations.getAverage(numbers);
        double expected = 14.5;


        //Then
        assertEquals(expected, average, 0.1);

    }
}
