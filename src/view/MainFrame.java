package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8456560429229699542L;

	public MenuBar topMenu;

	public MainFrame(){
		createGUI();
		init();
	}

	private void init() {
		setTitle("Portal de compras");
		this.setLayout(new FlowLayout());
        setSize(500, 500);
		setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createGUI() {
		topMenu = new MenuBar();
		this.setJMenuBar(topMenu);
	}

    public void dispalyView(JPanel view) {
        this.setContentPane(view);
        this.repaint();
        this.printAll(this.getGraphics());
    }

    public void message(String message, int type) {
        JOptionPane.showMessageDialog(null, message, "Portal de compras info", type);
    }

	public class MenuBar extends JMenuBar{

		private static final long serialVersionUID = 7220874092704020351L;

		private JMenu carrito;
	    private JMenu catalogo;
	    private JMenu ayuda;

	    private JMenuItem listadoCompras;
		private JMenuItem salir;
		private JMenuItem categoriaA;
		private JMenuItem categoriaB;
	    private JMenuItem about;

	    public MenuBar(){
	    	init();
	    }

	    private void init() {
	    	carrito = new JMenu("Carrito");
	        catalogo = new JMenu("Catalogo");
	        ayuda = new JMenu("Ayuda");

	        setListadoCompras(new JMenuItem("Listado de compras"));
	        salir = new JMenuItem("Salir");
	        setCategoriaA(new JMenuItem("Categoria I"));
	        setCategoriaB(new JMenuItem("Categoria II"));
	        about = new JMenuItem("Sobre la aplicacion");

	        setActionListener();

	        carrito.add(getListadoCompras());
	        carrito.add(salir);
	        catalogo.add(getCategoriaA());
	        catalogo.add(getCategoriaB());
	        ayuda.add(about);

	        this.add(carrito);
	        this.add(catalogo);
	        this.add(ayuda);
	    }

		private void setActionListener() {

			about.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(null, "Dessarrollado por Zielinski Leonardo", "Portal de compras info", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });

			salir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});

		}

        public JMenuItem getListadoCompras() {
            return listadoCompras;
        }

        public void setListadoCompras(JMenuItem listadoCompras) {
            this.listadoCompras = listadoCompras;
        }

        public JMenuItem getCategoriaA() {
            return categoriaA;
        }

        public void setCategoriaA(JMenuItem categoriaA) {
            this.categoriaA = categoriaA;
        }

        public JMenuItem getCategoriaB() {
            return categoriaB;
        }

        public void setCategoriaB(JMenuItem categoriaB) {
            this.categoriaB = categoriaB;
        }
    }
}
