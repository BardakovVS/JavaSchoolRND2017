package homeWork.homeWork5;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        TermInterface okno = new TermInterface();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(350, 300);
        okno.setVisible(true);

    }
}
