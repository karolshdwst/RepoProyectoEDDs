package org.example;

import java.util.Scanner;

public class Menu {
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
                    System.out.println("Agregar");
                    break;
                case 2:
                    System.out.println("Eliminar");
                    break;
                case 3:
                    System.out.println("Actualizar");
                    break;
                case 4:
                    System.out.println("Deshacer");
                    break;
                case 5:
                    System.out.println("Rehacer");
                    break;
                case 6:
                    System.out.println("Mostrar Log");
                    break;
                case 7:
                    System.out.println("Imprimir");
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
