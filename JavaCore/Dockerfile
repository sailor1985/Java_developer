# Используем стабильный образ с JDK
FROM eclipse-temurin:25-jdk-jammy

# Устанавливаем рабочую директорию
WORKDIR /app

# Настраиваем переменные окружения для поддержки русского языка в консоли
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

# Команда для генерации документации.
# Мы используем ENTRYPOINT, чтобы можно было передавать дополнительные аргументы при запуске.
ENTRYPOINT ["javadoc", \
    "-d", "mydocumentation", \
    "-sourcepath", "src", \
    "-subpackages", "Sem_1_Compilation_and_interpretation", \
    "-private", \
    "-encoding", "UTF-8", \
    "-charset", "UTF-8", \
    "-docencoding", "UTF-8"]