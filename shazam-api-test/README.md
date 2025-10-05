
# 🎧 Shazam API Test – Serenity BDD + Screenplay + Cucumber + RestAssured

## 🧩 Descripción del Proyecto

Este proyecto automatiza la validación de los endpoints públicos de la **API de Shazam (RapidAPI)** utilizando **Serenity BDD**, **Cucumber** y el **patrón Screenplay**.  
Permite validar detalles de canciones a partir de su ID y detectar temas musicales usando archivos de audio.

El objetivo principal es ofrecer una base sólida, escalable y mantenible para la **automatización de pruebas de servicios REST**, siguiendo **principios SOLID** y **buenas prácticas de ingeniería de software**.


## 🧱 Arquitectura del Proyecto

La estructura del proyecto sigue el estándar Serenity Screenplay Pattern, dividiendo responsabilidades claramente:


shazam-api-test
│
├── src/main/java/com/rappipay/api
│   ├── models/                # Modelos de respuesta (POJOs)
│   ├── questions/             # Validaciones y aserciones
│   ├── tasks/                 # Interacciones (GET, POST)
│   ├── utils/                 # Constantes y cabeceras comunes
│
├── src/test/java/com/rappipay/api
│   ├── runners/               # Clase Runner de ejecución
│   └── stepdefinitions/       # Hooks y definición de pasos Cucumber
│
├── src/test/resources/
│   ├── features/              # Escenarios BDD (.feature)
│   └── audio/                 # Archivos de prueba (MP3)
│
├── pom.xml                    # Configuración de dependencias y plugins Maven
├── Dockerfile                 # Imagen Docker lista para ejecución en Jenkins
├── serenity.properties        # Configuración Serenity
└── README.md




## 🚀 Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|-------------|----------|-------------|
| ☕ Java | 11 | Lenguaje base del proyecto |
| 🧩 Maven | 3.8+ | Gestor de dependencias y build |
| 🧠 Serenity BDD | 3.9.8 | Framework para reportes y Screenplay |
| 🥒 Cucumber | 7.11.2 | Framework BDD |
| 🌐 RestAssured | Incluido | Pruebas REST API |
| 🧱 Jenkins | LTS JDK 11 | CI/CD para ejecución continua |
| 🐳 Docker | Latest | Contenedor de ejecución reproducible |




## 📦 Instalación y Ejecución Local
1️⃣ Clonar el repositorio
git clone https://github.com/1juanda/shazam-api-test.git
cd shazam-api-test

2️⃣ Instalar dependencias

mvn clean install -DskipTests

3️⃣ Ejecutar pruebas con tag específico

mvn clean verify -Dtags="@song"


4️⃣ Generar y visualizar reporte Serenity

Una vez finalizada la ejecución, abre el reporte:
target/site/serenity/index.html


## 🐳 Ejecución con Docker

1️⃣ Construir la imagen
docker build -t serenity-jenkins-tests .

2️⃣ Ejecutar el contenedor
docker run --rm serenity-jenkins-tests

Esto ejecutará automáticamente los escenarios definidos con el tag @song.

## ⚙️ Integración con Jenkins

El proyecto está diseñado para ejecutarse dentro de Jenkins usando la imagen oficial con JDK 11.
El Dockerfile instala Maven y Git, copia el código al contenedor y ejecuta las pruebas automáticamente.

## 🧠 Aplicación de Principios SOLID

Este proyecto sigue los principios SOLID, adaptados al contexto de automatización con Serenity BDD y Screenplay:

Principio	Implementación en el Proyecto
Single Responsibility	Cada clase tiene una única responsabilidad:
- Tasks manejan las acciones de API.
- Questions validan respuestas.
- StepDefinitions conectan los pasos del feature con el modelo Screenplay.
Open/Closed	Las clases están abiertas a extensión pero cerradas a modificación. Por ejemplo, se pueden agregar nuevos Tasks sin modificar los existentes.
Liskov Substitution	Los Actors y sus Tasks pueden ser intercambiables sin romper la funcionalidad, cumpliendo contratos esperados.
Interface Segregation	Las responsabilidades están divididas por capas claras (tasks, questions, utils), evitando dependencias innecesarias.
Dependency Inversion	El framework Serenity maneja la inversión de dependencias, permitiendo definir comportamiento a través de abstracciones (Task, Question, Ability).

✅ Esto garantiza un código limpio, escalable, y fácil de mantener.


## 🧠 Decisiones de Diseño y Arquitectura

Patrón Screenplay:
Se eligió para mejorar la legibilidad, mantenibilidad y reutilización del código.
Los actores (Actor) ejecutan tareas (Tasks) y formulan preguntas (Questions).

Separación de responsabilidades:
tasks: encapsulan las llamadas HTTP.
questions: validan las respuestas.
stepdefinitions: traducen los pasos BDD a acciones del actor.
utils: centraliza configuraciones y cabeceras comunes.

Uso de Serenity Screenplay Rest:
Permite integrar RestAssured de forma fluida con Screenplay.

Integración continua:
El uso de Docker y Jenkins asegura un entorno reproducible y portable.

## 💡 Buenas Prácticas

Aplicar nombres semánticos en los Tasks y Questions.
Mantener independencia entre escenarios.
Usar Hooks para inicialización de actores y configuración base.
Centralizar endpoints y cabeceras en clases utilitarias (ApiConstants, ApiHeaders).
Evitar duplicación de código usando reutilización de Tasks y Questions.

## 🗂️ Dependencias Clave (pom.xml)

serenity-core

serenity-screenplay

serenity-screenplay-rest

serenity-cucumber

json-path

## 📊 Reporte de Resultados

Serenity genera automáticamente un reporte HTML completo con:

Escenarios ejecutados y su estado.

Evidencias de solicitudes y respuestas HTTP.

Resumen de pruebas fallidas/exitosas.

Ubicación:

target/site/serenity/index.html

## ✉️ Contacto
Autor: Juan
Proyecto: Shazam API Test (RappiPay – Automatización API)