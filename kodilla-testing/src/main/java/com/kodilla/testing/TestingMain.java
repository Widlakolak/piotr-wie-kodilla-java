package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int addResult = calculator.add(5, 3);
        if (addResult == 8) {
            System.out.println("Test dodawania: OK");
        } else {
            System.out.println("Test dodawania: BŁĄD");
        }

        int subtractResult = calculator.subtract(10, 4);
        if (subtractResult == 6) {
            System.out.println("Test odejmowania: OK");
        } else {
            System.out.println("Test odejmowania: BŁĄD");
        }

    }
}