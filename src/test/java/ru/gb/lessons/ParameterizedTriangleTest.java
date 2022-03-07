package ru.gb.lessons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParameterizedTriangleTest {
    private final static String sideNotPositive = "Sides must be positive";
    private final static String sideGreaterOthersSum = "One side can't be greater than sum of others";

    public static Stream<Arguments> trianglesPerimeter() {
        return Stream.of(Arguments.of(new Triangle(3,4,5), 12),
                Arguments.of(new Triangle(3,4,6), 13),
                Arguments.of(new Triangle(3,3,3), 9));
    }

    @ParameterizedTest(name = "Периметр треугольника: позитивный сценарий, периметр треугольника {0} == {1}")
    @MethodSource("trianglesPerimeter")
    void countPerimeterPositiveTest(Triangle triangle, int expectedResult) {
        int perimeter = triangle.countPerimeter();
        assertEquals(expectedResult, perimeter);
    }

    public static Stream<Arguments> trianglesArea() {
        return Stream.of(Arguments.of(new Triangle(3,4,5), 6),
                Arguments.of(new Triangle(3,4,6), 5.3),
                Arguments.of(new Triangle(3,3,3), 3.9));
    }

    @ParameterizedTest(name = "Площадь треугольника: позитивный сценарий, площадь треугольника {0} == {1}")
    @MethodSource("trianglesArea")
    void countAreaPositiveTest(Triangle triangle, double expectedResult) {
        double area = triangle.countArea();
        assertEquals(expectedResult, area);
    }

    public static Stream<Arguments> negativeTriangles() {
        return Stream.of(Arguments.of(new Triangle(0, 3, 3), sideNotPositive),
                Arguments.of(new Triangle(3, 0, 3), sideNotPositive),
                Arguments.of(new Triangle(3, 3, 0), sideNotPositive),
                Arguments.of(new Triangle(3, 3, -1), sideNotPositive),
                Arguments.of(new Triangle(3, -1, 3), sideNotPositive),
                Arguments.of(new Triangle(-1, 3, 3), sideNotPositive),
                Arguments.of(new Triangle(6, 1, 1), sideGreaterOthersSum),
                Arguments.of(new Triangle(1, 2, 1), sideGreaterOthersSum)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника: негативный сценарий (треугольник {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countPerimeterNegativeTest(Triangle triangle, String errorText) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals(errorText, illegalArgumentException.getMessage());
    }

    @ParameterizedTest(name = "Площадь треугольника: негативный сценарий (треугольник {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countAreaNegativeTest(Triangle triangle, String errorText) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countArea);
        assertEquals(errorText, illegalArgumentException.getMessage());
    }
}
