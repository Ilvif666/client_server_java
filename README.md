# Programming_lab6
Разделить программу из лабораторной работы №5 на клиентский и серверный модули.

### Функционал программы из лабораторной №5
Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию. Все требования
к полям класса (указанные в виде комментариев) должны быть выполнены. Для хранения необходимо использовать коллекцию
типа java.util.LinkedList При запуске приложения коллекция должна автоматически заполняться значениями из файла. Имя
файла должно передаваться программе с помощью: аргумент командной строки. Данные должны храниться в файле в формате xml
Чтение данных из файла необходимо реализовать с помощью класса java.util.Scanner Запись данных в файл необходимо
реализовать с помощью класса java.io.FileWriter Все классы в программе должны быть задокументированы в формате javadoc.
Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к
файлу и т.п.). В интерактивном режиме программа должна поддерживать выполнение следующих команд:

- help : вывести справку по доступным командам
- info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
- show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
- add {element} : добавить новый элемент в коллекцию
- update id {element} : обновить значение элемента коллекции, id которого равен заданному
- remove_by_id id : удалить элемент из коллекции по его id
- clear : очистить коллекцию save : сохранить коллекцию в файл
- execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
в котором их вводит пользователь в интерактивном режиме.
-   exit : завершить программу (без сохранения в файл)
-   head : вывести первый элемент коллекции
-   add_if_max {element} : добавить новый элемент в коллекцию, если его значение
превышает значение наибольшего элемента этой коллекции
-   remove_greater {element} : удалить из коллекции все элементы,
превышающие заданный
-   print_descending : вывести элементы коллекции в порядке убывания
-   print_unique_salary : вывести уникальные значения поля salary всех элементов в коллекции
-   print_field_ascending_salary : вывести значения поля salary всех элементов в порядке возрастания
Серверный модуль должен осуществлять выполнение команд по управлению коллекцией. Клиентский модуль должен в интерактивном режиме считывать команды, передавать их для выполнения на сервер и выводить результаты выполнения.

### Необходимо выполнить следующие требования:

-   Операции обработки объектов коллекции должны быть реализованы с помощью Stream API с использованием лямбда-выражений.
-	Объекты между клиентом и сервером должны передаваться в сериализованном виде.
-	Объекты в коллекции, передаваемой клиенту, должны быть отсортированы по местоположению
-	Клиент должен корректно обрабатывать временную недоступность сервера.
-	Обмен данными между клиентом и сервером должен осуществляться по протоколу UDP
-	Для обмена данными на сервере необходимо использовать датаграммы
-	Для обмена данными на клиенте необходимо использовать сетевой канал
-	Сетевые каналы должны использоваться в неблокирующем режиме.

### Обязанности серверного приложения:

-	Работа с файлом, хранящим коллекцию.
-	Управление коллекцией объектов.
-	Назначение автоматически генерируемых полей объектов в коллекции.
-	Ожидание подключений и запросов от клиента.
-	Обработка полученных запросов (команд).
-	Сохранение коллекции в файл при завершении работы приложения.
-	Сохранение коллекции в файл при исполнении специальной команды, доступной только серверу (клиент такую команду отправить не может).
 
### Серверное приложение должно состоять из следующих модулей (реализованных в виде одного или нескольких классов):

-	Модуль приёма подключений.
-	Модуль чтения запроса.
-	Модуль обработки полученных команд.
-	Модуль отправки ответов клиенту.
- Сервер должен работать в однопоточном режиме.


### Обязанности клиентского приложения:

-	Чтение команд из консоли.
-	Валидация вводимых данных.
-	Сериализация введённой команды и её аргументов.
-	Отправка полученной команды и её аргументов на сервер.
-	Обработка ответа от сервера (вывод результата исполнения команды в консоль).
-	Команду save из клиентского приложения необходимо убрать.
-	Команда exit завершает работу клиентского приложения.