package by.starovoitov;

public class Fraction {
    private Sign sign;        // Знак дроби
    private int numerator;    // Числитель (должен быть натуральным)
    private int denominator;  // Знаменатель (должен быть натуральным)

    public Fraction(Sign sign, int numerator, int denominator) {
        if (numerator <= 0) {
            throw new IllegalArgumentException("Numerator must be a natural number (> 0)");
        }
        if (denominator <= 0) {
            throw new IllegalArgumentException("Denominator must be a natural number (> 0)");
        }

        this.sign = sign;
        this.numerator = numerator;
        this.denominator = denominator;

        simplify(); // Упрощаем дробь
    }

    // Метод для упрощения дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        // Убедитесь, что знак дроби всегда положительный для упрощения
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    // Метод для вычисления НОД
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getSignValue() {
        return this.sign.getValue();
    }

    public char getSign() {
        return this.sign.getSymbol();
    }

    // Сложение двух дробей
    public Fraction add(Fraction other) {
        int result_numerator = this.sign.getValue()*this.numerator * other.getDenominator() + other.getSignValue() * other.getNumerator() * this.denominator;
        int result_denominator = this.denominator * other.getDenominator();
        Sign result_sign;
        if(result_numerator<0){
            result_sign = Sign.MINUS;
            result_numerator = Math.abs(result_numerator);
        }
        else{result_sign = Sign.PLUS;}
        return new Fraction(result_sign, result_numerator, result_denominator);
    }

    // Сложение дроби с целым числом
    public Fraction add(int wholeNumber) {
        return this.add(new Fraction(Sign.PLUS, wholeNumber, 1));
    }

    // Вычитание двух дробей
    public Fraction subtract(Fraction other) {
        int resultNumerator = this.sign.getValue() * this.numerator * other.getDenominator()
                - other.getSignValue() * other.getNumerator() * this.denominator;
        int resultDenominator = this.denominator * other.getDenominator();
        Sign resultSign = (resultNumerator < 0) ? Sign.MINUS : Sign.PLUS;

        return new Fraction(resultSign, Math.abs(resultNumerator), resultDenominator);
    }

    // Вычитание дроби из целого числа
    public Fraction subtractFrom(int wholeNumber) {
        return new Fraction(Sign.PLUS, wholeNumber, 1).subtract(this);
    }

    // Умножение двух дробей
    public Fraction multiply(Fraction other) {
        int resultNumerator = this.sign.getValue() * this.numerator * other.getSignValue() * other.getNumerator();
        int resultDenominator = this.denominator * other.getDenominator();
        Sign resultSign = (resultNumerator < 0) ? Sign.MINUS : Sign.PLUS;

        return new Fraction(resultSign, Math.abs(resultNumerator), resultDenominator);
    }

    // Умножение дроби на целое число
    public Fraction multiply(int wholeNumber) {
        return this.multiply(new Fraction(Sign.PLUS, wholeNumber, 1));
    }

    // Деление двух дробей
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Division by zero.");
        }
        int resultNumerator = this.sign.getValue() * this.numerator * other.getDenominator();
        int resultDenominator = this.denominator * other.getSignValue() * other.getNumerator();
        Sign resultSign = (resultDenominator < 0) ? Sign.MINUS : Sign.PLUS;

        return new Fraction(resultSign, Math.abs(resultNumerator), Math.abs(resultDenominator));
    }

    // Деление дроби на целое число
    public Fraction divide(int wholeNumber) {
        return this.divide(new Fraction(Sign.PLUS, wholeNumber, 1));
    }

    // Пре-инкремент
    public Fraction increment() {
        return this.add(new Fraction(Sign.PLUS, 1, 1));
    }

    // Пост-инкремент (возвращает текущее значение, затем увеличивает)
    public Fraction postIncrement() {
        Fraction current = new Fraction(this.sign, this.numerator, this.denominator);
        this.add(new Fraction(Sign.PLUS, 1, 1)); // Увеличиваем текущее значение
        return current;
    }

    // Пре-декремент
    public Fraction decrement() {
        return this.subtract(new Fraction(Sign.PLUS, 1, 1));
    }

    // Пост-декремент (возвращает текущее значение, затем уменьшает)
    public Fraction postDecrement() {
        Fraction current = new Fraction(this.sign, this.numerator, this.denominator);
        this.subtract(new Fraction(Sign.PLUS, 1, 1)); // Уменьшаем текущее значение
        return current;
    }

    // Сравнение двух дробей
    public int compareTo(Fraction other) {
        double thisValue = this.getDoubleValue();
        double otherValue = other.getDoubleValue();
        return Double.compare(thisValue, otherValue);
    }

    // Приведение к double
    public double getDoubleValue() {
        return sign.getValue() * (double) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        return sign.getSymbol() + " " + numerator + "/" + denominator;
    }
}