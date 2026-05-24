
# Evaluación Parcial 2: Desarrollo FullStack 1 (DSY1103)
**Proyecto:** Arquitectura de Microservicios - Foro "Zero Grip Society"
**Estudiante:** Jeicov Julian Diaz Astorga (Desarrollo Individual)

---

## Descripción del Proyecto
Plataforma backend estructurada en microservicios para la comunidad automotriz "Zero Grip Society". El sistema gestiona usuarios, temas de discusión (hilos) y comentarios, utilizando persistencia real, reglas de negocio centralizadas y comunicación remota entre servicios.

##  Funcionalidades Implementadas
* **Estructura CSR:** Separación clara entre Controller, Service y Repository.
* **Persistencia Real (JPA/Hibernate):** Mapeo de entidades y generación automática de tablas.
* **Validaciones JSR 380:** Uso de `@Valid` en los DTOs para control de entradas.
* **Manejo Centralizado de Excepciones:** Uso de `@ControllerAdvice` para capturar errores y retornar JSON limpios (404, 400).
* **Comunicación Remota:** Integración de Feign Client para validación cruzada entre microservicios (ej: validar existencia de usuario antes de comentar).

---

##  PASOS PARA EJECUTAR EL PROYECTO

Para que el proyecto funcione correctamente en un entorno local, el docente debe seguir estos pasos en orden:

### Paso 1: Configurar la Base de Datos (XAMPP / MySQL)
El proyecto utiliza Hibernate (`ddl-auto=update`), por lo que **NO** se requiere ejecutar scripts de creación de tablas. Sin embargo, es **obligatorio crear las bases de datos vacías** en XAMPP antes de iniciar.

Abra su gestor MySQL (credenciales por defecto: root sin contraseña) y cree estas 6 bases de datos:
1. `foro_usuarios_db`
2. `foro_hilos_db`
3. `foro_comentarios_db`
4. `foro_categorias_db`
5. `foro_reacciones_db`
6. `foro_notificaciones_db`

### Paso 2: Levantar los Microservicios
Abra terminales independientes para cada carpeta del proyecto y ejecute los motores usando Maven. 
**Importante:** Respete los puertos definidos para que la comunicación mediante Feign Client funcione.

* **1. Microservicio de Usuarios** -> Puerto: **8081**
  `.\mvnw clean spring-boot:run`
* **2. Microservicio de Hilos** -> Puerto: **8082**
  `.\mvnw clean spring-boot:run`
* **3. Microservicio de Categorías** -> Puerto: **8083**
  `.\mvnw clean spring-boot:run`
* **4. Microservicio de Comentarios** -> Puerto: **8084**
  `.\mvnw clean spring-boot:run`
* **5. Microservicio de Reacciones** -> Puerto: **8085**
  `.\mvnw clean spring-boot:run`
* **6. Microservicio de Notificaciones** -> Puerto: **8086**
  `.\mvnw clean spring-boot:run`

### Paso 3: Endpoints de Prueba (Flujo de Comunicación)
Para probar la validación y comunicación remota (`ms-comentarios` validando en `ms-usuarios` y `ms-hilos`), envíe las siguientes peticiones POST en Postman:

**A. Crear un Usuario (Puerto 8081):**
```json
POST http://localhost:8081/api/usuarios
Body:
{
  "username": "Piloto_Prueba",
  "email": "piloto@correo.com",
  "password": "password123"
}
```

**B. Crear un Hilo (Puerto 8082):**
```json
POST http://localhost:8082/api/hilos
Body:
{
  "titulo": "Mejores rutas para derrapar en Colina",
  "contenido": "Compartan sus rutas favoritas para el Zero Grip Society",
  "usuarioId": 1,
  "categoriaId": 1
}
```

**C. Crear un Comentario (Puerto 8084) - Prueba Feign Client:**
```json
POST http://localhost:8084/api/comentarios
Body:
{
  "contenido": "¡Esa ruta de asfalto en Colina está brutal!",
  "usuarioId": 1,
  "hiloId": 1
}
```
