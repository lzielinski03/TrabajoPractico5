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
public class MainController {

	MainFrame mainView;

	private CatalogoController catalogoA;
	private CatalogoController catalogoB;
	private ComprasController compras;
	
	public MainController() {
		init();
	}

	public void init() {
		mainView = new MainFrame();

		catalogoA = new CatalogoController("Catalogo A", new CatalogoA().getProducts(), this);
		catalogoB = new CatalogoController("Catalogo B", new CatalogoB().getProducts(), this);
        compras = new ComprasController();

		setActionsListeners();

        mainView.add(compras.getView());
		mainView.add(catalogoA.getView());
		mainView.add(catalogoB.getView());
        mainView.setVisible(true);
	}

    public void addToCompras(String[][] tableData) {
        compras.addTableData(tableData);
        showCompras();
    }

	public void showCompras() {
		catalogoA.getView().setVisible(false);
		catalogoB.getView().setVisible(false);
		compras.getView().setVisible(true);
	}

	private void setActionsListeners() {

		mainView.topMenu.listadoCompras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				catalogoA.getView().setVisible(false);
				catalogoB.getView().setVisible(false);
				compras.getView().setVisible(true);
			}
		});

		mainView.topMenu.categoriaA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				catalogoB.getView().setVisible(false);
				compras.getView().setVisible(false);
				catalogoA.getView().setVisible(true);
			}
		});

		mainView.topMenu.categoriaB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				compras.getView().setVisible(false);
				catalogoA.getView().setVisible(false);
				catalogoB.getView().setVisible(true);
			}
		});
	}
}