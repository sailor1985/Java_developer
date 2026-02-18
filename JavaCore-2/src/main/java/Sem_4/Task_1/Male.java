package Sem_4.Task_1;

import lombok.Getter;

@Getter
public enum Male {
    MALE("мальчик") ,FEMALE("девочка");

    private final String russianMaleTittle;


    Male(String russianMaleTittle) {
        this.russianMaleTittle = russianMaleTittle;
    }

    //abstract void test(); автоматически предлагается его реализация здесь же в MALE и FEMALE

}
