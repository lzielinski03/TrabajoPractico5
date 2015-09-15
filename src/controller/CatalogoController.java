package controller;

import model.CatalogoModel;
import model.Producto;
import view.CatalogoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by lzielinski on 14/09/2015.
 */
public class CatalogoController {

    private CatalogoView view;
    private CatalogoModel model;

    public CatalogoController(String title, List<Producto> products, final MainController mainController) {
        model = new CatalogoModel();
        model.setProducts(products);
        view = new CatalogoView(title, model.getColumns(), model.getProducts());

        view.buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] data = view.getTableData();

                if (validate(data)) {
                    mainController.addToCompras(data);
                    view.setTableData(model.getProducts());
                } else {
                    view.resetTableData();
                    mainController.mainView.errorMessage("La cantidad de productos solo admite numeros enteros!");
                }
            }
        });
    }

    private boolean validate(String[][] data) {
        boolean aux = false;

        try {
            for (String[] x : data) {
                aux = false;
                int cant = Integer.valueOf(x[2]);

                if (cant <= 0) {

                }
                aux = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return aux;
    }


    public CatalogoView getView() {
        return view;
    }
}