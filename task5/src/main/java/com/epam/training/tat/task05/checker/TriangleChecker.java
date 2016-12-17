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
     * Checks on regularity of the triangle
     * @return type
     */
    public String isRegular(Triangle john) {
        String type = "";
        if (john.getA() != john.getB() && john.getB() != john.getC()
                && john.getA() != john.getC()) {
            System.out.println("Regular");
        }
        return "Regular";
    }

    /**
     * Checks on isoscelivity of the triangle
     * @return type
     */
    public String isIsosceles(Triangle john) {
        if ((john.getA() == john.getB() && john.getA() != john.getC() && john.getB() != john.getC()) ||
                (john.getA() != john.getB() && john.getA() == john.getC() && john.getB() != john.getC()) ||
                (john.getA() != john.getB() && john.getA() != john.getC() && john.getB() == john.getC())) {
            System.out.println("Isosceles");
        }
        return "Isosceles";
    }

    /**
     * Checks on equilaterality of the triangle
     * @return type
     */
    public String isEquilateral(Triangle john) {
        if (john.getA() == john.getB() && john.getB() ==
                john.getC() && john.getA() == john.getC()) {
            System.out.println("Equilateral");
        }
        return "Equilateral";
    }
}
