package com.kodilla.good.patterns.challenges;

public class Factorial {

    public static long factorial(int n) {

        if (n < 0) throw new IllegalArgumentException();
        else if (n > 0) {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
        return 1;
    }
}
