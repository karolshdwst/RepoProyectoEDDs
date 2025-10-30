# RepoProyectoEDDs
Repositorio para el proyecto de Estructura de datos

## 📋 Requisitos Previos

Para ejecutar este proyecto necesitas tener instalado:

1. **Java JDK 17 o superior**
   - Verificar instalación: `java -version`
   - Descargar desde: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

2. **Maven 3.6 o superior**
   - Verificar instalación: `mvn -version`
   - Descargar desde: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

## 🚀 Cómo ejecutar el proyecto

### Opción 1: Usando Maven

```bash
# 1. Clonar el repositorio
git clone <url-del-repositorio>
cd RepoProyectoEDDs/ProyectoEDDs

# 2. Compilar el proyecto
mvn clean compile

# 3. Ejecutar el programa
mvn exec:java -Dexec.mainClass="org.example.Menu"
```

### Opción 2: Usando Java directamente

```bash
# 1. Clonar el repositorio
git clone <url-del-repositorio>
cd RepoProyectoEDDs/ProyectoEDDs

# 2. Compilar
mvn clean compile

# 3. Ejecutar
java -cp target/classes org.example.Menu
```

### Opción 3: Desde un IDE (IntelliJ IDEA, Eclipse, VS Code)

1. Abrir el proyecto en tu IDE
2. Esperar a que Maven descargue las dependencias
3. Ejecutar la clase `Menu.java` (clic derecho → Run)

## 📖 Funcionalidades del Proyecto

El proyecto implementa una lista enlazada de notas con las siguientes funcionalidades:

- **[1] Agregar** - Agrega nuevas notas con título y contenido
- **[2] Eliminar** - Elimina una nota por su título
- **[3] Actualizar** - Modifica el contenido de una nota existente por su título
- **[4] Deshacer** - Deshace la última operación (agregar o eliminar)
- **[5] Rehacer** - Rehace una operación previamente deshecha
- **[6] Log** - Muestra la cantidad de notas en la lista
- **[7] Imprimir** - Muestra todas las notas con su título y contenido
- **[8] Salir** - Cierra el programa

### 📝 Estructura de una Nota
Cada nota contiene:
- **Título**: Identificador único de la nota
- **Contenido**: Texto o descripción de la nota

## 📁 Estructura del Proyecto

```
ProyectoEDDs/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Lista.java    # Estructura de datos principal
│                   ├── Menu.java     # Interfaz de usuario
│                   ├── Nodo.java     # Nodo de la lista
│                   └── Nota.java     # Clase de datos
└── pom.xml                           # Configuración de Maven
```

## 🛠️ Solución de Problemas

### Error: "invalid target release"
- Asegúrate de tener Java 17 o superior instalado
- Verifica la configuración en `pom.xml`

### Error: "mvn: command not found"
- Maven no está instalado o no está en el PATH
- Instala Maven y configura las variables de entorno

### El programa no compila
- Ejecuta: `mvn clean install`
- Verifica que estés en la carpeta `ProyectoEDDs/`

