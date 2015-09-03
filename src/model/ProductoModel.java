package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski on 01/09/2015.
 */
public class ProductoModel {

    private String name;
    private Double precio;
    private ArrayList productoViews = new ArrayList();

    public ProductoModel() {
        this(null);
    }

    public ProductoModel(ProductoRefInterface view) {
        this.name = "";
        this.precio = 0.0;
        if (view != null)
            productoViews.add(view);
    }

    public void updateView() {

    }

    public void updateModel(){

    }

    public void addView(ProductoRefInterface view){

    }

    public void removeView() {

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
