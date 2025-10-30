package org.example;

import java.util.Scanner;

public class Menu {
    private static Lista lista = new Lista();
    
    public static void MostrarMenu() {
        System.out.println("----- Menú Principal -----");
        System.out.println("---Notas---");
        System.out.println("[1] Agregar");
        System.out.println("[2] Eliminar (Deshacer última acción)");
        System.out.println("[3] Actualizar");
        System.out.println("[4] Deshacer");
        System.out.println("[5] Rehacer");
        System.out.println("[6] Log");
        System.out.println("[7] Imprimir");
        System.out.println("[8] Salir");
        System.out.println("--------------------------");
    }
    
    public static void agregarNota(Scanner scanner) {
        System.out.print("Ingrese el título de la nota: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el contenido de la nota: ");
        String contenido = scanner.nextLine();
        
        Nota nota = new Nota(titulo, contenido);
        Nodo nodo = new Nodo(nota);
        lista.agregar(nodo);
        
        System.out.println("✓ Nota agregada exitosamente.");
    }
    
    public static void actualizarNota(Scanner scanner) {
        if (lista.longitud == 0) {
            System.out.println("No hay notas para actualizar.");
            return;
        }
        
        System.out.println("Notas disponibles:");
        imprimirLista();
        
        System.out.print("Ingrese el número de la nota a actualizar (0-" + (lista.longitud - 1) + "): ");
        String line = scanner.nextLine().trim();
        int posicion;
        try {
            posicion = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida.");
            return;
        }
        
        if (posicion < 0 || posicion >= lista.longitud) {
            System.out.println("Posición inválida.");
            return;
        }
        
        System.out.print("Ingrese el nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nuevo contenido: ");
        String contenido = scanner.nextLine();
        
        Nota nuevaNota = new Nota(titulo, contenido);
        if (lista.actualizar(posicion, nuevaNota)) {
            System.out.println("✓ Nota actualizada exitosamente.");
        } else {
            System.out.println("✗ Error al actualizar la nota.");
        }
    }
    
    public static void deshacerAccion() {
        if (lista.deshacer()) {
            System.out.println("✓ Acción deshecha exitosamente.");
        } else {
            System.out.println("✗ No hay acciones para deshacer.");
        }
    }
    
    public static void rehacerAccion() {
        if (lista.rehacer()) {
            System.out.println("✓ Acción rehecha exitosamente.");
        } else {
            System.out.println("✗ No hay acciones para rehacer.");
        }
    }
    
    public static void mostrarLog() {
        System.out.println("\n===== HISTORIAL DE DESHACER =====");
        if (lista.desh == null) {
            System.out.println("No hay acciones en el historial de deshacer.");
        } else {
            Lista.Movimiento temp = lista.desh;
            int count = 1;
            while (temp != null) {
                System.out.println(count + ". " + temp.nodo.dato);
                temp = temp.sig;
                count++;
            }
        }
        
        System.out.println("\n===== HISTORIAL DE REHACER =====");
        if (lista.reha == null) {
            System.out.println("No hay acciones en el historial de rehacer.");
        } else {
            Lista.Movimiento temp = lista.reha;
            int count = 1;
            while (temp != null) {
                System.out.println(count + ". " + temp.nodo.dato);
                temp = temp.sig;
                count++;
            }
        }
        System.out.println();
    }
    
    public static void imprimirLista() {
        if (lista.longitud == 0) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        System.out.println("\n===== LISTA DE NOTAS =====");
        Nodo temp = lista.primero;
        int count = 0;
        while (temp != null) {
            System.out.println("[" + count + "] " + temp.dato);
            System.out.println("---");
            temp = temp.sig;
            count++;
        }
        System.out.println("Total de notas: " + lista.longitud);
        System.out.println();
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===========================================");
        System.out.println("  SISTEMA DE GESTIÓN DE NOTAS CON UNDO/REDO");
        System.out.println("===========================================\n");

        while (running) {
            MostrarMenu();
            System.out.print("Seleccione una opción: ");
            String line = scanner.nextLine().trim();
            int opcion;
            try {
                opcion = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingresa un número entre 1 y 8.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarNota(scanner);
                    break;
                case 2:
                    deshacerAccion();
                    break;
                case 3:
                    actualizarNota(scanner);
                    break;
                case 4:
                    deshacerAccion();
                    break;
                case 5:
                    rehacerAccion();
                    break;
                case 6:
                    mostrarLog();
                    break;
                case 7:
                    imprimirLista();
                    break;
                case 8:
                    running = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

            System.out.println();
        }
        scanner.close();
    }
}
