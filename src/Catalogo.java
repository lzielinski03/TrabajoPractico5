import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.util.List;

/**
 * Created by lzielinski on 31/08/2015.
 */
public class Catalogo extends JPanel implements TableModelListener{

    private CustomTable table;
    private JTable table2;
   // private JButton test;

    public Catalogo(Color color, List<String> columnNames) throws Exception{
        this.setBackground(color);

        table2 = new JTable(new CatalogoDataModel(columnNames));
        table2.getModel().addTableModelListener(this);

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

        this.add(new JScrollPane(table2));
    }

    @Override
    public void tableChanged(TableModelEvent e) {

    }
}
