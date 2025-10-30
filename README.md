# RepoProyectoEDDs
Repositorio para el proyecto de Estructura de datos

## 📋 Requisitos Previos

Para ejecutar este proyecto necesitas tener instalado:

1. **Java JDK 17 o superior**
   - Verificar instalación: `java -version`
   - Asegúrate de que `JAVA_HOME` esté configurado y que `java` esté en el `PATH`.

2. **Maven 3.6 o superior**
   - Verificar instalación: `mvn -version`
   - Asegúrate de que `mvn` esté en el `PATH`.

> Nota: Si usas un administrador de paquetes (sdkman, apt, brew, etc.) puedes instalar JDK y Maven desde ahí.

## 🚀 Cómo ejecutar el proyecto por terminal

A continuación se muestran pasos mínimos y reproducibles para compilar y ejecutar la clase principal `org.example.Menu` desde la terminal.

1) Clonar el repositorio (reemplaza `<url-del-repositorio>` por la URL real):

```bash
git clone <url-del-repositorio>
cd RepoProyectoEDDs/ProyectoEDDs
```

2) Compilar el proyecto con Maven:

```bash
mvn clean compile
```

3a) Ejecutar usando el plugin de Maven (`mvn exec`):

```bash
mvn -Dexec.mainClass="org.example.Menu" exec:java
```

3b) (Alternativa) Ejecutar la clase directamente con `java` usando el classpath compilado:

```bash
java -cp target/classes org.example.Menu
```

Ambas opciones lanzarán la clase `Menu` que contiene el método `main`.

## ✅ Comprobaciones rápidas si algo falla

- Si al compilar obtienes errores relacionados con la versión de Java (ej. "invalid target release"), verifica `java -version` y la configuración del `pom.xml`.
- Si `mvn` no se encuentra, instala Maven o añade su binario al `PATH`.
- Asegúrate de ejecutar los comandos desde la carpeta `ProyectoEDDs/` (o ajusta la ruta si trabajas desde otra carpeta).

## 📝 Funcionalidades del Proyecto (Notas)

El proyecto gestiona una lista de notas con las siguientes opciones en el menú:

- [1] Agregar - Agrega una nota (Título y Contenido)
- [2] Eliminar - Elimina una nota por título
- [3] Actualizar - Actualiza el contenido de una nota por título
- [4] Deshacer - Deshace la última operación
- [5] Rehacer - Rehace la última operación
- [6] Log - Muestra la cantidad de notas
- [7] Imprimir - Imprime todas las notas
- [8] Salir - Termina el programa

> Observación: Las notas contienen solo título y contenido (no hay campo "precio" en la entidad `Nota`).

## 📁 Estructura del Proyecto

```
ProyectoEDDs/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Lista.java
│                   ├── Menu.java
│                   ├── Nodo.java
│                   └── Nota.java
└── pom.xml
```

## 🛠️ Solución de Problemas

### Mensajes comunes

- "invalid target release": usa una versión de JDK compatible con la configuración de `pom.xml`.
- "mvn: command not found": instala Maven y añade al `PATH`.
- Errores de compilación Java: ejecuta `mvn clean compile` y revisa las trazas para identificar el archivo y la línea.

### Ejecutar desde un IDE

Si prefieren un IDE (IntelliJ IDEA, Eclipse o VS Code):

1. Abrir la carpeta `ProyectoEDDs` como proyecto Maven.
2. Esperar a que Maven resuelva dependencias.
3. Ejecutar la clase `org.example.Menu` desde la configuración de ejecución del IDE.

---

Si quieres, puedo añadir un pequeño script `run.sh` o un `Makefile` para simplificar estos pasos. También puedo validar la compilación del proyecto aquí si deseas que lo haga ahora.
