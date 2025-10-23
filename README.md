
# Лабораторная работа №1 по Java
```

firstProject/  
├── .idea/  
├── out/ # Скомпилированные файлы
├── BD/ # Хранилище данных 
├── src/ # Исходный код приложения 
│ │ └── vadim.com.lib.pkg 
│ │ │ ├── library/ # Модуль библиотечной системы
│ │ │ │ ├── Book.java # Класс для работы с книгами  
│ │ │ │ └── Library.java # Основная логика библиотеки
│ │ │ ├── pkg/ # Дополнительные пакеты
│ │ │ │ └── App.java # Класс приложения 
│ │ │ └── Main.java # Главный класс для запуска 
├── .gitignore # Игнорируемые файлы для Git  
└── firstProject.iml # Файл конфигурации модуля
```

### Реализовано:
- print all books --> id + book name   --> O(n)
- select book by id  --> O(1)  
- -------------------------> description + some action with this book :  
-                                         1. read 
-                                         2. edit
-                                         3. save to file
-                                         5. exit --> Go to the first menu
-                                         6. show a short menu
- add --> add new book in vadim.com.lib.pkg.library --> O(1)  
- delete --> delete book from vadim.com.lib.pkg.library --> O(1)
- find book by Name --> O(n)  
- find by author --> O(n)  
- QUIT --> shutdown --> O(1)  
- Show a menu --> O(1)")
## [Махмудов Вадим 24КНТ-7]()