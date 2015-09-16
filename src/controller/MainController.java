package controller;

import data.CatalogoA;
import data.CatalogoB;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author lzielinski
 *
 */
public class MainController implements ActionListener{

	private MainFrame mainView;

	private CatalogoController catalogoA;
	private CatalogoController catalogoB;
	private ComprasController compras;
	
	public MainController() {
		init();
	}

    private void init() {
		mainView = new MainFrame();

        // add list<SuperClass>
		catalogoA = new CatalogoController("Catalogo A", new CatalogoA().getProducts(), this);
		catalogoB = new CatalogoController("Catalogo B", new CatalogoB().getProducts(), this);
        compras = new ComprasController();

		setElementsListeners();

        // iterar
        mainView.add(compras.getView());
		mainView.add(catalogoA.getView());
		mainView.add(catalogoB.getView());

        mainView.dispalyView(compras.getView());
		mainView.setVisible(true);
	}

	private void setElementsListeners() {
		mainView.topMenu.getListadoCompras().addActionListener(this);
		mainView.topMenu.getCategoriaA().addActionListener(this);
		mainView.topMenu.getCategoriaB().addActionListener(this);
	}

	protected void addToCompras(String[][] tableData) {
        compras.addTableData(tableData);
        mainView.dispalyView(compras.getView());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.topMenu.getListadoCompras()) {
            mainView.dispalyView(compras.getView());
		} else if (e.getSource() == mainView.topMenu.getCategoriaA()) {
            mainView.dispalyView(catalogoA.getView());
		} else if (e.getSource() == mainView.topMenu.getCategoriaB()) {
            mainView.dispalyView(catalogoB.getView());
		}
	}

    public void message(String message, int type) {
        this.mainView.message(message, type);
    }
}