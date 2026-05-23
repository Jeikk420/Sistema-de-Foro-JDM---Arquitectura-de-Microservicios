
# Sistema de Foro JDM - Arquitectura de Microservicios

## Descripción del Proyecto
Este proyecto es una plataforma de foro desarrollada mediante una **arquitectura de microservicios** desacoplados. El sistema está diseñado para ofrecer alta escalabilidad, modularidad y facilidad de mantenimiento, cumpliendo con los estándares de desarrollo de software moderno.

El sistema gestiona de forma independiente la información de usuarios, discusiones, categorías y notificaciones, permitiendo una comunicación eficiente entre componentes.

## Arquitectura del Sistema
El proyecto se divide en 6 microservicios independientes:

1. **ms-usuarios**: Gestión y autenticación de cuentas de usuario.
2. **ms-hilos**: Administración de los temas principales de discusión.
3. **ms-categorias**: Organización temática de los hilos del foro.
4. **ms-comentarios**: Gestión de las respuestas dentro de los hilos.
5. **ms-reacciones**: Sistema de interacción de los usuarios (likes/dislikes).
6. **ms-notificaciones**: Envío de alertas y actualizaciones para los usuarios.

## Tecnologías Utilizadas
- **Lenguaje**: Java 17+
- **Framework**: Spring Boot 3.x
- **Gestión de Dependencias**: Maven
- **Arquitectura**: Microservicios con REST API y Feign Clients
- **Calidad de Código**: Implementación de `GlobalExceptionHandler` para el manejo centralizado de excepciones (respuestas 404/400 uniformes).

## Guía de Instalación y Ejecución

### Prerrequisitos
- Java JDK 17 o superior instalado.
- Maven instalado.
- Base de datos configurada (ej. MySQL/H2).

### Ejecución
Para levantar cada microservicio, navega a la carpeta correspondiente en una terminal y ejecuta el siguiente comando:

```bash
./mvnw clean spring-boot:run
