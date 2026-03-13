package Les_1_LambdasAndStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static void main() {
        /*PlainInterface plainInterface = new PlainInterface() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x+y);
            }
        };*/
        //PlainInterface plainInterface = (x,y) -> String.valueOf(x+y);
        //PlainInterface plainInterface1 = (x,y) ->String.valueOf(Integer.compare(x,y));
        //PlainInterface plainInterface = Integer::sum;
        //PlainInterface plainInterface1 = Integer::compare;
        //System.out.println(plainInterface1.action(1,5));
        //System.out.println(plainInterface.action(3,5));

        //List<String> list = Arrays.asList("Привет", "мир", "!", "я", "родился", "!");

        //list = list.stream().filter(str->str.length() >4).toList();
        //list.stream().filter(str->str.length() >4).forEach(System.out::println);
        //list.stream().filter(str->str.length() >4).filter(str->str.contains("о")).forEach(System.out::println);
        /*for (String string : list) {
            System.out.println(string);

        }*/

        //Arrays.asList(1,2,3,4,5).stream().map(number->number*number).forEach(System.out::println);
        //Stream.of(1,10,0,5,7,5).sorted().distinct().forEach(System.out::println);

        List<User> list = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40), new User("Валерий", 30));

        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <=25).forEach(System.out::println);
    }
}
