# АРМ менеджера по оформлению кредита

## Обзор

Это приложение предназначено для автоматизации рабочего места менеджера по оформлению кредита с использованием
следующего стека технологий: Spring MVC, Hibernate (без использования Spring Data) и PostgreSQL.

## Общий процесс

1. **Оформление заявки на кредит**
2. **Принятие решения по кредиту**
3. **Подписание кредитного договора**

### 1. Оформление заявки на кредит

Пользователь создает заявку на кредит, содержащую следующую информацию о клиенте:

- Фамилия, имя, отчество
- Паспортные данные
- Семейное положение
- Адрес прописки
- Контактный телефон
- Сведения о занятости (период работы, должность, название организации)
- Сумма желаемого кредита

### 2. Принятие решения по кредиту

После оформления заявки на кредит система случайным образом принимает решение о кредите. Решение состоит из статуса (
одобрен/не одобрен), предлагаемого срока в днях (1-12 месяцев), одобренной суммы кредита.

### 3. Подписание кредитного договора

После одобрения кредита система должна позволить подписать кредитный договор. Кредитный договор должен содержать
информацию из заявки, дату подписания, а также статус подписи (подписан/не подписан).

## Дополнительный функционал

1. Вывод списка всех клиентов
2. Поиск клиента по телефону, ФИО и паспортным данным
3. Вывод списка заявок со статусом одобрения
4. Вывод списка всех подписанных кредитных договоров со статусом подписания

## Структура проекта и настройка

### Схема БД

![Database Schema](img/db.png)

### Основной функционал

1. **Вывод списка всех клиентов**
2. **Поиск клиента по телефону, ФИО и паспортным данным**
3. **Вывод списка заявок со статусом одобрения**
4. **Вывод списка всех подписанных кредитных договоров со статусом подписания**

#### Главная страница

![Главная страница](img/home.png)

#### Форма оформления заявки на кредит

![Форма оформления заявки на кредит](img/request.png)

#### Результаты оформления заявки

##### Заявка не одобрена

![Заявка не одобрена](img/not_allowed.png)

##### Заявка одобрена

![Заявка одобрена](img/allowed.png)

#### Список всех заявок

![Список всех заявок](img/requests.png)

#### Список всех договоров с возможностью подписания

![Список всех договоров с возможностью подписания](img/contracts.png)

#### Список клиентов

![Список клиентов](img/clients_list.png)

#### Поиск клиента по ФИО

![Поиск клиента по ФИО](img/searchByFio.png)

#### Поиск клиента по паспортным данным

![Поиск клиента по паспортным данным](img/searchByPassport.png)

#### Поиск клиента по номеру телефона

![Поиск клиента по номеру телефона](img/searchByContactPhone.png)

## Используемые технологии

<img src="https://www.clipartmax.com/png/full/354-3543373_spring-framework-logo-svg-png-download-java-spring.png" width="80" alt="Spring">
<img src="https://www.javatpoint.com/images/hibernate/hibernate2.png" width="70" alt="Hibernate ORM"> 
<img src="https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/postgresql-icon.png" width="60" alt="PostgreSQL">
<img src="https://maven.apache.org/images/maven-logo-black-on-white.png" width="120" alt="Maven Apache">
<img src="https://www.thymeleaf.org/images/thymeleaf.png" width="70" alt="Thymeleaf">
<img src="https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo-shadow.png" width="90" alt="Bootstrap">