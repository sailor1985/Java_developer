package Sem_4.Task_2;
/*
4.WrongPasswordException и WrongLoginException — пользовательские классы исключения с двумя конструкторами:
один по умолчанию, второй принимает параметры исключения (неверные данные) и возвращает пользователю в виде «ожидалось/фактически».
 */

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        this("20", "неизвестно"); // значения по умолчанию
    }

    public WrongPasswordException(String expected, String actual) {
        // В super передаем чистый результат форматирования
        super(String.format("Ошибка пароля! Ожидаемая длина: >= %s, фактическая: %s", expected, actual));
    }
}