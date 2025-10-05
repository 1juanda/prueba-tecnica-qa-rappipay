# Usamos la imagen oficial de Jenkins con JDK 11
FROM jenkins/jenkins:lts-jdk11

# Cambiamos a root para instalar paquetes
USER root

# Instalamos Maven y utilidades necesarias
RUN apt-get update && apt-get install -y maven git && apt-get clean

# Cambiamos al usuario jenkins para mantener buenas prácticas
USER jenkins

# Creamos directorio para el workspace y copiamos el proyecto
WORKDIR /home/jenkins/workspace/serenity-tests
COPY --chown=jenkins:jenkins . .

# Comando para ejecutar las pruebas automáticamente con tags
CMD ["mvn", "clean", "verify", "-Dtags=@song"]