-- Добавляем книги
INSERT INTO BOOKS (NAME) VALUES ('Чистый код');
INSERT INTO BOOKS (NAME) VALUES ('Философия Java');
INSERT INTO BOOKS (NAME) VALUES ('Spring в действии');

-- Добавляем читателей
INSERT INTO READERS (NAME) VALUES ('Игорь');
INSERT INTO READERS (NAME) VALUES ('Анна');

-- Добавляем записи о выдаче (ID 1 и 2 уже должны быть созданы выше)
INSERT INTO ISSUES (BOOK_ID, READER_ID, ISSUED_AT) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO ISSUES (BOOK_ID, READER_ID, ISSUED_AT) VALUES (2, 2, CURRENT_TIMESTAMP);