package com.santoni.fizzbuzz;

public class FizzBuzzNumberPrinter {
    public String print(int i) {
        StringBuilder result = new StringBuilder();
        if (i % 3 == 0) {
            result.append("Fizz");
        }
        if (i % 5 == 0) {
            result.append("Buzz");
        }
        if (result.length() != 0) {
            return result.toString();
        } else {
            return String.valueOf(i);
        }
    }
}
