package Sem_2LambdasAndStreamAPI.Task_2;

public class DumplingsMeat implements SemiFinishedFood{
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Пельмени";
    }
}
