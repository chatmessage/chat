## Установка и запуск приложения

Собрать `jar` артефакт приложения
```
./gradlew clean build
```

Собрать контейнер `docker`
```
docker-compose build
```

Запуск приложения
```
docker-compose up
```

## Доступ к приложению из Web

```
http://localhost:8080
```