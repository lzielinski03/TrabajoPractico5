import javax.swing.table.AbstractTableModel;

/**
 * Created by lzielinski on 31/08/2015.
 */
public class DynamicTable extends AbstractTableModel{

    private String[] header;

    public DynamicTable(String[] header) {
        this.header = header;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
