# Инструкция по установки MariaDB (mysql), операционная система OpenSUSE 15

## Установка mysql (mariadb) используя команду zypper

`zypper install mysql`

![](pic/p1.png)

## Запуск mysql (mariadb)

`service mysql start`

![](pic/p2.png)

## Выполнения авторизации за стандартным пользователем root

`mysql -u'root' -p`

![](pic/p3.png)

## Создание базы банных (SQL запрос)

`CREATE DATABASE netology;`

![](pic/p4.png)

## Добавление пользователя mysql и назначение ему прав над БД, и применение изменений

`GRANT ALL PRIVILEGES ON *.* TO 'netology'@'localhost' indentified by 'pass_0000';`
`FLUSH PRIVILEGES;`

![](pic/p5.png)

## Проимпортировать схему в БД netology

`mysql -u'netology' -p'pass_0000' netology < schema.sql`

## Для повторных запусков приложения (SUT) использовать shell скрипт ./app-start.sh
