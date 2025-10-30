# Arquitectura del Sistema de Gestión de Notas

## Descripción General

Este proyecto implementa un **Sistema de Gestión de Notas con funcionalidad de Deshacer/Rehacer** utilizando estructuras de datos fundamentales como listas enlazadas. El sistema está diseñado con una arquitectura modular donde cada clase tiene una responsabilidad específica.

## Estructura del Proyecto

El proyecto está compuesto por **4 archivos principales**, cada uno con una función específica:

### 1. `Nota.java` - Modelo de Datos
**Propósito:** Representa una nota individual con título y contenido.

**Características:**
- Clase simple de datos (POJO - Plain Old Java Object)
- Dos atributos: `titulo` y `nota` (contenido)
- Método `toString()` personalizado para mostrar la nota formateada

**Analogía:** Es como una tarjeta de nota física con un título y contenido escrito.

```java
Nota nota = new Nota("Título", "Contenido");
```

### 2. `Nodo.java` - Nodo de Lista Enlazada
**Propósito:** Representa un nodo en la estructura de lista enlazada que contiene una nota.

**Características:**
- Contiene una referencia a un objeto `Nota` (dato)
- Contiene una referencia al siguiente nodo (`sig`)
- Implementa el patrón de nodo básico de lista enlazada simple

**Analogía:** Es como un eslabón en una cadena, donde cada eslabón contiene una nota y apunta al siguiente eslabón.

```java
Nodo nodo = new Nodo(nota);
```

### 3. `Lista.java` - Estructura de Datos Principal
**Propósito:** Implementa una lista enlazada con funcionalidad de deshacer/rehacer.

**Características:**
- **Atributos principales:**
  - `primero`: Referencia al primer nodo de la lista
  - `ultimo`: Referencia al último nodo de la lista
  - `longitud`: Contador de elementos en la lista
  - `desh`: Pila de movimientos para deshacer
  - `reha`: Pila de movimientos para rehacer

- **Clase interna `Movimiento`:**
  - Representa un historial de acciones realizadas
  - Implementa una pila para el historial de deshacer/rehacer
  - Cada movimiento guarda una referencia al nodo afectado

- **Operaciones principales:**
  - `agregar(Nodo)`: Agrega un nodo al inicio de la lista y registra la acción
  - `actualizar(int, Nota)`: Actualiza una nota existente por posición
  - `actualizar(Nodo, Nota)`: Actualiza una nota existente por referencia
  - `deshacer()`: Deshace la última acción, moviendo el nodo de la lista al historial de rehacer
  - `rehacer()`: Rehace la última acción deshecha, restaurando el nodo a la lista

**Analogía:** Es como un cuaderno de notas con páginas (nodos) donde puedes escribir, borrar, y usar botones de "deshacer" y "rehacer" como en un editor de texto.

**Nota importante:** La implementación actual de deshacer/rehacer solo funciona con la operación `agregar()`. Las operaciones de actualización no se registran en el historial.

### 4. `Menu.java` - Interfaz de Usuario
**Propósito:** Proporciona una interfaz de consola interactiva para que el usuario interactúe con el sistema.

**Características:**
- Mantiene una instancia de `Lista` como variable estática
- Proporciona un menú con 8 opciones:
  1. **Agregar**: Crear y agregar una nueva nota
  2. **Eliminar**: Deshacer la última acción (elimina la última nota agregada)
  3. **Actualizar**: Modificar una nota existente
  4. **Deshacer**: Deshacer la última acción
  5. **Rehacer**: Rehacer la última acción deshecha
  6. **Log**: Mostrar historial de deshacer y rehacer
  7. **Imprimir**: Mostrar todas las notas actuales
  8. **Salir**: Terminar el programa

**Analogía:** Es como la interfaz gráfica de una aplicación, pero en modo texto.

## Flujo de Datos

```
Usuario → Menu → Lista → Nodo → Nota
         ↑      ↓
         └──────┘
       (Interacción)
```

1. El usuario interactúa con `Menu`
2. `Menu` ejecuta operaciones en `Lista`
3. `Lista` manipula objetos `Nodo`
4. Cada `Nodo` contiene una `Nota`

## Diseño de la Funcionalidad Deshacer/Rehacer

El sistema implementa una arquitectura de **doble pila** para gestionar el historial:

```
Lista Principal: [Nota2] → [Nota1] → null
                    ↑
                 primero

Historial Deshacer: [Mov2] → [Mov1] → null
                      ↑
                    desh

Historial Rehacer: [Mov3] → null
                     ↑
                   reha
```

**Flujo de Deshacer:**
1. Se toma el primer movimiento de la pila de deshacer
2. Se busca y elimina el nodo correspondiente de la lista principal
3. Se mueve el movimiento a la pila de rehacer

**Flujo de Rehacer:**
1. Se toma el primer movimiento de la pila de rehacer
2. Se reinserta el nodo al inicio de la lista principal
3. Se mueve el movimiento de vuelta a la pila de deshacer

## Patrones de Diseño Utilizados

1. **Separación de Responsabilidades (SRP):**
   - Cada clase tiene una única responsabilidad bien definida

2. **Estructura de Datos Enlazada:**
   - Uso de nodos con referencias para crear estructuras dinámicas

3. **Patrón Memento (simplificado):**
   - El historial de movimientos actúa como un memento del estado

4. **MVC (simplificado):**
   - `Nota`: Modelo (datos)
   - `Menu`: Vista/Controlador (interfaz y lógica de control)
   - `Lista`: Modelo (lógica de negocio)

## Cómo Ejecutar el Proyecto

### Compilar:
```bash
cd ProyectoEDDs
mvn clean compile
```

### Ejecutar:
```bash
java -cp target/classes org.example.Menu
```

## Evolución del Proyecto

Este proyecto probablemente evolucionó de la siguiente manera:

1. **Versión inicial:** Todo el código podría haber estado en un solo archivo `Lista.java`
2. **Refactorización:** Se separó en múltiples archivos para mejor organización:
   - Se extrajo la clase `Nota` como un POJO independiente
   - Se extrajo la clase `Nodo` para representar el nodo de lista
   - Se mantuvo `Lista` con la lógica principal y la clase interna `Movimiento`
   - Se creó `Menu` como interfaz de usuario separada

## Ventajas de la Arquitectura Actual

1. **Modularidad:** Cada clase tiene una función específica
2. **Reutilizabilidad:** Las clases `Nota` y `Nodo` pueden usarse en otros contextos
3. **Mantenibilidad:** Es más fácil modificar una clase sin afectar las demás
4. **Legibilidad:** El código está organizado de forma lógica
5. **Testabilidad:** Cada componente puede probarse independientemente

## Posibles Mejoras Futuras

1. Agregar persistencia (guardar/cargar notas de archivo)
2. Implementar historial de deshacer/rehacer para operaciones de actualización
3. Agregar búsqueda de notas
4. Implementar ordenamiento de notas
5. Agregar categorías o etiquetas a las notas
6. Crear una interfaz gráfica (GUI)
7. Agregar validación de entrada más robusta
8. Implementar pruebas unitarias
