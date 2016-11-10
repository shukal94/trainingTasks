package com.epam.training.tat.task05.checker;

import com.epam.training.tat.task05.content.Triangle;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Checks the comparing operations
 *
 * @version
 * Created by shukal on 6.11.16.
 */
public class TriangleCheckerTest {
    private Triangle triangle;
    private TriangleChecker checker = new TriangleChecker();

    @Test
    public void testIsIsosceles() {
        triangle = new Triangle(2, 2, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesDoublePoint() {
        triangle = new Triangle(2, 2.000000000001, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithMaxValues() {
        triangle = new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE - 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithNaNs() {
        double c = 1.0/0;
        triangle = new Triangle(2, 2, c);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithMinValues() {
        triangle = new Triangle(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE - 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsoscelesWithPosInfinity() {
        triangle = new Triangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE - 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsoscelesWithNegInfinity() {
        triangle = new Triangle(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE - 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithMathConst() {
        triangle = new Triangle(Math.PI, Math.PI, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithNaturalFraction() {
        triangle = new Triangle(6/3, 6/3, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithNaturalPeriodicFraction() {
        triangle = new Triangle(10/3, 10/3, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithZero() {
        triangle = new Triangle(0, 3, 3);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithZeros() {
        triangle = new Triangle(0, 0, 0);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsIsoscelesWithNegValues() {
        triangle = new Triangle(-2, -2, 1);
        assertTrue(checker.isIsosceles(triangle));
    }

    @Test
    public void testIsEquilateral() throws Exception {
        triangle = new Triangle(2, 2, 2);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralDoublePoint() {
        triangle = new Triangle(2, 2.000000000001, 2);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithMaxValues() {
        triangle = new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithMinValues() {
        triangle = new Triangle(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithNaNs() {
        double c = 1.0/0;
        triangle = new Triangle(2, 2, c);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testEquilateralWithPosInfinity() {
        triangle = new Triangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
                Double.POSITIVE_INFINITY);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testEquilateralWithNegInfinity() {
        triangle = new Triangle(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.NEGATIVE_INFINITY);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithMathConst() {
        triangle = new Triangle(Math.PI, Math.PI, 22/7);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithNaturalFraction() {
        triangle = new Triangle(6/3, 6/3, 6/3);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithNaturalPeriodicFraction() {
        triangle = new Triangle(10/3, 10/3, 10/3);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithZeros() {
        triangle = new Triangle(0, 0, 0);
        assertTrue(checker.isEquilateral(triangle));
    }

    @Test
    public void testIsEquilateralWithNegValues() {
        triangle = new Triangle(-2, -2, -2);
        assertTrue(checker.isEquilateral(triangle));
    }
}