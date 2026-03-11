package Sem_5_Multithreading.Task_2;

public class ThreadB extends Thread implements Runnable {
    private int counter = 100;
    private ThreadA threadA;

    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (counter >= 0) {
            if (threadA.getSwitcher()) {
                try {
                    Thread.sleep(100);
                    System.out.println(counter--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

