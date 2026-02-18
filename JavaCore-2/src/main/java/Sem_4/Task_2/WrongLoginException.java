package Sem_4.Task_2;
/*
4.WrongPasswordException и WrongLoginException — пользовательские классы исключения с двумя конструкторами:
один по умолчанию, второй принимает параметры исключения (неверные данные) и возвращает пользователю в виде «ожидалось/фактически».
 */
public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
        this("< 20", ">= 20");
    }

    public WrongLoginException(String expected, String actual) {
        // Форматируем строку так, чтобы в нее вставлялись только значения
        super(String.format("Ошибка логина! Ожидалось: %s символов, фактически введено: %s", expected, actual));
    }
}