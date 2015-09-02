import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Created by lzielinski on 02/09/2015.
 */
public class CustomTable extends JTable {

    public CustomTable(AbstractTableModel model) {
        super(model);
    }

/*
    private Object[] header;
    private Object[][] data;

    public CustomTable(String[] header) {
        this.header = header;
    }

    public CustomTable(Object[] header, Object[][] data) {
        super(data, header);
        this.header = header;
        this.data = data;

        this.setFillsViewportHeight(true);
    }

    public int getColumns() {
        return header.length;
    }

    public int getNumRows() {
        return data.length;
    }*/

}
