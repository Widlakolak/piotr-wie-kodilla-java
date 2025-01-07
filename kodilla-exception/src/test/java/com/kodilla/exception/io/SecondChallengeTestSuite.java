package com.kodilla.exception.io;

import com.kodilla.exception.test.ExceptionHandling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testSecondChallengeWithNumbers() {
        //Given
        ExceptionHandling ex = new ExceptionHandling();

        //When & Them
        assertAll(
                () -> assertThrows(Exception.class, () -> ex.handleSecondChallenge(2.1, 1.5)),
                () -> assertThrows(Exception.class, () -> ex.handleSecondChallenge(2.1, 4)),
                () -> assertThrows(Exception.class, () -> ex.handleSecondChallenge(1.5, 1.5)),
                () -> assertDoesNotThrow(() -> ex.handleSecondChallenge(1.5, 4))
                );
    }
}
