package org.example;

import org.example.Exceptions.UIntegerException;

public class Main {

    public static void main(String[] args) {
        UInteger result;

        Integer integer;

        try {
            UInteger x = new UInteger("5");
            UInteger y = new UInteger("6");

            int xd = UInteger.reverseBytes(x);
            System.out.println("xd: " + xd);

        } catch (UIntegerException e) {
            System.out.println(e.getMessage());
            return;
        }

//        System.out.println("\nResult: " + result.getValue());

    }

}