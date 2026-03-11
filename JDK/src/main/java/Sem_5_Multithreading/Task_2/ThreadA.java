package Sem_5_Multithreading.Task_2;

import lombok.Getter;

@Getter
public class ThreadA extends Thread implements Runnable  {
    private volatile Boolean switcher = false;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println(switcher);
            } catch (InterruptedException e) {
                System.out.println("Программа закончила работу");
                break;
            }
        }
    }
}
