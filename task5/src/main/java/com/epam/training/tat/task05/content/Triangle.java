package com.epam.training.tat.task05.content;

import com.epam.training.tat.task05.exceptions.NotATriangleException;

/**
 * Stores info about triangle
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class Triangle {
    /** Fields, contains the length of the sides */
    private double a;
    private double b;
    private double c;

    /**
     * Creates a triangle
     *
     * @param a - side of the triangle
     * @param b - side of the triangle
     * @param c - side of the triangle
     * @throws NumberFormatException - if format of input data is wrong
     */
    public Triangle(double a, double b, double c) throws NumberFormatException {
        try {
            this.a = Math.abs(a);
            this.a = Math.abs(b);
            this.a = Math.abs(c);
        } catch (NumberFormatException ex) {
            System.out.print("format of input data is wrong");
            ex.printStackTrace();
        }
    }

    /**
     * @return a - side of the triangle
     */
    public double getA() {
        return a;
    }

    /**
     * @return b - side of the triangle
     */
    public double getB() {
        return b;
    }

    /**
     * @return b - side of the triangle
     */
    public double getC() {
        return c;
    }
}
