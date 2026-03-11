package Sem_5_Multithreading.Task_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*
3 бегуна должны прийти к старту гонки
Программа должна гарантировать, что гонка начнется только тогда, когда все 3 участника будут на старте
Программа должна отсчитать "На старт", "Внимание", "Марш"
Программа должна завершиться, когда все участники закончат гонку
Подумайте об использовании примитива синхронизации
 */
public class Programm {
    private static final int COUNT_RUNNERS =3;
    static void main() {
        CountDownLatch readySignal = new CountDownLatch(COUNT_RUNNERS);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(COUNT_RUNNERS);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Вася", readySignal, startSignal, finishSignal),
                new Runner("Петя", readySignal, startSignal, finishSignal),
                new Runner("Ваня", readySignal, startSignal, finishSignal)
        ));

        new Thread(new Race(readySignal, startSignal,finishSignal)).start();
        for (Runner runner : runners) {
            new Thread(runner).start();
        }
    }
}
