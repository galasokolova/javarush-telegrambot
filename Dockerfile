FROM openjdk:17

# Установка рабочей директории
WORKDIR /app

# Копирование файлов проекта
COPY . /app

# Копирование приложения и его конфигураций
COPY target/javarush-telegrambot-0.1.0-SNAPSHOT.jar /app/javarush-telegrambot.jar
COPY src/main/resources/application.properties /app/config/

# Копирование и установка скриптов запуска
COPY scripts/entrypoint.sh /scripts/entrypoint.sh
RUN chmod +x /scripts/entrypoint.sh

ENTRYPOINT ["/scripts/entrypoint.sh"]


