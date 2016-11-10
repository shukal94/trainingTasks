package com.epam.training.tat.task05.checker;

import com.epam.training.tat.task05.content.Triangle;

/**
 * Perfoms the checkings of the triangle
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class TriangleChecker {
    /**
     * Checks on isoscelivity of the triangle
     * @return true if isosceles
     */
    public boolean isIsosceles(Triangle john) {
        return (john.getA() == john.getB() || john.getB() ==
                john.getC() || john.getA() == john.getC());
    }

    /**
     * Checks on equilaterality of the triangle
     * @return true if equilateral
     */
    public boolean isEquilateral(Triangle john) {
        return (john.getA() == john.getB() && john.getB() ==
                john.getC() && john.getA() == john.getC());
    }
}
