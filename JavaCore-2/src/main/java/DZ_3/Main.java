package DZ_3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    static void main(String[] args) {
        Employee employee_1 = new Employee("John", "2018-09-15",1,"Дворник");
        Employee employee_2 = new Employee("Elis", "2023-02-23",5, "Сварщик");
        Employee employee_3 = new Employee("Elvin", "2019-04-01",9, "Плотник");
        Employee employee_4 = new Employee("Bob", "2025-04-01",4, "Фрезеровщик");
        Supervisor supervisor = new Supervisor("Fred","2023-04-23",4, "Директор по маркетингу");

        Employee [] employees =  {employee_1, employee_2, employee_3, employee_4, supervisor};
        employee_1.compareExperience(employee_2);

        Supervisor.salaryIncrease(employees, 1);

        System.out.println("\n=== СПИСОК СОТРУДНИКОВ ПОСЛЕ ПОВЫШЕНИЯ ===");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("===========================================");

    }
}
