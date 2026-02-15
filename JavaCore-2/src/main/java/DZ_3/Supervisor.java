package DZ_3;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@EqualsAndHashCode(callSuper = true)
public class Supervisor extends Employee {

    public Supervisor(String name, String hireDate, int salary, String position) {
        super(name, String.valueOf(hireDate), salary, position);
    }

    @Override
    public String toString() {
        return String.format("РУКОВОДИТЕЛЬ: %-7s | Дата: %s | Зарплата: %-6d | Должность: %s",
                getName(), getHireDate(), getSalary(), getPosition());
    }

    public static Employee [] salaryIncrease(Employee [] employees, int value) {
        LocalDate today = LocalDate.now(); // Текущая дата

        for (Employee emp : employees) {
            // 1. Считаем разницу в полных годах между датой найма и сегодня
            long yearsWorked = ChronoUnit.YEARS.between(emp.getHireDate(), today);

            // 2. Условие: если работает 5 лет и более и НЕ является руководителем
            if (yearsWorked >= 5 && !(emp instanceof Supervisor)) {
                emp.setSalary(emp.getSalary() + value);
            }
        }

        return employees;
    }
}