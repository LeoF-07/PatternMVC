import Model.Record;
import View.GUI;

public class TesterPatternMVC{

    public static Anagrafico arc;
    public static GUI gui;

    public static void inizializzaVariabili(){
        arc = new Anagrafico();
        gui = new GUI();
    }

    public static void main(String[] args){
        inizializzaVariabili();

        arc.apriFile();
        arc.aggiungi("AZ999", "Gialli", "Federica", "San dona del Piave", "Piazza Vittorio II 6");
        arc.aggiungi("AZ123", "Rossi", "Gianluca", "Castelfranco", "Lungo Sile 6");

        arc.vediTutti();

        int pos = arc.cercaMatricola("AZ123");
        if (pos > 0) {
            String s = arc.recPosizione(pos);
            System.out.println("\nRecord trovato:\n" + s);
        }
        else System.out.println("\nMatricola inesistente");

        arc.modifica(200, "Mestre", "Garibaldi 35");


        stampaMatricola(200);


        arc.reInizializzaFile();

        arc.chiudiFile();
    }

    public static void stampaMatricola(int posizione){
        String s = arc.recPosizione(posizione);
        System.out.println("\nMatricola numero " + (posizione / Record.L + 1) + ":");

        System.out.print(s.substring(0,20));
        System.out.print(s.substring(20,40));
        System.out.print(s.substring(40,60));
        System.out.print(s.substring(60,80));
        System.out.print(s.substring(80,100));
        System.out.println();
    }

}