import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by lzielinski on 02/09/2015.
 */
public class CatalogoDataModel extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] data;

    public CatalogoDataModel(String[] columnNames) throws Exception{
        if (columnNames.length == 0) throw new Exception("asd");

        this.columnNames = columnNames;
        data = new Object[0][0];
    }

    public CatalogoDataModel(List<String> headers) throws Exception {
        if (headers.size() == 0) throw new Exception("qwe");

        this.columnNames = new String[headers.size()];
        this.columnNames = headers.toArray(columnNames);
        data = new Object[0][0];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
/*
    @Override
    public void tableChanged(TableModelEvent e) {

    }*/
}
