package Sem_3_Generic_programming.Task_1;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class Main {
    static void main() {
        String myT = "Hello";
        DataInputStream myV = new DataInputStream(new ByteArrayInputStream(new byte[0]));
        Integer myK = 100;

        Programm_1<String, DataInputStream, Integer> programm = new Programm_1<>(myT, myV, myK);

        programm.printNames();
    }
}
