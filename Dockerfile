# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo de construcción de Gradle y el código fuente
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Instalar dependencias y construir la aplicación
RUN ./gradlew build --no-daemon

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/arquitecture-0.1-all.jar"]