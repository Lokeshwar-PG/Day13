package com.generics;

import java.util.Arrays;
import java.util.Optional;

public class MaximumTest<T extends Comparable<T>> {
    private T[] vars;

    public MaximumTest(T... vars) {
        this.vars = vars;
    }

    public void testMaximum() {
        Optional<T> max = testMaximum(vars);
        max.ifPresent(this::printMax);
    }

    private void printMax(T max) {
        System.out.println("Maximum value among the variables is: " + max);
    }

    public static <T extends Comparable<T>> Optional<T> testMaximum(T... vars) {
        if (vars.length == 0) {
            return Optional.empty();
        }

        Arrays.sort(vars);
        return Optional.of(vars[vars.length - 1]);
    }

    public static void main(String[] args) {
        Integer[] numberArray1 = {33, 12, 23};
        MaximumTest<Integer> integerMaximumTest1 = new MaximumTest<>(33, 12, 23, 7);
        integerMaximumTest1.testMaximum();
        MaximumTest<Integer> integerMaximumTest2 = new MaximumTest<>(23, 33, 12);
        integerMaximumTest2.testMaximum();
        MaximumTest<Integer> integerMaximumTest3 = new MaximumTest<>(23, 12, 33);
        integerMaximumTest3.testMaximum();
        MaximumTest<Float> floatMaximumTest1 = new MaximumTest<>(33.5f, 12.3f, 23.7f);
        floatMaximumTest1.testMaximum();
        MaximumTest<Float> floatMaximumTest2 = new MaximumTest<>(23.7f, 33.5f, 12.3f);
        floatMaximumTest2.testMaximum();
        MaximumTest<Float> floatMaximumTest3 = new MaximumTest<>(12.3f, 23.7f, 33.5f);
        floatMaximumTest3.testMaximum();
        MaximumTest<String> stringMaximumTest1 = new MaximumTest<>("Peach", "Apple", "Banana");
        stringMaximumTest1.testMaximum();
        MaximumTest<String> stringMaximumTest2 = new MaximumTest<>("Apple", "Peach", "Banana");
        stringMaximumTest2.testMaximum();
        MaximumTest<String> stringMaximumTest3 = new MaximumTest<>("Apple", "Banana", "Peach", "Strawberry");
        stringMaximumTest3.testMaximum();
    }
}
