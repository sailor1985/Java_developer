package DZ_4.Task_1;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        Employee employee_1 = new Employee(1, "89851233958","Михаил", 23);
        Employee employee_2 = new Employee(2, "891697804014","Юлия", 18);
        Employee employee_3 = new Employee(3, "89805374714","Ирина", 40);
        Employee employee_4 = new Employee(4, "89582587845","Маргарита", 15);
        Employee employee_5 = new Employee(5, "89783571892","Михаил", 15);

        EmployeeDirectory directory = new EmployeeDirectory();
        directory.addEmployees(employee_1, employee_2, employee_3, employee_4, employee_5);
        directory.getEmployeeList().forEach(System.out::println);

        List<Employee> employeeListByExperience = directory.findEmployeeByExperience(40);
        employeeListByExperience.forEach(System.out::println);

        String name = directory.telephoneNumberReturn("Михаил");
        System.out.println(name);

        System.out.println(directory.findEmployeeByPersonnelNumber(2));

        //Появился новый сотрудник
        Employee employee_6 = new Employee(6, "891472583698","Альфред", 80);
        directory.addEmployees(employee_6);

        String report = directory.getEmployeeList().stream()
                .map(Employee::toString)
                .collect(Collectors.joining(";\n")); // Склеиваем точкой с запятой и переносом

        System.out.println("СПИСОК СОТРУДНИКОВ:");
        System.out.println(report);
    }
}
