📚 ManagerLibraryAPI

API REST para la gestión de autores y libros

ManagerLibraryAPI es una aplicación backend desarrollada con el objetivo de ofrecer un conjunto de endpoints para administrar autores y libros dentro de una biblioteca digital.
Permite registrar, consultar, actualizar y eliminar información, manteniendo relaciones entre entidades mediante un modelo claro y bien estructurado.

🚀 Tecnologías utilizadas

El proyecto está construido sobre un stack moderno y robusto:

Java 17+

Spring Boot (Spring Web, Spring Data JPA)

PostgreSQL

JPA / Hibernate

Postman (Testing e intercambio de colecciones)

📁 Arquitectura y características principales

✔ Estructura basada en capas: Controller, Service, Repository, DTOs, Mappers
✔ Manejo de entidades relacionadas (Autor ↔ Libros)
✔ DTOs de Request y Response para aislar la capa de dominio
✔ Validaciones y excepciones personalizadas
✔ Uso de PostgreSQL como base de datos principal
✔ Documentación mediante colección de Postman

🛠 Requisitos previos

Antes de ejecutar el proyecto, necesitas tener instalado:

Java 17+

Maven 3.9+

PostgreSQL

Un cliente para probar la API (Postman recomendado)

⚙️ Configuración del archivo application.properties

Ejemplo básico:

spring.datasource.url=jdbc:postgresql://localhost:5432/managerlibrary
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

▶️ Cómo ejecutar el proyecto
# 1. Clonar el repositorio
git clone https://github.com/usuario/ManagerLibraryAPI.git

# 2. Entrar al proyecto
cd ManagerLibraryAPI

# 3. Compilar y ejecutar
mvn spring-boot:run


El servidor se inicia por defecto en:

http://localhost:8080

📌 Endpoints principales
👤 Autores
Método	Endpoint	Descripción
GET	/api/autores	Listar todos los autores
GET	/api/autores/{id}	Obtener autor por ID
POST	/api/autores	Crear nuevo autor
PUT	/api/autores/{id}	Actualizar autor
DELETE	/api/autores/{id}	Eliminar autor
📘 Libros
Método	Endpoint	Descripción
GET	/api/libros	Listar todos los libros
GET	/api/libros/{id}	Obtener libro por ID
POST	/api/libros	Registrar nuevo libro
PUT	/api/libros/{id}	Actualizar datos de un libro
DELETE	/api/libros/{id}	Eliminar libro
📮 Colección de Postman (para pruebas)

Puedes importar la colección desde el siguiente enlace:

🔗 Colección Postman:
https://.postman.co/workspace/My-Workspace~45e43616-8ae8-4231-8d31-9f3f08e6e623/collection/40057621-dfa0128b-e4f4-4ed5-a6fe-ab044ce5ea3e?action=share&creator=40057621

Incluye todas las peticiones necesarias para probar la API, con ejemplos de request y response.

🧱 Modelo de Datos
Autor

id

name

nationality

List<Libro> libros

Libro

id

title

genre

stock

Autor autor

📄 Licencia

Este proyecto es de uso libre para fines educativos y profesionales.
