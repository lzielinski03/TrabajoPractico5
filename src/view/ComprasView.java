package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Created by lzielinski
 */
public class ComprasView extends JPanel{

	private static final long serialVersionUID = -2614704339404021315L;
	
	private static final String LABEL_TITLE = "Listado de compras";
	private static final String LABEL_TOTAL = "Total: $";
    private static final String BUTTON_CLEAR = "Vaciar";

    private JLabel labelTitle;
    private JLabel labelTotal;
    public JButton buttonClear;

	private JScrollPane tableBox;
	private JTable jt;
	private DefaultTableModel tableModel;
	private String[] columns;
	private String[][] tableData;

    public ComprasView(String[] columns) {
		this.columns = columns;
		this.tableData = new String[0][0];
    	init();
        this.setVisible(true);
    }

	private void init() {
		this.setLayout(null);

		labelTitle = new JLabel(LABEL_TITLE);
		labelTotal = new JLabel(LABEL_TOTAL);
		buttonClear = new JButton(BUTTON_CLEAR);

		labelTitle.setBounds(100, 20, 200, 50);
		labelTotal.setBounds(100, 350, 100, 50);
		buttonClear.setBounds(299, 370, 100, 30);

		createTable();
		tableBox.setBounds(100, 60, 300, 300);

		this.add(tableBox);
		this.add(labelTitle);
		this.add(labelTotal);
		this.add(buttonClear);
	}

	public void createTable() {
		tableModel = new DefaultTableModel(tableData, columns);
		jt = new JTable(tableModel);
		tableBox = new JScrollPane(jt);
	}

	public void setTableData(String[][] products) {
        resetTableData();
		tableModel.setDataVector(products, columns);
	}

    public void resetTableData() {
        tableModel.setDataVector(null, columns);
    }

    public void setTotal(Double total) {
        labelTotal.setText(LABEL_TOTAL + total.toString());
    }
}