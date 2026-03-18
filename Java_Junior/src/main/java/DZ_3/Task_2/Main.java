package DZ_3.Task_2;

public class Main {
    static void main() {
        PersonRepository repo = new PersonRepository();

        // Добавляем
        Person vlad = new Person("Владислав", 30);
        repo.addPerson(vlad);
        System.out.println("Сохранен: " + vlad);

        // Обновляем
        vlad.setAge(31);
        repo.updatePerson(vlad);
        System.out.println("После обновления: " + repo.findById(vlad.getId()));

        System.out.println("Все в базе: " + repo.findAll());

        // Удаляем
        // repo.deletePerson(vlad.getId());

        repo.close();
    }
}