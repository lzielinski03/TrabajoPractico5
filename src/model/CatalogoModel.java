package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski on 14/09/2015.
 */
public class CatalogoModel {

    private final String[] columns = {"Producto", "Precio", "Cantidad"};
    private List<Producto> products = new ArrayList<>();

    public void setProducts(List<Producto> dataTable) {
        this.products = dataTable;
    }

    public String[] getColumns() {
        return columns;
    }

    public String[][] getProducts() {
        String[][] data = new String[products.size()][3];

        for (int i = 0; i < products.size(); i++) {
            data[i][0] = products.get(i).getName();
            data[i][1] = products.get(i).getPrecio().toString();
            data[i][2] = "0";
        }
        return data;
    }
}
