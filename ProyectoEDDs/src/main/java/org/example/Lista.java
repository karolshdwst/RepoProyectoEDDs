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
        Nodo prev;
        Movimiento sig;

        Movimiento(Nodo nodo, TipoMovimiento tipo) {
            this.nodo = nodo;
            this.tipo = tipo;
            this.prev = null;
            this.sig = null;
        }

        Movimiento(Nodo nodo, Nodo prev, TipoMovimiento tipo) {
            this.nodo = nodo;
            this.prev = prev;
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

    public boolean eliminar(int clave) {
        if (primero == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return false;
        }

        Nodo actual = primero;
        Nodo prev = null;

        while (actual != null && actual.dato.getClave() != clave) {
            prev = actual;
            actual = actual.sig;
        }

        if (actual == null) {
            System.out.println("No se encontró un producto con la clave: " + clave);
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

        Movimiento a = new Movimiento(actual, prev, TipoMovimiento.ELIMINAR);
        a.sig = desh;
        desh = a;
        reha = null;

        System.out.println("Producto con clave " + clave + " eliminado con éxito.");
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

    public boolean deshacer() {
        if (desh == null) return false;

        Movimiento mov = desh;
        desh = desh.sig;

        if (mov.tipo == TipoMovimiento.AGREGAR) {
            if (primero == mov.nodo) {
                primero = primero.sig;
                if (primero == null) ultimo = null;
            } else {
                Nodo prev = primero;
                while (prev.sig != mov.nodo) {
                    prev = prev.sig;
                }
                prev.sig = mov.nodo.sig;
                if (mov.nodo == ultimo) ultimo = prev;
            }
            longitud--;
            mov.nodo.sig = null;
        } else if (mov.tipo == TipoMovimiento.ELIMINAR) {
            Nodo nodoAReinsertar = mov.nodo;
            Nodo prev = mov.prev;
            if (prev == null) {
                nodoAReinsertar.sig = primero;
                primero = nodoAReinsertar;
                if (ultimo == null) ultimo = nodoAReinsertar;
            } else {
                nodoAReinsertar.sig = prev.sig;
                prev.sig = nodoAReinsertar;
                if (nodoAReinsertar.sig == null) ultimo = nodoAReinsertar;
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
            Nodo nodo = mov.nodo;
            nodo.sig = primero;
            primero = nodo;
            if (ultimo == null) ultimo = nodo;
            longitud++;
        } else if (mov.tipo == TipoMovimiento.ELIMINAR) {
            Nodo nodoAEliminar = mov.nodo;
            Nodo prev = mov.prev;
            if (prev == null) {
                primero = nodoAEliminar.sig;
            } else {
                prev.sig = nodoAEliminar.sig;
            }
            if (nodoAEliminar == ultimo) ultimo = prev;
            longitud--;
            nodoAEliminar.sig = null;
        }

        mov.sig = desh;
        desh = mov;
        return true;
    }
}