package model;

/**
 * Created by cueva
 */
public class Articulo {

    private String articuloName;
    private int cantidad;
    private Double Precio;

    public Articulo(String articuloName, int cantidad, Double precio) {
        this.articuloName = articuloName;
        this.cantidad = cantidad;
        Precio = precio;
    }

    public String getArticuloName() {
        return articuloName;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

}