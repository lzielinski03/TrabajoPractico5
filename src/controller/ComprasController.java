package controller;

import model.ComprasModel;
import view.ComprasView;

/**
 * Created by lzielinski on 03/09/2015.
 */
public class ComprasController{
	
	private ComprasView view;
	private ComprasModel model;
	
	public ComprasController() {
		model = new ComprasModel();
		view = new ComprasView(model.getColumns());
	}

	public ComprasView getView() {
		return view;
	}
}
