# MicroservicesCoursework

Учебный проект с микросервисной архитектурой, написанный с использованием Spring Boot, Spring Cloud и Docker.

## Разработка

Для разработки конкретного сервиса (patient, seizure или treatment), необходимо запустить service-discovery, который позволит обращаться к сервисам по имени.

Также перед разработкой необходимо поднять контейнер с базой данных для соответствующего сервиса:
1. Для patient: `docker-compose up -f .\docker-compose.dev.yml patient-database`
2. Для seizure: `docker-compose up -f .\docker-compose.dev.yml seizure-database`
3. Для treatment: `docker-compose up -f .\docker-compose.dev.yml treatment-database`

### Запросы:

Чтобы выполнить HTTP запросы к сервисам можно обращатся к ним напрямую:
1. Для patient: `localhost:8081`
2. Для seizure: `localhost:8082`
3. Для treatment: `localhost:8083`

Или при помощи сервиса gateway, которые осуществляет перенаправление запросов:
1. Для patient: `localhost:8080/patient`
2. Для seizure: `localhost:8080/seizure`
3. Для treatment: `localhost:8080/treatment`
