package Sem_1_LambdasAndStreamAPI.Task_1;

import java.util.ArrayList;
import java.util.List;

/*
Задача 1: Реализовать систему учёта книг в библиотеке
У каждой книги есть:
• 	название,
• 	автор,
• 	год издания.
Необходимо создать список книг и выполнить следующие действия:
1. Обычный способ:
• 	Найти все книги, написанные определённым автором (например, John Doe).
• 	Найти все книги, изданные после определённого года (например, 2010).
• 	Найти все уникальные названия книг в библиотеке.
2. Использование лямбда‑выражений:
• 	Те же самые задачи, но с использованием лямбда‑выражений и Stream API для более компактного и выразительного кода.
 */
public class Library {
    static void main() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        List<Book> authorBooks = books.stream().filter(book -> book.getAuthor().equals("Лев Толстой")).toList();
        System.out.println("Лев Толстой" + authorBooks);

        List<Book> yearBooks = books.stream().filter(book -> book.getYear() > 1866).toList();
        System.out.println("Книги после 1866" + yearBooks);

        List<String> uniqueTitles = books.stream().map(Book::getTitle).distinct().toList();
        System.out.println("Наименования книг " + uniqueTitles);
    }
}
