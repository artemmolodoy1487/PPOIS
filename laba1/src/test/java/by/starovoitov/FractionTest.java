package by.starovoitov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction1;
    private Fraction fraction2;

    @BeforeEach
    public void setUp() {
        fraction1 = new Fraction(Sign.PLUS, 3, 4); // 3/4
        fraction2 = new Fraction(Sign.MINUS, 1, 2); // -1/2
    }

    @Test
    public void testConstructorWithValidInput() {
        Fraction fraction = new Fraction(Sign.PLUS, 5, 10);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    public void testConstructorWithInvalidNumerator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Fraction(Sign.PLUS, 0, 5);
        });
        assertEquals("Numerator must be a natural number (> 0)", exception.getMessage());
    }

    @Test
    public void testConstructorWithInvalidDenominator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Fraction(Sign.PLUS, 5, 0);
        });
        assertEquals("Denominator must be a natural number (> 0)", exception.getMessage());
    }

    @Test
    public void testAdd() {
        Fraction result = fraction1.add(fraction2);
        assertEquals(1, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('+', result.getSign());
    }

    @Test
    public void testSubtract() {
        Fraction result = fraction1.subtract(fraction2);
        assertEquals(5, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('+', result.getSign());
    }

    @Test
    public void testMultiply() {
        Fraction result = fraction1.multiply(fraction2);
        assertEquals(3, result.getNumerator());
        assertEquals(8, result.getDenominator());
        assertEquals('-', result.getSign());
    }

    @Test
    public void testDivide() {
        Fraction result = fraction1.divide(fraction2);
        assertEquals(3, result.getNumerator());
        assertEquals(2, result.getDenominator());
        assertEquals('-', result.getSign());
    }

    @Test
    public void testIncrement() {
        Fraction result = fraction1.increment();
        assertEquals(7, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('+', result.getSign());
    }

    @Test
    public void testPostIncrement() {
        Fraction result = fraction1.postIncrement();
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('+', result.getSign());
        fraction1.increment();
        assertEquals(3, fraction1.getNumerator());
    }

    @Test
    public void testDecrement() {
        Fraction result = fraction1.decrement();
        assertEquals(1, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('-', result.getSign());
    }

    @Test
    public void testPostDecrement() {
        Fraction result = fraction1.postDecrement();
        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());
        assertEquals('+', result.getSign());
        fraction1.decrement();
        assertEquals(3, fraction1.getNumerator());
    }

    @Test
    public void testCompareTo() {
        assertTrue(fraction1.compareTo(fraction2) > 0);
        assertTrue(fraction2.compareTo(fraction1) < 0);
        assertEquals(0, fraction1.compareTo(new Fraction(Sign.PLUS, 3, 4)));
    }

    @Test
    public void testGetDoubleValue() {
        assertEquals(0.75, fraction1.getDoubleValue(), 0.001);
        assertEquals(-0.5, fraction2.getDoubleValue(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("+ 3/4", fraction1.toString());
        assertEquals("- 1/2", fraction2.toString());
    }
}
