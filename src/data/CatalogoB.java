package data;

import model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski
 */
public class CatalogoB {

    private List<Producto> products = new ArrayList<>();

    public CatalogoB() {
        products.add(new Producto("Item A", 30.00));
        products.add(new Producto("Item B", 45.50));
        products.add(new Producto("Item C", 99.99));
    }

    public List<Producto> getProducts() {
        return products;
    }
}