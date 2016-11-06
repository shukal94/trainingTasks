package com.epam.training.tat.task05.exceptions;

/**
 * throws when (a + b) >= c, (b + c >= a, (a + c) >= b)
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class NotATriangleException extends Exception {
    public NotATriangleException() {
        super("That's not a triangle");
    }
}
