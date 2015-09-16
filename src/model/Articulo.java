package model;

/**
 * Created by cueva
 */
public class Articulo {

    private String articuloName;
    private int cantidad;
    private Double precio;

    public Articulo(String articuloName, int cantidad, Double precio) {
        this.articuloName = articuloName;
        this.setCantidad(cantidad);
        this.precio = precio;
    }

    public String getArticuloName() {
        return articuloName;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}