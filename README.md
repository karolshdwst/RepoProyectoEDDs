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

## 🖥️ Cómo ejecutar en Visual Studio Code (Windows)

A continuación se describen pasos concretos para abrir, compilar y ejecutar este proyecto Maven en VS Code en Windows.

Requisitos previos (resumen)

- Tener instalado JDK 17 (o la versión que indique el `pom.xml`) y Maven. Verifica con:

```cmd
java -version
mvn -version
```

- Extensiones recomendadas en VS Code:
  - Extension Pack for Java (incluye Language Support for Java y Debugger for Java)
  - Maven for Java
  - (Opcional) Java Test Runner

Pasos

1. Abrir VS Code y clonar/abrir el proyecto

   - Si aún no lo clonaste, desde una terminal (cmd) ejecuta:

```cmd
git clone <url-del-repositorio>
cd RepoProyectoEDDs\ProyectoEDDs
code .
```

   - O en VS Code: File > Open Folder... y selecciona la carpeta `ProyectoEDDs`.

2. Instalar/activar extensiones

   - Abre la vista de Extensiones (Ctrl+Shift+X) y busca "Extension Pack for Java" y "Maven for Java". Instálalas si no están.

3. Configurar JAVA_HOME (si aún no está configurado)

   - En Windows: Panel de Control > Sistema > Configuración avanzada del sistema > Variables de entorno.
   - Añade una variable de sistema `JAVA_HOME` con la ruta del JDK, por ejemplo `C:\Program Files\Java\jdk-17`.
   - Edita la variable `Path` y añade `%JAVA_HOME%\bin`.

   Alternativa (temporal para la terminal actual):

```cmd
set JAVA_HOME=C:\ruta\a\tu\jdk
set PATH=%JAVA_HOME%\bin;%PATH%
```

   - Si VS Code no detecta el JDK, en la configuración de usuario (`settings.json`) puedes añadir (no es lo más común):

```json
"java.home": "C:\\Program Files\\Java\\jdk-17"
```

4. Esperar a que VS Code resuelva el proyecto

   - Al abrir la carpeta, la extensión Java detectará el proyecto Maven y descargará dependencias.
   - Observa la esquina inferior derecha o la vista "Java Projects / Maven Projects" para el progreso.

5. Compilar el proyecto

   - Desde la terminal integrada (View > Terminal) ejecuta:

```cmd
mvn clean compile
```

   - O usa la extensión Maven: en la vista "Maven Projects" expande `ProyectoEDDs` → Lifecycle → `compile` y haz clic derecho > Run.

6. Ejecutar la clase `Menu` (tres opciones)

   Opción A — Ejecutar desde el editor:
   - Abre `src/main/java/org/example/Menu.java`.
   - Verás un icono "Run" o "Run|Debug" arriba del método `main`; haz clic en "Run Java".

   Opción B — Ejecutar desde la vista "Java Projects":
   - En "Java Projects" o "Run" busca la clase `org.example.Menu` y usa la opción de ejecutar.

   Opción C — Usar Maven Exec (terminal):

```cmd
mvn -Dexec.mainClass="org.example.Menu" exec:java
```

   Opción D — Ejecutar usando clases compiladas:

```cmd
java -cp target\classes org.example.Menu
```

7. Depuración

   - Pon breakpoints en el código (clic en el margen izquierdo) y presiona F5 o usa "Run and Debug".
   - VS Code usará la configuración por defecto para depurar aplicaciones Java.

8. Problemas comunes

- VS Code no detecta el JDK: revisa `JAVA_HOME` y la configuración `java.home` si la usaste.
- `mvn` no encontrado: añade Maven al PATH o instala Maven.
- Error "invalid target release": la versión del JDK instalado no coincide con la configurada en `pom.xml`.
- Si la extensión muestra errores al inicio, espera a que termine la indexación y reconstruye: `mvn clean compile`.

Ejemplo rápido (comandos para la terminal cmd):

```cmd
cd RepoProyectoEDDs\ProyectoEDDs
mvn clean compile
mvn -Dexec.mainClass="org.example.Menu" exec:java
```

Con esto deberías poder abrir, compilar y ejecutar el proyecto desde VS Code en Windows.

---

Si quieres, puedo añadir un pequeño script `run.sh` o un `Makefile` para simplificar estos pasos. También puedo validar la compilación del proyecto aquí si deseas que lo haga ahora.
