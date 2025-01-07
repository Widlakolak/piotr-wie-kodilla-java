package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleSecondChallenge(double x, double y) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println("Result= " + result);
        } catch (Exception e) {
            System.out.println("Exception= " + e);
            throw new RuntimeException(e);
        } finally {
            System.out.println("x=" + x + " and y=" + y);
        }

    }
}
