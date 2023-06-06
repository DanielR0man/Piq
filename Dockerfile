# Define la imagen base
FROM maven:3.8.4-openjdk-11-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias
RUN mvn dependency:go-offline -B

# Copia el resto del código fuente
COPY src ./src

# Compila la aplicación
RUN mvn package -DskipTests

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/Piquant-0.0.1-SNAPSHOT.jar"]
