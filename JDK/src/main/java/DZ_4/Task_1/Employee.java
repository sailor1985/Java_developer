package DZ_4.Task_1;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
каждый сотрудник должен иметь следующие атрубуты:
табельный номер, номер телефона, имя, стаж
*/

@Data
@AllArgsConstructor
public class Employee {
    private int personnelNumber;
    private String telephoneNumber;
    private String name;
    private int experience;

    @Override
    public String toString() {
        return String.format("Сотрудник [Табельный номер: %3d | Имя: %-10s | Тел: %-12s | Стаж: %2d лет]",
                personnelNumber,
                name,
                telephoneNumber,
                experience);
    }
}