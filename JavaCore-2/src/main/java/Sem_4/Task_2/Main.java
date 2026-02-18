package Sem_4.Task_2;

import java.util.Scanner;

/*
5.В основном классе программы необходимо по-разному обработать исключения.
6.Метод возвращает true, если значения верны, или false в противном случае
 */
public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Login:");
        String login = scanner.nextLine();

        System.out.println("Введите Password:");
        String password = scanner.nextLine();

        System.out.println("Подтвердите Password:");
        String confirmPassword = scanner.nextLine();

            boolean result = LoginPassword.checkLoginPassword(login,password,confirmPassword);
            // Если мы здесь — значит исключений не было, result будет true
            System.out.println("Результат: " + result);
       }
}