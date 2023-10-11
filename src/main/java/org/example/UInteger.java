package org.example;

import org.example.Exceptions.UIntegerException;

/**
 * The Integer class wraps a value of the primitive type int in an object.
 * An object of type UInteger contains a single field whose type is uint.
 * In addition, this class provides several methods for uint management.
 */
public class UInteger {


    /**
     * The value of Integer.
     */
    private final int value;

    /**
     * A constant holding the minimum value an UInteger can have.
     */
    public static final int MIN_VALUE = 0x00000000;

    /**
     * A constant holding the maximum value an UInteger can have.
     */
    public static final int MAX_VALUE = 0x7fffffff;


    /**
     * Constructs a newly allocated UInteger object that represents the specified uint value.
     *
     * @param value the value to be represented by the UInteger object
     */
    public UInteger(int value) throws UIntegerException {

        if (value < MIN_VALUE)
            throw new UIntegerException("Provided value is less than " + MIN_VALUE);

        this.value = value;
    }

    /**
     * Returns uint value.
     *
     * @return value of uint represented by this class after all conversions
     */
    public int getValue() {
        return value;
    }


    /**
     * Adds given value and returns new UInteger class reference or throws
     * exception when the result overflows an int.
     *
     * @param uInteger value you want to add
     * @return reference to new UInteger class
     * @throws UIntegerException if the result overflows an int
     */
    public UInteger add(UInteger uInteger) throws UIntegerException {

        try {
            return new UInteger(Math.addExact(this.value, uInteger.getValue()));
        } catch (ArithmeticException ignored) {
            throw new UIntegerException("Value overflow");
        }

    }

    /**
     * Subtract given value and returns new UInteger class reference or throws
     * exception when the result is less than 0.
     *
     * @param uInteger value you want to subtract
     * @return reference to new UInteger class
     * @throws UIntegerException if the result is less than 0
     */
    public UInteger subtract(UInteger uInteger) throws UIntegerException {

        try {
            UInteger result = new UInteger(Math.subtractExact(this.value, uInteger.getValue()));
            if (result.getValue() < MIN_VALUE)
                throw new UIntegerException("Result of subtract is less than " + MIN_VALUE);

            return result;

        } catch (ArithmeticException ignored) {
            throw new UIntegerException("Value overflow");
        }

    }

    /**
     * Multiply original class by given value and returns new UInteger
     * class reference or throws exception when the result overflows an int.
     *
     * @param uInteger value you want to multiply original class
     * @return reference to new UInteger class
     * @throws UIntegerException if the result is less than 0
     */
    public UInteger multiply(UInteger uInteger) throws UIntegerException {

        try {
            return new UInteger(Math.multiplyExact(this.value, uInteger.getValue()));
        } catch (ArithmeticException ignored) {
            throw new UIntegerException("Value overflow");
        }

    }

    /**
     * Divides original class by given value and returns new UInteger
     * class reference or throws exception when the result overflows
     * an int or provided value is 0.
     * The fractional part is omitted.
     *
     *
     * @param uInteger value you want to divide original class
     * @return reference to new UInteger class
     * @throws UIntegerException if the result overflows an int or provided value is 0
     */
    public UInteger divide(UInteger uInteger) throws UIntegerException {

        try {
            return new UInteger(Math.divideExact(this.value, uInteger.getValue()));
        } catch (ArithmeticException e) {
            throw new UIntegerException(e.getMessage());
        }

    }
}
