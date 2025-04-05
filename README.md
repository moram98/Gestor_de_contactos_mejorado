# Gestor de Contactos

## Descripción

El **Gestor de Contactos** es una aplicación desarrollada en **Java con Spring Boot**, diseñada para administrar una lista de contactos de manera eficiente. Permite a los usuarios agregar, listar, actualizar y eliminar contactos mediante una interfaz en consola y una API REST.

## Características

- 📌 **Agregar contactos** con nombre, correo electrónico y número de teléfono.
- 🔍 **Listar todos los contactos** almacenados en la base de datos.
- ✏️ **Actualizar contactos** por ID.
- 🗑 **Eliminar contactos** por ID.
- 🗄 **Persistencia de datos** mediante MySQL.
- 📡 **API REST** con Spring Boot.
- 🖥 **Interfaz de usuario en consola**.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot** (Spring MVC, Spring Data JPA)
- **MySQL** (como base de datos relacional)
- **Hibernate** (para el manejo de la persistencia)
- **Maven** (gestión de dependencias)
- **Lombok** (para reducir código boilerplate)
- **Postman** (para pruebas de la API REST)

## Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/moram98/Gestor_de_contactos_mejorado.git
cd Gestor_de_contactos_mejorado
```

### 2. Configurar la base de datos

En el archivo **application.properties**, asegúrate de configurar correctamente los datos de tu base de datos MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_del_proyecto
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Ejecutar la aplicación

Compila y ejecuta el proyecto con el siguiente comando:

```bash
mvn spring-boot:run
```

### 4. Probar la API con Postman

La API expone los siguientes endpoints:

- **Listar contactos:** `GET http://localhost:8080/contactos`
- **Agregar contacto:** `POST http://localhost:8080/contactos`
- **Actualizar contacto:** `PUT http://localhost:8080/contactos/{id}`
- **Eliminar contacto:** `DELETE http://localhost:8080/contactos/{id}`

## Contribuciones

Si deseas mejorar este proyecto, ¡las contribuciones son bienvenidas! Puedes hacer un **fork** del repositorio, crear una rama con tu mejora y luego abrir un **pull request**.

## Autor

👤 **Maicol Mora**
📧 moram7992@gmail.com
🔗 https://www.linkedin.com/in/maicol-mora/


