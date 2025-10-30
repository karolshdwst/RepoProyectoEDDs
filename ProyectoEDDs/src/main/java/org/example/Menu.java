package org.example;

import java.util.Scanner;

public class Menu {
    private static Lista lista = new Lista();

    public static void MostrarMenu() {
        System.out.println("----- Menú Principal -----");
        System.out.println("---Productos---");
        System.out.println("[1] Agregar");
        System.out.println("[2] Eliminar");
        System.out.println("[3] Actualizar");
        System.out.println("[4] Deshacer");
        System.out.println("[5] Rehacer");
        System.out.println("[6] Log");
        System.out.println("[7] Imprimir");
        System.out.println("[8] Salir");
        System.out.println("--------------------------");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

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
                    // Llamada a lista.agregar()
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Contenido: ");
                    String contenido = scanner.nextLine();
                    lista.agregar(new Nodo(new Nota(titulo, contenido)));
                    System.out.println("Agregado.");
                    break;
                case 2:
                    System.out.println("Eliminar (usa Deshacer)");
                    break;
                case 3:
                    // Llamada a lista.actualizar()
                    System.out.print("Posición: ");
                    int pos = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nuevo contenido: ");
                    String nuevoContenido = scanner.nextLine();
                    lista.actualizar(pos, new Nota(nuevoTitulo, nuevoContenido));
                    System.out.println("Actualizado.");
                    System.out.println("Actualizado.");
                    break;
                case 4:
                    // Llamada a lista.deshacer()
                    lista.deshacer();
                    System.out.println("Deshacer ejecutado.");
                    break;
                case 5:
                    // Llamada a lista.rehacer()
                    lista.rehacer();
                    System.out.println("Rehacer ejecutado.");
                    break;
                case 6:
                    // Acceso a lista.desh y lista.reha
                    System.out.println("Log - Longitud: " + lista.longitud);
                    break;
                case 7:
                    // Imprimir recorriendo lista.primero
                    Nodo temp = lista.primero;
                    while (temp != null) {
                        System.out.println(temp.dato);
                        temp = temp.sig;
                    }
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
