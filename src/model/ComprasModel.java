package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski
 */
public class ComprasModel {

    private final String[] columns = {"Producto", "Cantidad", "Precio"};
    private List<Articulo> articulos = new ArrayList<>();

    private Double total;

    public String[] getColumns() {
        return columns;
    }

    public String[][] getArticulos() {
        String[][] data = new String[articulos.size()][3];

        for (int i = 0; i < articulos.size(); i++) {
            data[i][0] = articulos.get(i).getArticuloName();
            data[i][1] = String.valueOf(articulos.get(i).getCantidad());
            data[i][2] = articulos.get(i).getPrecio().toString();
        }
        return data;
    }

    public void addArticulos(String[][] tableData) {
        for (String[] row : tableData) {
            int cantidad = Double.valueOf(row[2]).intValue();
            Double precio = Double.valueOf(row[1]) * Double.valueOf(row[2]);
            articulos.add(new Articulo(row[0], cantidad, precio));
        }
    }

    public void deleteArticulos() {
        articulos.clear();
    }

    public Double getTotal() {
        total = 0.0;
        for (Articulo art : articulos)
            total += art.getPrecio();
        return total;
    }
}