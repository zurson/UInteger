package org.example;

import org.example.Exceptions.UIntegerException;

/**
 * The Integer class wraps a value of the primitive type int in an object.
 * An object of type UInteger contains a single field whose type is uint.
 * In addition, this class provides several methods for uint management.
 */
public class UInteger extends Number implements Comparable<Integer> {


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
     * Constructs a newly allocated UInteger object that represents
     * the specified uint value base on given string.
     *
     * @param str the string to be represented by the UInteger object
     */
    public UInteger(String str) throws UIntegerException {
        this.value = parseUInt(str).getValue();
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
            int subtracted = Math.subtractExact(this.value, uInteger.getValue());

            if (subtracted < MIN_VALUE)
                throw new UIntegerException("Result of subtract is less than " + MIN_VALUE);

            return new UInteger(subtracted);

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

    /**
     * Returns integer value of class
     *
     * @return int value
     */
    @Override
    public int intValue() {
        return this.value;
    }

    /**
     * Returns long value of class
     *
     * @return long value
     */
    @Override
    public long longValue() {
        return this.value;
    }

    /**
     * Returns float value of class
     *
     * @return float value
     */
    @Override
    public float floatValue() {
        return (float) this.value;
    }

    /**
     * Returns double value of class
     *
     * @return double value
     */
    @Override
    public double doubleValue() {
        return (double) this.value;
    }

    /**
     * Returns value of class parsed as String
     *
     * @return value parsed as String
     */
    @Override
    public String toString() {
        return "" + this.value;
    }


    /**
     * Allows to compare UInteger with Integer value
     *
     * @param y the object to be compared.
     * @return -1 when class value < y, 1 otherwise and 0 when both values are equals
     */
    @Override
    public int compareTo(Integer y) {
        return (value < y) ? -1 : ((value == y) ? 0 : 1);
    }


    /**
     * Compares this object to the specified object. The result is
     * TRUE if and only if the argument is not
     * NULL and is an UInteger object that
     * contains the same uint value as this object.
     *
     * @param obj the object to compare with.
     * @return TRUE if the objects are the same, FALSE otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof UInteger) {
            return value == ((UInteger) obj).getValue();
        }
        return false;
    }


    // *********************************************    STATIC METHODS    *********************************************


    /**
     * Adds two UIntegers together as per the + operator.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the sum of a and b
     */
    public static UInteger sum(UInteger a, UInteger b) throws UIntegerException {
        return a.add(b);
    }


    /**
     * Returns the greater of two int values as if by calling Math.max.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the greatest of a and b
     */
    public static int max(UInteger a, UInteger b) {
        return Math.max(a.getValue(), b.getValue());
    }


    /**
     * Returns the smaller of two int values as if by calling Math.min.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the smallest of a and b
     */
    public static int min(UInteger a, UInteger b) {
        return Math.min(a.getValue(), b.getValue());
    }


    /**
     * Returns the value obtained by reversing the order of the bytes
     * in the two's complement representation of the specified UInteger value.
     *
     * @param value the value whose bytes are to be reversed
     * @return the value obtained by reversing the bytes in the specified int value.
     */
    @Deprecated
    public static int reverseBytes(UInteger value) {
        int i = value.getValue();
        return (i << 24) |
                ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) |
                (i >>> 24);
    }


    /**
     * Allows to create new UInteger class based on given string
     *
     * @param str the string with numbers
     * @return new UInteger class reference
     * @throws UIntegerException if non-numeric values found in given input or string input is less than 0
     */
    public static UInteger parseUInt(String str) throws UIntegerException {
        int val;

        try {
            val = Integer.parseInt(str);
        } catch (NumberFormatException ignored) {
            throw new UIntegerException("Non-numeric values found");
        }

        return new UInteger(val);
    }

}
