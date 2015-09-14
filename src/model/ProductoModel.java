package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski on 01/09/2015.
 */
public class ProductoModel {

    private String name;
    private Double precio;

    public ProductoModel(String name, Double precio) {
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
