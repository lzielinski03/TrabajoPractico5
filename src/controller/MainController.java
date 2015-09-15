package controller;

import data.CatalogoA;
import data.CatalogoB;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author lzielinski
 *
 */
public class MainController implements ActionListener{

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

		setElementsListeners();

        mainView.add(compras.getView());
		mainView.add(catalogoA.getView());
		mainView.add(catalogoB.getView());

		dispalyView(compras.getView());
		mainView.setVisible(true);
	}

	private void setElementsListeners() {
		mainView.topMenu.listadoCompras.addActionListener(this);
		mainView.topMenu.categoriaA.addActionListener(this);
		mainView.topMenu.categoriaB.addActionListener(this);
	}

	public void addToCompras(String[][] tableData) {
        compras.addTableData(tableData);
		dispalyView(compras.getView());
    }

	public void dispalyView(JPanel view) {
		mainView.setContentPane(view);
		mainView.repaint();
		mainView.printAll(mainView.getGraphics());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.topMenu.listadoCompras) {
			dispalyView(compras.getView());
		} else if (e.getSource() == mainView.topMenu.categoriaA) {
			dispalyView(catalogoA.getView());
		} else if (e.getSource() == mainView.topMenu.categoriaB) {
			dispalyView(catalogoB.getView());
		}
	}

}