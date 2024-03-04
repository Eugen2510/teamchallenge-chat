FROM openjdk

# Создайте директорию приложения внутри контейнера
RUN mkdir /app

# Копируйте JAR-файл внутрь контейнера
COPY ./build/libs/chat-alpha.jar /app/chat-alpha.jar
#COPY ./src/main/resources/application.properties /app/application.properties
EXPOSE 8080

# Установите рабочий каталог
WORKDIR /app

#ENV DB_URL=jdbc:postgresql://localhost:5434/TestChat1
#ENV DB_USER=postgres
#ENV DB_PASSWORD=myPassword123

# Запустите приложение
CMD ["sh", "-c", "sleep 10 && java -jar chat-alpha.jar"]
#CMD ["java", "-jar", "chat-alpha.jar"]
