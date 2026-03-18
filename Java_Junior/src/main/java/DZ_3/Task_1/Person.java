package DZ_3.Task_1;


import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "имя='" + name + '\'' +
                ", возраст=" + age +
                '}';
    }
}
