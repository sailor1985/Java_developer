package Sem_5_Multithreading.Task_2;
/*
Создайте 2 потока А и В
Поток А меняет значение Boolean переменной switcher с задержкой 1000 мс (true в состоянии false и наоборот)
Поток В ожидает состояние true переменной switcher и выводит на консоль обратный отчет от 100 с задержкой 100 мс
и приостанавливает свое действие, как только поток А переключит switcher в состояние false
Условием завершения работы потоков является достижение отчета нулевой отметки.
Можно воспользоваться синхронизацией для управления значения переменной или volatile
 */
public class Programm {

    static void main() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadA.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
