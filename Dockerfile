# Usar la imagen oficial de OpenJDK como base
FROM openjdk:11-jdk AS builder

# Instalar Git
RUN apt-get update && \
    apt-get install -y git

# Establecer el directorio de trabajo
WORKDIR /clima

# Clonar el repositorio del proyecto
RUN git clone https://github.com/Crowxe/api-rest-weather.git .

# Otorgar permisos de ejecución al archivo 'mvnw'
RUN chmod +x ./mvnw

# Si usas Maven:
RUN ./mvnw clean package -DskipTests

# Crear la imagen final con la aplicación compilada
FROM openjdk:11-jdk

# Establecer el directorio de trabajo
WORKDIR /clima

# Copiar el archivo .jar del builder al directorio de trabajo
COPY --from=builder /clima/target/*.jar clima.jar

# Exponer el puerto por el que se comunicará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "clima.jar"]