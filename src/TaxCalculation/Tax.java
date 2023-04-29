package TaxCalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму: ");
        BigDecimal price = scanner.nextBigDecimal();

        //Ндс
        System.out.print("Введите ндс: ");
        BigDecimal ndc = scanner.nextBigDecimal();

        //Дополнительный налог
        System.out.print("Введите дополнительный налог: ");
        BigDecimal addTax = scanner.nextBigDecimal();

        //формула для ндс
        BigDecimal ndcFormula = price.multiply(ndc);

        //формула для дополнительного налога
        BigDecimal addTaxFormula = price.multiply(addTax);

        //итоговая цена
        BigDecimal finalPrice = price.add(ndcFormula).add(addTaxFormula);
        System.out.print("Общая стоимость товара: " + finalPrice.setScale(2, RoundingMode.HALF_UP));
    }
}
