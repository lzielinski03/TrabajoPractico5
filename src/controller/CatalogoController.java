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
                /*
                if (validate(data)) {

                }*/
                mainController.addToCompras(view.getTableData());
                view.setTableData(model.getProducts());
            }
        });
    }
/*
    private boolean validate(String[][] data) {
        for (String[] x : data) {
            int cant = Integer.valueOf(x[3]);
            if (cant)
        }
        return false;
    }
*/

    public CatalogoView getView() {
        return view;
    }
}
