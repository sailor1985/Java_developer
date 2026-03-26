import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Иван", "Иванов", 30);

        // Инициализируем Gson (с "красивым" выводом)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Сериализация: Объект -> JSON (String)
        String json = gson.toJson(person);
        System.out.println("Объект преобразован в JSON:");
        System.out.println(json);

        // Десериализация: JSON (String) -> Объект
        Person personFromJson = gson.fromJson(json, Person.class);
        System.out.println("\nОбъект восстановлен из JSON:");
        System.out.println(personFromJson.toString());

        // Проверка работы equals() из commons-lang3
        System.out.println("\nОбъекты равны: " + person.equals(personFromJson));
    }
}
