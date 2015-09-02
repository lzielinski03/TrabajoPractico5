import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by lzielinski on 20/08/2015.
 */
public class Ventana extends JFrame {

    private ListadoComprasPanel listadoComprasPanel;
    private Catalogo panelACatalogo;
    private Catalogo panelBCatalogo;

    private List<String> columnNames;

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
        setActionListener();


        this.setJMenuBar(menuBar);
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

        columnNames = new ArrayList<>();
        columnNames.add("Producto");
        columnNames.add("Precio");
        columnNames.add("Cantidad");

        try {
            panelACatalogo = new Catalogo(Color.darkGray, columnNames);
            panelBCatalogo = new Catalogo(Color.green, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }

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

}
