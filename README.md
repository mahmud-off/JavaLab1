
# Лабораторная работа №1 по Java
```

firstProject/  
├── .idea/  
├── out/ # Скомпилированные файлы
├── BD/ # Хранилище данных 
├── src/ # Исходный код приложения  
│ │ ├── Library/ # Модуль библиотечной системы
│ │ │ ├── Book.java # Класс для работы с книгами  
│ │ │ └── Library.java # Основная логика библиотеки
│ │ ├── pkg/ # Дополнительные пакеты
│ │ │ └── App.java # Класс приложения 
│ │ └── Main.java # Главный класс для запуска 
├── .gitignore # Игнорируемые файлы для Git  
└── firstProject.iml # Файл конфигурации модуля
```
# [ЕСЛИ БУДЕТЕ ТАВИТЬ ОБЯЗАТЕЛЬНО СОЗДАЙТЕ В ПАПКЕ ПРОЕКТА ДИРЕКТОРИЮ "BD"]
Это база данных где хранятся книжки
Книжки после перезапуска программы подгружаются с этой директории
### Реализовано:
- print all books --> id + book name   --> O(n)
- 2. select book by id  --> O(1)  
- -------------------------> description + some action with this book :  
-                                         1. read 
-                                         2. edit
-                                         3. save to file
-                                         5. exit --> Go to the first menu
-                                         6. show a short menu
- 4. add --> add new book in library --> O(1)  
- 5. delete --> delete book from library --> O(1)
- 6. find book by Name --> O(n)  
- 7. find by author --> O(n)  
- 8. QUIT --> shutdown --> O(1)  
- 9. Show a menu --> O(1)")
## Махмудов Вадим 24КНТ-7