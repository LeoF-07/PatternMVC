package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame {

    public final static int WIDTH = 800;
    public final static int HEIGTH = 800;

    public GUI(){
        super("GUI");
        this.setSize(WIDTH, HEIGTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panelTitolo = new JPanel();
        JLabel labelTitolo = new JLabel("Titolo");
        panelTitolo.setBorder(new EmptyBorder(100, 100, 100, 100));
        panelTitolo.add(labelTitolo);
        panelTitolo.setBackground(Color.GREEN);
        this.add(panelTitolo);

        String[][] t = new String[10][10];

        String[] g = {"Matricola", "Cognome", "Nome", "Città", "Indirizzo"};

        JPanel panelTabella = new JPanel();
        panelTabella.setLayout(new BorderLayout());
        JTable tabella = new JTable(t, g);
        JScrollPane scrollPane = new JScrollPane(tabella);
        panelTabella.add(scrollPane);
        panelTabella.setBackground(Color.BLUE);
        this.add(panelTabella);

        this.setVisible(true);
    }

}
