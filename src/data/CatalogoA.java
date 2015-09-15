package data;

import model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cueva on 14/09/15.
 */
public class CatalogoA {

    private List<Producto> products = new ArrayList<>();

    public CatalogoA() {
        products.add(new Producto("Item 1", 300.00));
        products.add(new Producto("Item 2", 301.01));
        products.add(new Producto("Item 3", 0.01));
        products.add(new Producto("Item 4", 1.0));
    }

    public List<Producto> getProducts() {
        return products;
    }
}
