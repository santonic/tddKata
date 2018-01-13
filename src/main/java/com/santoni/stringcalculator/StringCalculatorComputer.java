package com.santoni.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorComputer {
    int computeSum(List<Integer> numbers) {
        checkNoNegativeNumbers(numbers);

        return numbers.stream()
                .filter(n -> n.intValue()<=1000 )
                .mapToInt(i -> i.intValue())
                .sum();
    }

    private static void checkNoNegativeNumbers(List<Integer> numbers) {
        String negativeNumbers = numbers.stream()
                .filter(n -> n.intValue() < 0)
                .map(Object::toString)
                .collect(Collectors.joining(" and "));
        if(! negativeNumbers.isEmpty()) throw new IllegalArgumentException("Negative arguments: "+negativeNumbers);
    }
}
