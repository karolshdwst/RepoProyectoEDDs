package org.example;

public class Lista {
    Nodo primero;
    Nodo ultimo;
    int longitud;
    Movimiento desh;
    Movimiento reha;

    Lista(){
        primero = ultimo = null;
        longitud = 0;
        desh = null;
        reha = null;
    }

    public enum TipoMovimiento {
        AGREGAR, ELIMINAR
    }

    public class Movimiento {
        TipoMovimiento tipo;
        Nodo nodo;
        String tituloPrev; // Título del nodo previo (para eliminación)
        Movimiento sig;

        Movimiento(Nodo nodo, TipoMovimiento tipo) {
            this.nodo = nodo;
            this.tipo = tipo;
            this.tituloPrev = null;
            this.sig = null;
        }

        Movimiento(Nodo nodo, String tituloPrev, TipoMovimiento tipo) {
            this.nodo = nodo;
            this.tituloPrev = tituloPrev;
            this.tipo = tipo;
            this.sig = null;
        }
    }

    public void agregar(Nodo nuevo) {
        if (nuevo == null) return;
        if (longitud == 0) {
            primero = ultimo = nuevo;
        } else {
            nuevo.sig = primero;
            primero = nuevo;
        }
        longitud++;

        Movimiento a = new Movimiento(nuevo, TipoMovimiento.AGREGAR);
        a.sig = desh;
        desh = a;
        reha = null;
    }

    public boolean eliminar(String titulo) {
        if (primero == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return false;
        }

        Nodo actual = primero;
        Nodo prev = null;

        while (actual != null && !actual.dato.getTitulo().equals(titulo)) {
            prev = actual;
            actual = actual.sig;
        }

        if (actual == null) {
            System.out.println("No se encontró una nota con el título: " + titulo);
            return false;
        }

        if (prev == null) {
            primero = actual.sig;
        } else {
            prev.sig = actual.sig;
        }

        if (actual == ultimo) {
            ultimo = prev;
        }

        longitud--;
        actual.sig = null;

        // Guardar el título del nodo previo para poder reinsertar correctamente
        String tituloPrev = (prev != null) ? prev.dato.getTitulo() : null;
        Movimiento a = new Movimiento(actual, tituloPrev, TipoMovimiento.ELIMINAR);
        a.sig = desh;
        desh = a;
        reha = null;

        System.out.println("Nota con título '" + titulo + "' eliminada con éxito.");
        return true;
    }

    public boolean actualizar(Nodo nodoActual, Nota nuevosDatos) {
        if (nodoActual == null) return false;
        Nodo temp = primero;
        while (temp != null) {
            if (temp == nodoActual) {
                temp.dato = nuevosDatos;
                return true;
            }
            temp = temp.sig;
        }
        return false;
    }

    public boolean actualizar(int posicion, Nota nuevosDatos) {
        if (posicion < 0 || posicion >= longitud) return false;
        Nodo temp = primero;
        int contador = 0;
        while (temp != null) {
            if (contador == posicion) {
                temp.dato = nuevosDatos;
                return true;
            }
            temp = temp.sig;
            contador++;
        }
        return false;
    }

    public boolean actualizarPorTitulo(String titulo, String nuevoContenido) {
        Nodo temp = primero;
        while (temp != null) {
            if (temp.dato.getTitulo().equals(titulo)) {
                temp.dato = new Nota(titulo, nuevoContenido);
                return true;
            }
            temp = temp.sig;
        }
        return false;
    }

    public boolean deshacer() {
        if (desh == null) return false;

        Movimiento mov = desh;
        desh = desh.sig;

        if (mov.tipo == TipoMovimiento.AGREGAR) {
            // Deshacer un agregar = eliminar el nodo
            if (primero == mov.nodo) {
                primero = primero.sig;
                if (primero == null) ultimo = null;
            } else {
                Nodo prev = primero;
                while (prev != null && prev.sig != mov.nodo) {
                    prev = prev.sig;
                }
                if (prev != null) {
                    prev.sig = mov.nodo.sig;
                    if (mov.nodo == ultimo) ultimo = prev;
                }
            }
            longitud--;
            mov.nodo.sig = null;
        } else if (mov.tipo == TipoMovimiento.ELIMINAR) {
            // Deshacer un eliminar = reinsertar el nodo
            Nodo nodoAReinsertar = mov.nodo;
            if (mov.tituloPrev == null) {
                // Se eliminó del inicio, reinsertar al inicio
                nodoAReinsertar.sig = primero;
                primero = nodoAReinsertar;
                if (ultimo == null) ultimo = nodoAReinsertar;
            } else {
                // Buscar el nodo con tituloPrev y reinsertar después
                Nodo prev = primero;
                while (prev != null && !prev.dato.getTitulo().equals(mov.tituloPrev)) {
                    prev = prev.sig;
                }
                if (prev != null) {
                    nodoAReinsertar.sig = prev.sig;
                    prev.sig = nodoAReinsertar;
                    if (nodoAReinsertar.sig == null) ultimo = nodoAReinsertar;
                } else {
                    // Si no se encuentra el prev, insertar al inicio
                    nodoAReinsertar.sig = primero;
                    primero = nodoAReinsertar;
                }
            }
            longitud++;
        }

        mov.sig = reha;
        reha = mov;
        return true;
    }

    public boolean rehacer() {
        if (reha == null) return false;

        Movimiento mov = reha;
        reha = reha.sig;

        if (mov.tipo == TipoMovimiento.AGREGAR) {
            // Rehacer un agregar = volver a agregar el nodo
            Nodo nodo = mov.nodo;
            nodo.sig = primero;
            primero = nodo;
            if (ultimo == null) ultimo = nodo;
            longitud++;
        } else if (mov.tipo == TipoMovimiento.ELIMINAR) {
            // Rehacer un eliminar = volver a eliminar el nodo
            Nodo nodoAEliminar = mov.nodo;
            if (mov.tituloPrev == null) {
                // Se eliminó del inicio
                primero = nodoAEliminar.sig;
                if (primero == null) ultimo = null;
            } else {
                // Buscar el nodo previo y eliminar
                Nodo prev = primero;
                while (prev != null && !prev.dato.getTitulo().equals(mov.tituloPrev)) {
                    prev = prev.sig;
                }
                if (prev != null && prev.sig == nodoAEliminar) {
                    prev.sig = nodoAEliminar.sig;
                    if (nodoAEliminar == ultimo) ultimo = prev;
                }
            }
            longitud--;
            nodoAEliminar.sig = null;
        }

        mov.sig = desh;
        desh = mov;
        return true;
    }
}