package Sem_3_Generic_programming.Task_1;

import lombok.Getter;

import java.io.DataInput;
import java.io.InputStream;

/**
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K),
 * конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных.

 * Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа:
 * T должен реализовать интерфейс Comparable,
 * V должен реализовать интерфейс DataInput и расширять класс InputStream,
 * K должен расширять класс Number.
 */
@Getter
public class Programm_1<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private final T t;
    private final V v;
    private final K k;

    public Programm_1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public void printNames() {
        System.out.println("Тип T: " + t.getClass().getSimpleName());
        System.out.println("Тип V: " + v.getClass().getSimpleName());
        System.out.println("Тип K: " + k.getClass().getSimpleName());
    }
}
