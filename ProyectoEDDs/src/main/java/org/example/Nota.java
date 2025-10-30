package org.example;

public class Nota {
    private int clave;
    private String descripcion;
    private double precio;
    private int stock;

    public Nota(int clave, String descripcion, double precio, int stock) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    @Override
    public String toString() {
        return String.format("[%d, %s, %.2f, %d]", clave, descripcion, precio, stock);
    }
}