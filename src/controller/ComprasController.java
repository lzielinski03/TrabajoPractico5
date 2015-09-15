package controller;

import model.ComprasModel;
import view.ComprasView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lzielinski on 03/09/2015.
 */
public class ComprasController{
	
	private ComprasView view;
	private ComprasModel model;
	
	public ComprasController() {
		model = new ComprasModel();
		view = new ComprasView(model.getColumns());

        view.buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.setTableData(null);
            }
        });
	}

    public void setDataTable(String[][] tableData) {
        model.setArticulos(tableData);
        view.setTableData(model.getArticulos());
    }

    public void addTableData(String[][] tableData) {
        model.addArticulos(tableData);
        view.setTableData(model.getArticulos());
        view.setTotal(model.getTotal());
    }

	public ComprasView getView() {
		return view;
	}


}
