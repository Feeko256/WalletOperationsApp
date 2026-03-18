# WalletOperationApp
# Основные зависимости
* Spring Boot 3
* PostgreSQL
* Liquibase
* Junit
* Rest Assured
* Project lombok

# Среда разработки
* ```IntelliJ IDEA 2025.3.1.1```
* ```Maven 3.9.12```
* ```java 17```

# Инструкция по сборке
* Установить Docker
* Склонировать репозиторий
* Находясь в консоли IDE выполнить комманды
* ```./mvnw clean package -DskipTests```
* ```docker-compose down -v```
* ```docker-compose up --build```
* После успешного запуска докер-контейнера, в консоли написать ```d``` и запустить тесты командой
* ```.\mvnw clean test```