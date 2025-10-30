package org.example;
public class Nota {
    String titulo;
    String nota;

    public Nota(String titulo, String nota) {
        this.titulo = titulo;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return titulo + " : \n" + nota;
    }
}
