package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testLogger() {
        //Given
        logger = Logger.INSTANCE;
        logger.log("Hello World");


        //When
        String log = logger.getLastLog();
        System.out.println("New log: " + log);

        //Then
        assertEquals("Hello World", log);
    }
}
