package controller;

import model.CatalogoModel;
import model.Producto;
import view.CatalogoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by lzielinski
 */
public class CatalogoController implements ActionListener{

    private final MainController mainController;
    private CatalogoView view;
    private CatalogoModel model;

    public CatalogoController(String title, List<Producto> products, final MainController mainController) {
        this.mainController = mainController;
        model = new CatalogoModel();
        model.setProducts(products);
        view = new CatalogoView(title, model.getColumns(), model.getProducts());

        setElementsListeners();
    }

    private void setElementsListeners() {
        view.getButtonBuy().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getButtonBuy()) {

            String[][] data = view.getTableData();
            if (isInvalid(data))
                mainController.message("La cantidad de productos solo admite numeros enteros!", JOptionPane.WARNING_MESSAGE);

            else {
                if (isEmpty(data)) {
                    mainController.message("Seleccione la cantidad de productos!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                setProductos(data);
            }
            view.resetTableData();
        }
    }

    private boolean isInvalid(String[][] data) {
        boolean invalid = true;
        try {
            for (String[] x : data) {
                invalid = true;
                Integer.valueOf(x[2]);
                invalid = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return invalid;
    }

    private boolean isEmpty(String[][] data) {
        boolean empty = true;
        for (String[] x : data) {
            if (Integer.valueOf(x[2]) > 0)
                empty = false;
        }
        return empty;
    }

    private void setProductos(String[][] data) {
        List<String[]> ids = new ArrayList<>();
        for (String[] x : data){
            if (Integer.valueOf(x[2]) > 0)
                ids.add(x);
        }
        String[][] result = new String[ids.size()][ids.get(0).length];
        for (int x = 0; x < result.length; x++)
            for (int i = 0; i < result[x].length; i++) {
                result[x][i] = ids.get(x)[i];
            }
        mainController.addToCompras(result);
    }

    public CatalogoView getView() {
        return view;
    }
}