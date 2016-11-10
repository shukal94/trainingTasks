package com.epam.training.tat.task05;

import com.epam.training.tat.task05.content.Triangle;
import com.epam.training.tat.task05.checker.TriangleChecker;
import com.epam.training.tat.task05.exceptions.NotATriangleException;
import com.epam.training.tat.task05.exceptions.NotThreeSidesException;

/**
 * Contains an entry point to the application,
 * realizes the business logic)
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class Main {
    /**
     * An entry point to the application
     *
     * @param args - arguments from console
     * @throws NotATriangleException if a, b, c - composition is not triangle
     * @throws NotThreeSidesException if params from console is not 3
     */
    public static void main(String[] args) throws NotATriangleException, NotThreeSidesException {
        if (!checkForDouble(args)) {
            throw new NumberFormatException();
        }

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        if (!checkForRightArgsLength(args)) {
            throw new NotThreeSidesException();
        }

        Triangle jack = new Triangle(a, b, c);

        TriangleChecker checker = new TriangleChecker();

        checker.isIsosceles(jack);
        checker.isEquilateral(jack);
        checker.isRegular(jack);
    }

    /**
     * @param args - sides of the triangle
     * @return true if args is double
     * @throws NumberFormatException if return false
     */
    public static boolean checkForDouble(String[] args) throws NumberFormatException{
        boolean isDouble = true;
        try {
            if (args[0].matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+") ||
                    args[1].matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+") ||
                    args[2].matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                return isDouble;
            } else {
                isDouble = false;
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return isDouble;
    }

    /**
     * @param args - sides of the triangle
     * @return true if args length are equals 3
     */
    public static boolean checkForRightArgsLength(String[] args) {
        return args.length == 3;
    }

}
