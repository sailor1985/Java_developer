package Sem_5.DesignAPIForServerApp;

public class NotesEndPoints {
    /*
    Пользователь:
    ...CRUD
    Заметки:
    1. Создать заметку
    2. Прочитать заметку
    3. Обновить заметку
    4. Удалить заметку
    5. Загрузить все заметки
    Тэги:
    1. CruD над тэгами
    TODO: Научиться тэги мапить на заметки

    User(id, name, ....)
    {
    "id": 5,
    "name": "FirstUser",
    ///}
    POST /user {BODY} - создать пользователя
    GET /user/{id} - получить пользователя по ID
    ... еще PUT - на изменение, delete - на удаление

    GET /notes/{id} - получить описание заметки
    {
    "id": 1,
    "title": "first",
    "content": "content of note",
    "createdAt": "2024-01-25T14:54",
    "deletedAt": null,
    "userId": 3,
    "tags":[
    "f", "important", "draft"],
    ""
    }

    GET /note?page=0&size=5 - получить список всех заметок
    {
        "notes": [
          {
            "id": 1,
            "title": "first",
            "createdAt": "2024-01-25T14:54",
            "tags":[1,3,4],
          }
         .....
         ],
        "paging": {
            "page": 0,
            "size": 5,
            "total":120,
            "totalPages":3
        }
    }

    TAG {
       "id": 3,
       "title": "important",
       "color": "#FFAAEF",
       "description": "description",
       "userId": 3,
    }

    1. Получить список заметок по тэгу:
    --GET /tag/{id}/note
    GET /notes?tag={tagId}

    2. Привязать тэг к заметке
    PUT /note/{noteId}/tag/{tageId}

    3. Получить заметки для пользователя
    Во всех запросах должен быть заголовок Authorization: Bearer tokenValue




     */
}
