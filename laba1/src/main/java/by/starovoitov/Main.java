package by.starovoitov;

public class Main {
    public static void main(String[] args) {
        // Создаем дроби
        Fraction fraction1 = new Fraction(Sign.PLUS, 3, 4); // 3/4
        Fraction fraction2 = new Fraction(Sign.MINUS, 2, 5); // -2/5

        // Сложение дробей
        Fraction sum = fraction1.add(fraction2);
        System.out.println("Сумма: " + sum); // 3/4 + (-2/5)

        // Сложение дроби с целым
        Fraction sumWithWhole = fraction1.add(2);
        System.out.println("Сумма с целым: " + sumWithWhole); // 3/4 + 2

        // Вычитание дробей
        Fraction difference = fraction1.subtract(fraction2);
        System.out.println("Разность: " + difference); // 3/4 - (-2/5)

        // Вычитание дроби из целого
        Fraction differenceFromWhole = fraction1.subtractFrom(2);
        System.out.println("Разность из целого: " + differenceFromWhole); // 2 - 3/4

        // Умножение дробей
        Fraction product = fraction1.multiply(fraction2);
        System.out.println("Произведение: " + product); // 3/4 * (-2/5)

        // Умножение дроби на целое
        Fraction productWithWhole = fraction1.multiply(2);
        System.out.println("Произведение с целым: " + productWithWhole); // 3/4 * 2

        // Деление дробей
        Fraction quotient = fraction1.divide(fraction2);
        System.out.println("Частное: " + quotient); // 3/4 / (-2/5)

        // Деление дроби на целое
        Fraction quotientWithWhole = fraction1.divide(2);
        System.out.println("Частное с целым: " + quotientWithWhole); // 3/4 / 2

        // Инкремент
        Fraction incremented = fraction1.increment();
        System.out.println("Инкремент: " + incremented); // 3/4 + 1

        // Пост-инкремент
        Fraction postIncremented = fraction1.postIncrement();
        System.out.println("Пост-инкремент: " + postIncremented); // текущее значение
        System.out.println("После пост-инкремента: " + fraction1); // значение после инкремента

        // Декремент
        Fraction decremented = fraction1.decrement();
        System.out.println("Декремент: " + decremented); // текущее значение - 1

        // Пост-декремент
        Fraction postDecremented = fraction1.postDecrement();
        System.out.println("Пост-декремент: " + postDecremented); // текущее значение
        System.out.println("После пост-декремента: " + fraction1); // значение после декремента

        // Сравнение дробей
        int comparison = fraction1.compareTo(fraction2);
        if (comparison > 0) {
            System.out.println(fraction1 + " больше " + fraction2);
        } else if (comparison < 0) {
            System.out.println(fraction1 + " меньше " + fraction2);
        } else {
            System.out.println(fraction1 + " равно " + fraction2);
        }
    }
}