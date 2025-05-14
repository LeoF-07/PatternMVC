package View;

import Model.TesterPatternMVC;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public final static int WIDTH = 1000;
    public final static int HEIGTH = 500;

    JLabel labelMatricola;
    JTextField matricola;
    JLabel labelCognome;
    JTextField cognome;
    JLabel labelNome;
    JTextField nome;
    JLabel labelCitta;
    JTextField citta;
    JLabel labelIndirizzo;
    JTextField indirizzo;

    JTable tabella;

    public GUI(){
        super("GUI");
        this.setSize(WIDTH, HEIGTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panelTitolo = new JPanel();
        JLabel labelTitolo = new JLabel("Titolo");
        panelTitolo.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelTitolo.add(labelTitolo);
        panelTitolo.setBackground(Color.GREEN);
        this.add(panelTitolo);

        String[][] t = TesterPatternMVC.getArc().getMatricole();
        String[] g = {"Riga", "Matricola", "Cognome", "Nome", "Città", "Indirizzo"};

        JPanel panelTabella = new JPanel();
        panelTabella.setLayout(new BorderLayout());
        tabella = new JTable(t, g);
        tabella.getColumnModel().getColumn(0).setPreferredWidth(1);
        JScrollPane scrollPane = new JScrollPane(tabella);
        panelTabella.add(scrollPane);
        panelTabella.setBackground(Color.BLUE);
        this.add(panelTabella);

        JPanel panelCampiDati = new JPanel();
        panelCampiDati.setLayout(new FlowLayout());
        panelCampiDati.setBorder(new EmptyBorder(20, 20, 20, 20));

        labelMatricola = new JLabel("Matricola:");
        matricola = new JTextField();
        matricola.setPreferredSize(new Dimension(100, 20));
        labelCognome = new JLabel("Cognome:");
        labelCognome.setBorder(new EmptyBorder(0, 20, 0,0));
        cognome = new JTextField();
        cognome.setPreferredSize(new Dimension(100, 20));
        labelNome = new JLabel("Nome:");
        labelNome.setBorder(new EmptyBorder(0, 20, 0,0));
        nome = new JTextField();
        nome.setPreferredSize(new Dimension(100, 20));
        labelCitta = new JLabel("Città:");
        labelCitta.setBorder(new EmptyBorder(0, 20, 0,0));
        citta = new JTextField();
        citta.setPreferredSize(new Dimension(100, 20));
        labelIndirizzo = new JLabel("Indirizzo:");
        labelIndirizzo.setBorder(new EmptyBorder(0, 20, 0,0));
        indirizzo = new JTextField();
        indirizzo.setPreferredSize(new Dimension(100, 20));

        panelCampiDati.add(labelMatricola);
        panelCampiDati.add(matricola);
        panelCampiDati.add(labelCognome);
        panelCampiDati.add(cognome);
        panelCampiDati.add(labelNome);
        panelCampiDati.add(nome);
        panelCampiDati.add(labelCitta);
        panelCampiDati.add(citta);
        panelCampiDati.add(labelIndirizzo);
        panelCampiDati.add(indirizzo);

        this.add(panelCampiDati);

        JButton pulsanteAggiunta = new JButton("Aggiungi");
        pulsanteAggiunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TesterPatternMVC.getArc().aggiungi(matricola.getText(), cognome.getText(), nome.getText(), citta.getText(), indirizzo.getText());
                String[][] t = TesterPatternMVC.getArc().getMatricole();
                String[] g = {"Riga", "Matricola", "Cognome", "Nome", "Città", "Indirizzo"};
            }
        });
        JButton pulsanteEliminazione = new JButton("Elimina");

        JPanel panelPulsanti = new JPanel();
        panelPulsanti.setLayout(new FlowLayout());
        panelPulsanti.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelPulsanti.add(pulsanteAggiunta);
        panelPulsanti.add(pulsanteEliminazione);
        this.add(panelPulsanti);

        this.setVisible(true);
    }

}
