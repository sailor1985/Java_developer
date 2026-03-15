package Sem_2_ReflectionAPI.Task_1;

import lombok.Getter;

@Getter

public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = "Name";
        this.age = 25;
    }

    public void displayInfo() {
        System.out.printf("Имя: %s; Возраст: %d\n%n", name, age);
    }
}
