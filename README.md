# Итоговая работа

## Задание
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

3. Создать директорию, переместить файл туда.

4. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

5. Установить и удалить deb-пакет с помощью dpkg.

6. Выложить историю команд в терминале ubuntu

7. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).

8. В подключенном MySQL репозитории создать базу данных “Друзья человека”

9. Создать таблицы с иерархией из диаграммы в БД

10. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

11. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.

14. Написать программу, имитирующую работу реестра домашних животных. В программе должен быть реализован следующий функционал:

14.1 Завести новое животное

14.2 определять животное в правильный класс

14.3 увидеть список команд, которое выполняет животное

14.4 обучить животное новым командам

14.5 Реализовать навигацию по меню

15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆int переменной̆ на 1 при нажатие “Завести новое животное” Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведения животного заполнены все поля.

## Краткий гайд по репозиторию:
- В папке "история команд в терминале ubuntu" скриншоты истории команд, с помощью которых создавалиись с 1 по 4 номер задания.
- Папка directory и файлы "Вьючные_животные.txt" и "Домашние_животные.txt" - это работа с 1 по 4 задания
- диаграмма 6 задания
- friendsohuman.sql открывается в sql (выполнение c 7 по 12 задание). Таблицы создаются, удаляются и  объединяются строго по порядку. Посмотреть таблицы можно, используя такие команды как "SELECT ALL * FROM название_таблицы;" или "SELECT * FROM friendsofhuman.allanimals;"
