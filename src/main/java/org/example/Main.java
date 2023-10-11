package org.example;

import org.example.Exceptions.UIntegerException;

public class Main {

    public static void main(String[] args) {
        UInteger result;

        Integer integer;

        try {
            UInteger x = new UInteger(0);
            UInteger y = new UInteger(20);

            result = x.divide(y);

        } catch (UIntegerException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nResult: " + result.getValue());

    }

}