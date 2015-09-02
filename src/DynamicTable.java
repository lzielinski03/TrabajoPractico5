import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * Created by lzielinski on 31/08/2015.
 */
public class DynamicTable extends AbstractTableModel{

    public String[] m_colNames = { "First Name", "Last Name"};
    private Vector body;

    public DynamicTable(Vector body) {
        super();
        this.body = body;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}