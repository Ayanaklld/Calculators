package Calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        BigDecimal bd1 = scanner.nextBigDecimal();

        System.out.println("Введите ваш параметр: ");
        String operator = scanner.next();

        System.out.println("Введите второе число: ");
        BigDecimal bd2 = scanner.nextBigDecimal();

        BigDecimal result = new BigDecimal("0");

        switch (operator) {
            case "+" -> result = bd1.add(bd2);
            case "-" -> result = bd1.subtract(bd2);
            case "*" -> result = bd1.multiply(bd2);
            case "/" -> result = bd1.divide(bd2);
            default -> System.out.println("Вы ввели неправильный оператор.");
        }

        System.out.println("Ваш результат: " + result);
    }
}
