package Sem_5_Multithreading.Task_1;

/*
Создать 2 класса ObjectA и ObjectB
Реализовать класс, в котором 2 потока при запуске провоцируют DeadLock для объектов  ObjectA и ObjectB
 */
public class Programm {
    static Object objectA = new Object();
    static Object objectB = new Object();

    static void main() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread2();
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void workThread1(){
        synchronized (objectA) {
            try {
                System.out.println("Поток 1 захватил объект А ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            synchronized (objectB) {
                System.out.println("Поток 1 захватил объект B ");
            }
        }
    }

    public static void workThread2(){
        synchronized (objectB) {
            System.out.println("Поток 2 захватил объект B ");
            synchronized (objectA) {
                System.out.println("Поток 2 захватил объект A ");
            }
        }
    }
}
