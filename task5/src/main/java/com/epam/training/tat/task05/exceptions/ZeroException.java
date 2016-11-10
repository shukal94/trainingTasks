package com.epam.training.tat.task05.exceptions;

/**
 * throws if one of side == 0
 *
 * @version 1.0
 * Created by shukal on 5.11.16.
 */
public class ZeroException extends Exception {
    public ZeroException() {
        super("one of side i zero");
    }
}
