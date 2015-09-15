package model;

/**
 * Created by cueva on 15/09/15.
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

    public void setArticuloName(String articuloName) {
        this.articuloName = articuloName;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }
}
