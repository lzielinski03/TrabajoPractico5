package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski
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

    public Double getPrecio() {
        return precio;
    }

}