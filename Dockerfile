# Define la imagen base
FROM maven:3.8.4-openjdk-11-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias
RUN mvn dependency:go-offline -B


COPY src ./src
RUN mvn package -DskipTests

# Extrae el código fuente del JAR en el directorio de trabajo
RUN mkdir extracted && \
    cd extracted && \
    jar -xf ../target/Piquant-0.0.1-SNAPSHOT.jar && \
    mv META-INF ../ && \
    cd .. && \
    rm -rf extracted

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/Piquant-0.0.1-SNAPSHOT.jar"]

