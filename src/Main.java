import javax.swing.*;

/**
 * Created by lzielinski on 20/08/2015.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final Ventana wnd = new Ventana();
                wnd.setVisible(true);
            }
        });
    }



}
