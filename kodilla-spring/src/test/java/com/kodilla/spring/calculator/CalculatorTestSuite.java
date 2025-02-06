package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {

        double resultAdd = calculator.add(1, 2);
        assertEquals(3.0, resultAdd);

        double resultSub = calculator.sub(3, 2);
        assertEquals(1.0, resultSub);

        double resultMul = calculator.mul(3, 2);
        assertEquals(6.0, resultMul);

        double resultDiv = calculator.div(3, 2);
        assertEquals(1.5, resultDiv);

        assertThrows(IllegalArgumentException.class, () -> calculator.div(3, 0));
    }
}
