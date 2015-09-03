import javax.swing.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by lzielinski on 02/09/2015.
 */
public class CustomTable extends JTable implements TableModelListener {

    public CustomTable(AbstractTableModel model) {
        super(model);
        this.getModel().addTableModelListener(this);
    }
/*
    public void tableChanged(TableModelEvent e) {
        System.out.println(e.getSource().toString());
    }
*/


}
