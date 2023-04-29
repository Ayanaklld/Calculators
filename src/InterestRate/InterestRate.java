package InterestRate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада: ");
        BigDecimal deposit = scanner.nextBigDecimal();

        System.out.println("Введите процентную ставку: ");
        BigDecimal interestRate = scanner.nextBigDecimal();
        interestRate = interestRate.divide(BigDecimal.valueOf(100));
        interestRate = interestRate.divide(BigDecimal.valueOf(12));

        System.out.println("Процентная ставка на месяц: " + interestRate);

        System.out.println("Введите срок вклада(в месяцах): ");
        BigDecimal months = scanner.nextBigDecimal();

        //formula 1
        BigDecimal onePlusInterestRate = interestRate.add(BigDecimal.ONE);
        BigDecimal pow = onePlusInterestRate.pow(months.intValue());
        BigDecimal powMinusOne = pow.subtract(BigDecimal.ONE);

        //formula 2
        BigDecimal interestRateDividePowMinusOne = interestRate.divide(powMinusOne, 6, RoundingMode.HALF_UP);

        //formula 3
        BigDecimal IRP = interestRate.add(interestRateDividePowMinusOne);

        //formula 4
        BigDecimal monthlyPayment = deposit.multiply(IRP);

        System.out.println("Ежемесячный платеж: " + monthlyPayment);

        //сумма переплаты
        //formula 5
        BigDecimal overPayment = (monthlyPayment.multiply(months)).subtract(deposit);
        System.out.println("Общая сумма переплаты: " + overPayment);

        //Общая сумма выплат
        BigDecimal payout = overPayment.add(deposit);
        System.out.println("Общая сумма выплат: " + payout);

    }
}
