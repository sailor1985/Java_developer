package DZ_4.Task_1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*Создать справочник сотрудников:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников

Добавить метод, который:
-ищет сотрудника по стажу (может быть список)
-возвращает номер телефона сотрудника по имени (может быть список)
-ищет сотрудника по табельному номеру
-добавляет нового сотрудника в справочник
 */
@Data
public class EmployeeDirectory {
    private final List<Employee> employeeList = new ArrayList<>();

    //Добавление сотрудников в employeeList в том числе и одного нового
    public void addEmployees(Employee... employees) {
        for (Employee newEmp : employees) {
            // Проверяем: есть ли в списке кто-то с таким же номером
            boolean exists = employeeList.stream()
                    .anyMatch(e -> e.getPersonnelNumber() == newEmp.getPersonnelNumber());

            if (!exists) {
                employeeList.add(newEmp);
            } else {
                System.out.println("Дубликат табельного номера: " + newEmp.getPersonnelNumber());
            }
        }
    }

    //Ищет сотрудника по стажу (может быть список)
    public List<Employee> findEmployeeByExperience (int experience) {
        return employeeList.stream().filter(employee -> employee.getExperience()  == experience).toList();
    }

    //Возвращает номер телефона сотрудника по имени (может быть список)
    public String telephoneNumberReturn (String name) {
        return employeeList.stream().filter(emp-> Objects.equals(emp.getName(), name)).map(Employee::getTelephoneNumber).collect(Collectors.joining(", "));
    }

    //Ищет сотрудника по табельному номеру
    public List<Employee> findEmployeeByPersonnelNumber (int personnelNumber) {
        return employeeList.stream().filter(e->Objects.equals(e.getPersonnelNumber(), personnelNumber)).toList();
    }

}
