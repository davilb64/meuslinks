# 1. Baixa uma máquina Linux com Maven e Java 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# 2. Copia seu código para dentro da máquina da nuvem
COPY pom.xml .
COPY src ./src

# 3. Manda o Maven compilar o projeto e gerar o arquivo .jar
RUN mvn clean package -DskipTests

# 4. Cria uma máquina mais leve só para rodar (sem o Maven pesado)
FROM eclipse-temurin:17-jre
WORKDIR /app

# 5. Pega o .jar que foi criado no passo 3
COPY --from=build /app/target/*.jar app.jar

# 6. Libera a porta 8080 para a internet
EXPOSE 8080

# 7. O comando que liga o servidor Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]