package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import com.kodilla.exception.test.SecondChallengeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testSecondChallengeWithNumbers() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Them
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.1, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.1, 4)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 4))
                );
    }
}
