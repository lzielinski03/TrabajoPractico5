package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by lzielinski
 */
public class CatalogoView extends JPanel{

	private static final long serialVersionUID = 5895058727735335153L;
	
	private static String LABEL_TITLE = "Catalogo";
    private static final String BUTTON_BUY = "Comprar";

    private JLabel labelTitle;
    public JButton buttonBuy;
    private JScrollPane tableBox;
    private JTable jt;
	private DefaultTableModel tableModel;
	private String[] columns;
	private String[][] tableData;
    
    public CatalogoView(String title, String[] columns, String[][] products) {
		this.LABEL_TITLE = title;
		this.columns = columns;
		this.tableData = products;
		init();
        //this.setVisible(true);
    }

	private void init() {
		this.setLayout(null);
		labelTitle = new JLabel(LABEL_TITLE);
		buttonBuy = new JButton(BUTTON_BUY);
		
		labelTitle.setBounds(100, 20, 100, 50);
		buttonBuy.setBounds(299, 370, 100, 30);

		createTable();
		tableBox.setBounds(100, 60, 300, 300);

		this.add(tableBox); 
		this.add(labelTitle);
		this.add(buttonBuy);
	}

	public void createTable() {
		tableModel = new DefaultTableModel(tableData, columns);
		jt = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				switch (column) {
					case 0:
					case 1:
						return false;
					case 2:
						return true;
					default:
						return false;
				}
			}
		};
		tableBox = new JScrollPane(jt);
	}

	public void setTableData(String[][] products) {
        resetTableData();
        tableModel.setDataVector(products, columns);
    }

	public String[][] getTableData() {
        String[][] products = new String[tableModel.getRowCount()][tableModel.getColumnCount()];
        for(int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                products[i][j] = tableModel.getValueAt(i, j).toString();
            }
        }
		return products;
	}

    public void resetTableData() {
        tableModel.setDataVector(tableData, columns);
    }
}