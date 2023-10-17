package org.example;

import org.example.Exceptions.UIntegerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*

assertDoesNotThrow( () -> {

        });


assertThrows(UIntegerException.class, () -> {

});



*/


class UIntegerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getValue() throws UIntegerException {
        UInteger x1 = new UInteger(1);
        UInteger x2 = new UInteger("12321");
        UInteger x3 = new UInteger("0");
        UInteger x4 = new UInteger(0);

        assertEquals(1, x1.getValue());
        assertEquals(12321, x2.getValue());
        assertEquals(0, x3.getValue());
        assertEquals(0, x4.getValue());

    }

    @Test
    void add() throws UIntegerException {

        UInteger x1 = new UInteger(1);
        UInteger x2 = new UInteger("5");

        x1 = x1.add(x2);
        assertEquals(6, x1.getValue());

    }

    @Test
    void subtract() {

        assertDoesNotThrow(() -> {

            UInteger x1 = new UInteger(5);
            UInteger x2 = new UInteger("3");

            x1 = x1.subtract(x2);
            assertEquals(2, x1.getValue());

        });

        assertThrows(UIntegerException.class, () -> {

            UInteger x1 = new UInteger(5);
            UInteger x2 = new UInteger("3");

            x2.subtract(x1);

        });

    }

    @Test
    void multiply() {


        assertDoesNotThrow(() -> {

            UInteger x1 = new UInteger(5);
            UInteger x2 = new UInteger("3");

            x1 = x1.multiply(x2);
            assertEquals(15, x1.getValue());

        });


        assertThrows(UIntegerException.class, () -> {

            UInteger x3 = new UInteger(5);
            UInteger x4 = new UInteger("2147483641");

            x3.multiply(x4);
        });

    }

    @Test
    void divide() {

        assertDoesNotThrow(() -> {

            UInteger x1 = new UInteger(5);
            UInteger x2 = new UInteger("3");

            x1 = x1.divide(x2);
            assertEquals(1, x1.getValue());

        });

        assertThrows(UIntegerException.class, () -> {

            UInteger x1 = new UInteger(5);
            UInteger x2 = new UInteger("0");

            x1.divide(x2);
        });


    }

    @Test
    void intValue() {

        assertDoesNotThrow(() -> {

            UInteger x = new UInteger(123);
            int test = x.intValue();

        });

    }

    @Test
    void longValue() {

        assertDoesNotThrow(() -> {

            UInteger x = new UInteger(123);
            long test = x.longValue();

        });

    }

    @Test
    void floatValue() {

        assertDoesNotThrow(() -> {

            UInteger x = new UInteger(123);
            float test = x.floatValue();

        });

    }

    @Test
    void doubleValue() {

        assertDoesNotThrow(() -> {

            UInteger x = new UInteger(123);
            double test = x.floatValue();

        });

    }

    @Test
    void testToString() {

        assertDoesNotThrow(() -> {

            UInteger x = new UInteger(123);
            assertEquals(x.toString(), "123");

        });

    }

    @Test
    void compareTo() {

        assertDoesNotThrow(() -> {

            UInteger a = new UInteger(10);
            UInteger b = new UInteger(20);
            UInteger c = new UInteger(10);

            Integer test_a = a.getValue();
            Integer test_b = b.getValue();

            assertEquals(-1, a.compareTo(test_b));
            assertEquals(1, b.compareTo(test_a));
            assertEquals(0, c.compareTo(test_a));

        });

    }

    @Test
    void testEquals() {

        assertDoesNotThrow(() -> {

            UInteger a = new UInteger(10);
            UInteger b = new UInteger(20);
            UInteger c = new UInteger(10);

            assertTrue(a.equals(c));
            assertFalse(a.equals(b));

        });

    }

    @Test
    void sum() {

        assertDoesNotThrow(() -> {
            UInteger res = UInteger.sum(new UInteger(10), new UInteger("20"));
            assertEquals(30, res.getValue());
        });

    }

    @Test
    void max() {

        assertDoesNotThrow(() -> {
            assertEquals(30, UInteger.max(new UInteger(10), new UInteger("30")));
        });

    }

    @Test
    void min() {

        assertDoesNotThrow(() -> {
            assertEquals(10, UInteger.min(new UInteger(10), new UInteger("30")));
        });


    }

    @Test
    void parseUInt() {

        assertDoesNotThrow(() -> {

            assertEquals(123, UInteger.parseUInt("123").getValue());
            assertEquals(0, UInteger.parseUInt("0").getValue());
            assertEquals(218392180, UInteger.parseUInt("218392180").getValue());

        });

        assertThrows(UIntegerException.class, () -> {

            UInteger.parseUInt("-1");
            UInteger.parseUInt("123212sd123");
            UInteger.parseUInt("0123212d123");
            UInteger.parseUInt("8239213898309983019");

        });

    }
}