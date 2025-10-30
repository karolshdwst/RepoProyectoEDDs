package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

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
                    try {
                        System.out.println("Introduce los datos del producto:");
                        System.out.print("Clave: ");
                        int clave = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Descripción: ");
                        String descripcion = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Stock: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine(); 

                        lista.agregar(new Nodo(new Nota(clave, descripcion, precio, stock)));
                        System.out.println("Producto agregado con éxito.");
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
                        scanner.nextLine(); 
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Introduce la clave del producto a eliminar: ");
                        int claveAEliminar = scanner.nextInt();
                        scanner.nextLine(); 
                        lista.eliminar(claveAEliminar);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un número para la clave.");
                        scanner.nextLine(); 
                    }
                    break;
                case 3:
                    // Llamada a lista.actualizar()
                        System.out.println("Actualización por posición no es ideal, pero se mantiene la lógica.");
                    try {
                        System.out.print("Posición del producto a actualizar (0 es el más reciente): ");
                        int pos = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.println("Introduce los nuevos datos del producto:");
                        System.out.print("Nueva Descripción: ");
                        String nuevaDesc = scanner.nextLine();
                        System.out.print("Nuevo Precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        System.out.print("Nuevo Stock: ");
                        int nuevoStock = scanner.nextInt();
                        scanner.nextLine(); 

                        if (lista.actualizar(pos, new Nota(0, nuevaDesc, nuevoPrecio, nuevoStock))) {
                            System.out.println("Actualizado con éxito.");
                        } else {
                            System.out.println("No se pudo actualizar. Posición inválida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
                        scanner.nextLine(); 
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
                    System.out.println("Log - Cantidad de productos: " + lista.longitud);
                    break;
                case 7:
                    // Imprimir recorriendo lista.primero
                    if (lista.primero == null) {
                        System.out.println("La lista de productos está vacía.");
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
