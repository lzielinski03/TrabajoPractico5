package controller;

import model.CatalogoModel;
import model.ProductoModel;
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
/*
    public CatalogoController(String title, List<ProductoModel> data) {
        model = new CatalogoModel();
        model.setProducts(data);
        view = new CatalogoView(title, model.getColumns(), model.getProducts());

        view.buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object x : view.getTableData()) {
                    System.out.println(x.toString());
                }
                System.out.println();
                view.setTableData(model.getProducts());
            }
        });
    }
*/
    public CatalogoController(String title, List<ProductoModel> products, final MainController mainController) {
        model = new CatalogoModel();
        model.setProducts(products);
        view = new CatalogoView(title, model.getColumns(), model.getProducts());

        view.buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object x : view.getTableData()) {
                    System.out.println(x.toString());
                }
                System.out.println();
                view.setTableData(model.getProducts());
                mainController.showComprasView();
            }
        });
    }


    public void addView(){
    }

    public void removeView() {
    }

    public void updateView() {
    }

    public void updateModel(){
    }

    public CatalogoView getView() {
        return view;
    }
}
