# CRUD REST API con Jakarta EE, WildFly e IBM DB2

Aplicación backend desarrollada bajo una arquitectura limpia (Clean Architecture / Separación de Capas), utilizando los estándares empresariales de **Jakarta EE**, 
desplegada en un servidor de aplicaciones **WildFly** y conectada a una base de datos **IBM DB2**.


📋 Descripción del Proyecto
Este proyecto implementa una API REST completa (CRUD: Create, Read, Update, Delete) para la gestión de Profesores. Se diseñó siguiendo los principios modernos de desarrollo corporativo:

Desacoplamiento total mediante interfaces de servicio.

Inyección de dependencias estándar con CDI (@ApplicationScoped, @Inject).

Persistencia robusta con Jakarta Persistence (JPA / Hibernate) y manejo de transacciones.

Mapeo explícito a DTOs para proteger las entidades de base de datos y optimizar la transferencia de datos.

🛠️ Tecnologías y Stack
Java 17+ (o compatible con Jakarta EE 10)

Jakarta EE 10 (JAX-RS, CDI, JPA, Transactions)

Servidor de Aplicaciones: WildFly 41.0.1.Final

Base de Datos: IBM DB2 11.5.8.0 (Ejecutándose en contenedor Docker)

Herramientas: Eclipse IDE, Maven, Postman, DBeaver

🏛️ Arquitectura del Proyecto
El código está organizado en capas claramente diferenciadas para garantizar la mantenibilidad:

com.tuproyecto
 ├── entity/        # Entidades JPA mapeadas a la BD (ej. Profesor.java)
 ├── dto/           # Objetos de transferencia de datos (ej. ProfesorDTO.java)
 ├── repository/    # Capa de acceso a datos / DAO usando EntityManager (@PersistenceContext)
 ├── service/       # Lógica de negocio (Interfaz + Implementación con @ApplicationScoped)
 └── rest / ws/     # Controladores / Endpoints REST expuestos con JAX-RS (@Path)

⚙️ Requisitos Previos (Prerrequisitos)
Tener instalado Docker y levantado el contenedor de IBM DB2.

Servidor WildFly configurado e integrado en el IDE (Eclipse Server View).

Un pool de conexiones configurado en WildFly (standalone.xml) apuntando a la base de datos DB2 con el JNDI correspondiente (ej. java:/jdbc/MiProyectoDS).

La unidad de persistencia configurada en el archivo persistence.xml (unitName = "MiProyectoPU").

🚀 Guía de Puesta en Marcha (Cómo Levantar el Proyecto)
Clonar o abrir el proyecto en tu IDE (Eclipse).

Verificar la Base de Datos: Asegúrate de que el contenedor Docker de IBM DB2 esté activo y que la tabla Profesor exista y sea accesible (puedes verificarlo con DBeaver).

Desplegar en el Servidor:

En la pestaña Servers de Eclipse, selecciona tu instancia de WildFly.

Haz clic derecho sobre el servidor y selecciona Add and Remove....

Añade tu proyecto (MiProyecto) a la lista de recursos desplegados y pulsa Finish.

Inicia o reinicia el servidor (Start / Restart).

Verificar el despliegue: Revisa la consola de WildFly para confirmar que el pool de conexiones se enlazó correctamente y que no hay errores de JPA.

🔌 Endpoints de la API REST
La base URL de tus endpoints dependerá del contexto de tu aplicación configurado en WildFly (por ejemplo: http://localhost:8080/nombre-proyecto/api/...).

💡 Decisiones de Diseño Clave
Inyección por Constructor: Se prefirió la inyección de dependencias mediante constructores anotados con @Inject en lugar de inyección por campos (@Inject directo en atributos), facilitando las pruebas unitarias y la inmutabilidad.

Mapeo Manual con Streams: Uso de la API de Streams de Java para transformar entidades JPA a DTOs de manera limpia y ligera sin depender de librerías externas pesadas de mapeo.

¡Cópialo, guárdalo en tu repositorio y que tengas muchísima suerte en la entrevista de las 10:00! Estás súper preparado. ¡A por todas! 🚀🍀


## 🚀 Guía Rápida: Endpoints y Prácticas Java (Jakarta EE)

### 1. Endpoints Principales (JAX-RS)
- **Recurso Profesores:** `@Path("/profesores")`
- **URL Base de Pruebas (GET):**
  ```text
  http://localhost:9090/mi-proyecto-jakarta/api/profesores
  
  
 -- Ejemplo con cURL:

curl -X GET http://localhost:9090/mi-proyecto-jakarta/api/profesores \
     -H "Accept: application/json"
     
----------------------------
Buscar un archivo con powershell: ProfesorResource.java
-- SOLO EN TU USUARIO
Get-ChildItem -Path "$env:USERPROFILE" -Filter "ProfesorResource.java" -Recurse -ErrorAction SilentlyContinue | Select-Object FullName

abrir:

explorer C:\Users\Rolando\eclipse-workspace\mi-proyecto-jakarta

-- TODO EL DISCO DURA MAS
Get-ChildItem -Path C:\ -Filter "ProfesorResource.java" -Recurse -ErrorAction SilentlyContinue | Select-Object FullName


----------------------------
# 1. Limpia y descarta los cambios locales
Esto borrará los cambios temporales de configuración que generó tu editor y que están bloqueando el proceso:
bash
# 1. Descarta las modificaciones de los archivos rastreados
git checkout -- .project target/

# 2. Elimina el archivo no rastreado (.checkstyle)
git clean -df
Usa el código con precaución.
2. Baja los cambios del servidor
Una vez que tu espacio de trabajo esté limpio, ya puedes actualizar tu proyecto sin problemas:
bash
git pull
Usa el código con precaución.
💡 Un consejo para el futuro
Para que esto no te vuelva a pasar cada vez que compiles tu proyecto, te recomiendo crear o editar el archivo llamado .gitignore en la raíz de tu proyecto y añadir estas líneas para que Git ignore siempre los archivos temporales de Eclipse y Maven:
text
/target/
.project
.classpath
.settings/
.checkstyle

----------------------------

1. Elimina la carpeta del control de Git (pero mantenla en tu disco duro)
bash
>git rm -r --cached target/
>git rm -r --cached .settings/ .checkstyle .classpath .project

(El parámetro --cached es la clave aquí: le dice a Git que deje de rastrear la carpeta en el repositorio, pero no tocará tus archivos locales).
2. Confirma y sube el cambio al servidor
bash
>git commit -m "Remover carpeta target del repositorio y aplicar gitignore"
>git push origin main

----------------------------


----------------------------


