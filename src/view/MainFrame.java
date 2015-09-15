package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8456560429229699542L;

	public MenuBar topMenu;

	public MainFrame(){
		createGUI();
		init();
	}

	private void init() {
		setTitle("Portal de compras");
        this.setLayout(new CardLayout());
        setSize(500, 500);
		setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createGUI() {
		topMenu = new MenuBar();
		this.setJMenuBar(topMenu);
	}

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Portal de compras info", JOptionPane.INFORMATION_MESSAGE);
    }

	public class MenuBar extends JMenuBar{

		private static final long serialVersionUID = 7220874092704020351L;

		private JMenu carrito;
	    private JMenu catalogo;
	    private JMenu ayuda;

	    public JMenuItem listadoCompras;
		private JMenuItem salir;
		public JMenuItem categoriaA;
		public JMenuItem categoriaB;
	    private JMenuItem about;

	    public MenuBar(){
	    	init();
	    }

	    private void init() {
	    	carrito = new JMenu("Carrito");
	        catalogo = new JMenu("Catalogo");
	        ayuda = new JMenu("Ayuda");

	        listadoCompras = new JMenuItem("Listado de compras");
	        salir = new JMenuItem("Salir");
	        categoriaA = new JMenuItem("Categoria I");
	        categoriaB = new JMenuItem("Categoria II");
	        about = new JMenuItem("Sobre la aplicacion");

	        setActionListener();

	        carrito.add(listadoCompras);
	        carrito.add(salir);
	        catalogo.add(categoriaA);
	        catalogo.add(categoriaB);
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
	}
}
