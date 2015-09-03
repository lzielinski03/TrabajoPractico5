package view;

import controller.ComprasController;
import model.ProductoModel;
import model.ProductoRefInterface;

import javax.swing.*;

/**
 * Created by lzielinski on 03/09/2015.
 */
public class CatalogoView extends JPanel implements ProductoRefInterface {

    private static final long serialVersionUID = 1L;

    private static final String PANEL_TITLE = "Catalogo";
    private static final String BUY_BUTTON = "Comprar";
    private static final String[] TABLE_HEADERS = {"Producto", "Precio", "Cantidad"};

    private JLabel titleLabel;
    private JButton buyButton;

    private ComprasController controller;

    public CatalogoView(ProductoModel model) {
        controller = new ComprasController(model);
        createGui();
    }

    // model??
    public CatalogoView(ProductoModel model, ComprasController controller) {
        this.controller = controller;
        createGui();
    }

    public void createGui() {

    }

    @Override
    public void refresh(String name, Double precio) {

    }
}
