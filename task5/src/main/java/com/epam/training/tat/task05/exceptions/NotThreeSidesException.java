package com.epam.training.tat.task05.exceptions;

/**
 * throws when args.length != 3
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class NotThreeSidesException extends Exception {
    public NotThreeSidesException() {
        super("Number parametres is wrong");
    }
}
