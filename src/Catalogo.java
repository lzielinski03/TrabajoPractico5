import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by lzielinski on 31/08/2015.
 */
public class Catalogo extends JPanel {

    private CustomTable table;
   // private JButton test;

    public Catalogo(Color color, List<String> columnNames)throws Exception{
        this.setBackground(color);

        table = new CustomTable(new CatalogoDataModel(columnNames));


        /*
        this.test = new JButton("test");

        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("seee");

            }
        });
        this.add(test);
        */

        this.add(new JScrollPane(table));
    }
}
