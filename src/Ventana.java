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


    private ListadoComprasPanel listadoComprasPanel;
    private Catalogo panelACatalogo;
    private Catalogo panelBCatalogo;

    private JTable table;

    private JMenuBar menuBar;

    private JMenu carrito;
    private JMenu catalogo;
    private JMenu ayuda;

    private JMenuItem listadoCompras;
    private JMenuItem salir;
    private JMenuItem categoriaA;
    private JMenuItem categoriaB;
    private JMenuItem about;

    public Ventana() {
        init();
    }

    private void init() {
        createMenuBar();
        createPanels();
        createTable();
        setActionListener();


        this.setJMenuBar(menuBar);
        //tablePanel.add(table);
        this.add(listadoComprasPanel);
        this.add(panelACatalogo);
        this.add(panelBCatalogo);

        setTitle("Portal de compras");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new CardLayout());
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        carrito = new JMenu("Carrito");
        catalogo = new JMenu("Catalogo");
        ayuda = new JMenu("Ayuda");

        listadoCompras = new JMenuItem("Listado de compras");
        salir = new JMenuItem("Salir");
        categoriaA = new JMenuItem("Categoria I");
        categoriaB = new JMenuItem("Categoria II");
        about = new JMenuItem("Sobre la aplicacion");

        carrito.add(listadoCompras);
        carrito.add(salir);
        catalogo.add(categoriaA);
        catalogo.add(categoriaB);
        ayuda.add(about);

        menuBar.add(carrito);
        menuBar.add(catalogo);
        menuBar.add(ayuda);
    }

    private void createPanels() {
        listadoComprasPanel = new ListadoComprasPanel();
        panelACatalogo = new Catalogo(Color.darkGray);
        panelBCatalogo = new Catalogo(Color.green);
    }

    public void setActionListener() {
        listadoCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelACatalogo.setVisible(false);
                panelBCatalogo.setVisible(false);
                listadoComprasPanel.setVisible(true);
            }
        });

        categoriaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelACatalogo.setVisible(false);
                listadoComprasPanel.setVisible(false);
                panelBCatalogo.setVisible(true);
            }
        });

        categoriaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBCatalogo.setVisible(false);
                listadoComprasPanel.setVisible(false);
                panelACatalogo.setVisible(true);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dessarrollado por Zielinski Leonardo", "Portal de compras info", JOptionPane.INFORMATION_MESSAGE);
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
