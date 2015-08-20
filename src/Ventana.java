import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by lzielinski on 20/08/2015.
 */
public class Ventana extends JFrame {

    private JPanel nuevoPanel;
    private JPanel tablePanel;
    private JTable table;

    private JMenuBar menuBar;

    private JMenu archivo;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardar;
    private JMenuItem salir;

    private JMenu help;
    private JMenuItem ayuda;
    private JMenuItem acerca;

    public Ventana() {
        init();
    }

    private void init() {
        createMenuBar();
        createPanels();
        createTable();
        setActionListener();


        this.setJMenuBar(menuBar);
        tablePanel.add(table);
        this.add(nuevoPanel);
        this.add(tablePanel);

        setTitle("Title");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new CardLayout());
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        archivo = new JMenu("Archivo");
        help = new JMenu("Help");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");

        ayuda = new JMenuItem("Ayuda");
        acerca = new JMenuItem("Acerca");

        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        help.add(ayuda);
        help.add(acerca);

        menuBar.add(archivo);
        menuBar.add(help);
    }

    private void createPanels() {
        nuevoPanel = new JPanel();
        nuevoPanel.setBackground(Color.cyan);

        tablePanel = new JPanel();
        tablePanel.setBackground(Color.green);
    }

    public void setActionListener() {
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                nuevoPanel.setVisible(true);
            }
        });

        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                nuevoPanel.setVisible(false);
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void createTable() {
        /*
        TableModel tableModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 7;
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }
        };*/

        table = new JTable(new DynamicTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        Object[] values = {"String", 10, 20.0, 30.2, new Boolean(false)};
        DynamicTableModel a = (DynamicTableModel) table.getModel();
        a.insertData(values);
    }

    public class DynamicTableModel extends AbstractTableModel {

        private String[] columnNames;
        private Vector data = new Vector();
        public final Object[] longValues = {"", new Integer(20), new Float(20), new Float(20), Boolean.TRUE};

        public DynamicTableModel() {
            columnNames = new String[]{"Title 1", "Title 2", "Title 3", "Title 4", "Title 5"};
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return ((Vector) data.get(rowIndex)).get(columnIndex);
        }

        public String getColumnName(int col) {
            return  columnNames[col];
        }

        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }

        public void setValueAt(Object value, int row, int col) {
            ((Vector) data.get(row)).setElementAt(value, col);
            fireTableRowsInserted(row, col);
        }

        public boolean isCellEditable(int row, int col){
            if (4 == col)
                return true;
            return false;
        }

        public void insertData(Object[] values){
            data.add(new Vector());
            for(int i =0; i<values.length; i++){
                ((Vector) data.get(data.size()-1)).add(values[i]);
            }
            fireTableDataChanged();
        }

        public void removeRow(int row){
            data.removeElementAt(row);
            fireTableDataChanged();
        }
    }
}
