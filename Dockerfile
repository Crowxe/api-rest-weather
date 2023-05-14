# Usar la imagen oficial de OpenJDK como base
FROM openjdk:11-jdk

# Establecer el directorio de trabajo
WORKDIR /clima

# Copiar el archivo .jar del proyecto al directorio de trabajo
COPY target/*.jar clima.jar

# Exponer el puerto por el que se comunicará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "clima.jar"]

