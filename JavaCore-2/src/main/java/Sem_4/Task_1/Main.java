package Sem_4.Task_1;

import java.util.*;
import java.util.function.BiFunction;

public class Main {
    static void main(String[] args) {
        Cat cat1 = new Cat(Male.MALE);
        Cat cat2 = new Cat(Male.FEMALE);
        Cat cat3 = new Cat(Male.MALE);
        //Cat cat4 = new Cat("Banana");

        Cat [] cats = {cat1,cat2,cat3,/*cat4*/};
        List <Cat>  catlist = Arrays.asList(cats);

        for (Cat cat : catlist) {
            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }

        System.out.println("****");
        for (Cat cat : catlist) {
            System.out.println(cat.getMale().getRussianMaleTittle());
            
        }
        System.out.println("****");

        Male personaSex = Male.MALE;
        System.out.println(personaSex.getRussianMaleTittle());

        //То, что делает foreach (17 строка) "под капотом"
        Iterator<Cat> iterator = catlist.iterator();
        while (iterator.hasNext()) {
            Cat cat = iterator.next();

            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }

       /* for (Cat cat : cats) {
            switch (cat.getMail()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }*/

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        };

        Runnable runnable2 = () -> {System.out.println("New Run");};
        runnable.run();
        runnable2.run();

        BiFunction<Integer,Integer,String> biFunction = new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return String.format("%s+%s=%s",a,b,a+b);
            }
        };

        BiFunction<Integer,Integer,String> biFunction2 =
            ( a,  b) -> String.format("NEW RESULT: %s+%s=%s",a,b,a+b);

        System.out.println(biFunction.apply(5,7));
        System.out.println(biFunction2.apply(5,7));

        List<String> names = Arrays.asList("Тимофей", "Анна", "Борис");

        // Анонимный класс для сортировки по длине слова по возрастанию
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        //Этот же метод через лямбду
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);
       }
}