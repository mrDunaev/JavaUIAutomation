package ru.gb.lessons.lesson4;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.decimal4j.util.DoubleRounder;

@Data
@AllArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;

    private void checkSidesArePositive() {
        if (a <= 0 | b <= 0 | c <= 0)
            throw new IllegalArgumentException("Sides must be positive");
    }

    private void checkOneSideIsSmallerThenSumOfOthers() {
        if (a + b <= c | a + c <= b | c + b <= a)
            throw new IllegalArgumentException("One side can't be greater than sum of others");
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkOneSideIsSmallerThenSumOfOthers();
        return a + b + c;
    }

    public double countArea() {
        double p;
        checkSidesArePositive();
        checkOneSideIsSmallerThenSumOfOthers();
        p = 0.5 * countPerimeter();
        return DoubleRounder.round(Math.sqrt(p*(p-a)*(p-b)*(p-c)),1);
    }
}
