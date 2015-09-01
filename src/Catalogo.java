import javax.swing.*;
import java.awt.*;

/**
 * Created by lzielinski on 31/08/2015.
 */
public class Catalogo extends JPanel {

    private JTable table;
    private String[] header = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };


    public Catalogo(Color color){
        this.setBackground(color);
        table = new JTable(new DynamicTable(header));
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setBackground(Color.magenta);
        this.add(table);
    }
}
