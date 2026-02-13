package Sem_2_Data_and_functions;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(999999999);
        Scanner scanner = new Scanner(System.in);
        BigDecimal b = scanner.nextBigDecimal();
        System.out.println(b.multiply(a));
    }
}
