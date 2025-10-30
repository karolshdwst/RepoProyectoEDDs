# RepoProyectoEDDs
Repositorio para el proyecto de Estructura de datos

## Sistema de Gestión de Notas con Undo/Redo

Este proyecto implementa un sistema de gestión de notas utilizando estructuras de datos fundamentales (listas enlazadas) con funcionalidad de deshacer/rehacer.

## 🚀 Inicio Rápido

### Compilar el proyecto:
```bash
cd ProyectoEDDs
mvn clean compile
```

### Ejecutar la aplicación:
```bash
java -cp target/classes org.example.Menu
```

## 📋 Características

- ✅ Crear notas con título y contenido
- ✅ Actualizar notas existentes
- ✅ Deshacer operaciones (eliminar última nota agregada)
- ✅ Rehacer operaciones previamente deshechas
- ✅ Ver historial completo de operaciones
- ✅ Listar todas las notas actuales
- ✅ Interfaz de consola interactiva

## 📁 Estructura del Proyecto

```
ProyectoEDDs/
└── src/main/java/org/example/
    ├── Nota.java    # Modelo de datos (nota con título y contenido)
    ├── Nodo.java    # Nodo de lista enlazada
    ├── Lista.java   # Lista enlazada con funcionalidad undo/redo
    └── Menu.java    # Interfaz de usuario en consola
```

## 📚 Documentación

- **[ARQUITECTURA.md](ARQUITECTURA.md)** - Explicación detallada de la arquitectura del sistema
- **[RESUMEN_CAMBIOS.md](RESUMEN_CAMBIOS.md)** - Resumen de los cambios implementados

## 🎯 Uso del Sistema

Al ejecutar la aplicación, verás un menú con las siguientes opciones:

1. **Agregar** - Crear una nueva nota
2. **Eliminar** - Deshacer la última acción
3. **Actualizar** - Modificar una nota existente
4. **Deshacer** - Deshacer la última operación
5. **Rehacer** - Rehacer una operación deshecha
6. **Log** - Ver historial de operaciones
7. **Imprimir** - Mostrar todas las notas
8. **Salir** - Salir del programa

## 🔧 Requisitos

- Java 17 o superior
- Maven 3.6 o superior

## 👨‍💻 Desarrollo

### Estructuras de Datos Utilizadas

- **Lista Enlazada Simple** - Para almacenar las notas
- **Pila (Stack)** - Para el historial de deshacer y rehacer
- **Clase Interna** - `Movimiento` para gestionar el historial

### Patrones de Diseño

- Separación de Responsabilidades (SRP)
- Estructura de Datos Enlazada
- Patrón Memento (simplificado)
- MVC (simplificado)
