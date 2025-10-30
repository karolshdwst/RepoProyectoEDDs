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
        reha= null;
    }

    public class Movimiento{
        Nodo nodo;
        Movimiento sig;
        Movimiento (Nodo nodo) { 
            this.nodo = nodo; 
            this.sig = null; 
        }
    }

    public void agregar(Nodo nuevo){
        if (nuevo == null) return;
        if (longitud == 0){
                primero = ultimo = nuevo;
            }
            else{
                nuevo.sig = primero;
                primero = nuevo;
            }
            longitud++;

            Movimiento a = new Movimiento(nuevo);
            a.sig = desh;
            desh = a;
            reha = null;
    }

    public boolean deshacer() {

        if (desh == null) return false;

        Movimiento a = desh;
        desh = desh.sig;
        Nodo nodo = a.nodo;

        boolean encontrado = false;
        if (primero != null){
            if (primero == nodo){
                primero = primero.sig;
                if(primero == null) {
                    ultimo = null;
                }
                encontrado = true;
            } else {
                Nodo prev = primero;
                Nodo act = primero.sig;
                while(act != null){
                    if (act == nodo){
                        prev.sig = act.sig;
                        if (act == ultimo) {
                            ultimo = prev;
                        }
                        encontrado = true;
                        break;
                    }
                    prev = act;
                    act = act.sig;
                }
            }
        }
        if (encontrado){
            longitud = longitud - 1;
        }
        nodo.sig = null;
        Movimiento r = new Movimiento(nodo);
        r.sig = reha;
        reha = r;

        return true;
    }


    public boolean rehacer() {
    if (reha == null) return false;
    
    Movimiento r = reha;
    reha = reha.sig;
    Nodo nodo = r.nodo;

    // el nodo debería estar ya aislado, pero aseguremos
    nodo.sig = primero;
    primero = nodo;
    if (ultimo == null) {
        ultimo = nodo;
    }
    longitud++;

    // registrar en undo
    Movimiento a = new Movimiento(nodo);
    a.sig = desh;
    desh = a;

    return true;
}







    
}
