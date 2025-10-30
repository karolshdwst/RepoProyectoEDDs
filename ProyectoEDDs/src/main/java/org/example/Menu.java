package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    private static Lista lista = new Lista();

    public static void MostrarMenu() {
        System.out.println("----- Menú Principal -----");
        System.out.println("---Notas---");
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
            int opcion = -1;
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Ingresa un número entre 1 y 8.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Llamada a lista.agregar()
                    System.out.println("Introduce los datos de la nota:");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Contenido: ");
                    String contenido = scanner.nextLine();

                    lista.agregar(new Nodo(new Nota(titulo, contenido)));
                    System.out.println("Nota agregada con éxito.");
                    break;
                case 2:
                    System.out.print("Introduce el título de la nota a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    lista.eliminar(tituloEliminar);
                    break;
                case 3:
                    // Llamada a lista.actualizar()
                    System.out.print("Introduce el título de la nota a actualizar: ");
                    String tituloActualizar = scanner.nextLine();
                    System.out.print("Introduce el nuevo contenido: ");
                    String nuevoContenido = scanner.nextLine();

                    if (lista.actualizarPorTitulo(tituloActualizar, nuevoContenido)) {
                        System.out.println("Nota actualizada con éxito.");
                    } else {
                        System.out.println("No se encontró una nota con ese título.");
                    }
                    break;
                case 4:
                    // Llamada a lista.deshacer()
                    if (lista.deshacer()) {
                        System.out.println("Acción deshecha con éxito.");
                    } else {
                        System.out.println("No hay operaciones por deshacer.");
                    }
                    break;
                case 5:
                    // Llamada a lista.rehacer()
                    if (lista.rehacer()) {
                        System.out.println("Acción rehecha con éxito.");
                    } else {
                        System.out.println("No hay operaciones por rehacer.");
                    }
                    break;
                case 6:
                    // Acceso a lista.desh y lista.reha
                    System.out.println("Log - Cantidad de notas: " + lista.longitud);
                    break;
                case 7:
                    // Imprimir recorriendo lista.primero
                    if (lista.primero == null) {
                        System.out.println("La lista de notas está vacía.");
                    } else {
                        Nodo temp = lista.primero;
                        while (temp != null) {
                            System.out.println(temp.dato);
                            temp = temp.sig;
                        }
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
