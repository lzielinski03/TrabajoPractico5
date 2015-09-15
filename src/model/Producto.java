package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski on 01/09/2015.
 */
public class Producto {

    private String name;
    private Double precio;

    public Producto(String name, Double precio) {
        this.name = name;
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
