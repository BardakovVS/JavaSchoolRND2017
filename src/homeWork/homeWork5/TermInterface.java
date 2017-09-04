package homeWork.homeWork5;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TermInterface extends JFrame {

    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField pole1;
    private JTextField pole2;
    private JTextField pole3;
    private JPasswordField pass;
    private JButton button1, button2;

    public TermInterface() {
        super("ТЕРМИНАЛ");
        setLayout(new FlowLayout());
        label1 = new JLabel("Введите счет:");
        add(label1);
        pole1 = new JTextField(20);
        add(pole1);
        label2 = new JLabel("Введите сумму (кратную 100):");
        //add(label2);
        pole2 = new JTextField(20);
        //add(pole2);
        pole3 = new JTextField("Neredaktirovat", 20);
        pole3.setEnabled(false);
        //add(pole3);
        label3 = new JLabel("Введите PIN: ");
        add(label3);
        pass = new JPasswordField("XXXX", 20);
        add(pass);
        add(label2);
        add(pole2);
        button1 = new JButton("Снять наличные");
        add(button1);
        button2 = new JButton("Внести наличные");
        add(button2);

        Obrabotchik obrabotka = new Obrabotchik();
        pole1.addActionListener(obrabotka);
        pole2.addActionListener(obrabotka);
        pole3.addActionListener(obrabotka);
        pass.addActionListener(obrabotka);
        button1.addActionListener(obrabotka);
        button2.addActionListener(obrabotka);

    }

    private class Obrabotchik implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String string = "";
            if (event.getSource() == pole1) {
                string = String.format("Pole 1: %s", event.getActionCommand());
            } else if (event.getSource() == pole2) {
                string = String.format("Pole 2: %s", event.getActionCommand());
            } else if (event.getSource() == pole3) {
                string = String.format("Pole 3: %s", event.getActionCommand());
            } else if (event.getSource() == pass) {
                string = String.format("Pass: %s", event.getActionCommand());
            } else if (event.getSource() == button1) {
                if (pinValidator.validation(pole1.getText(), Integer.parseInt(pass.getText()))) {
                    if (server.spisanie(pole1.getText(), Integer.parseInt(pole2.getText()))) {
                        string = String.format("Списано: " + pole2.getText() + "\n" +
                                "Остаток: " + server.getOstatok(pole1.getText()), event.getActionCommand());
                    } else {
                        string = "НЕДОСТАТОЧНО СРЕДСТВ ДЛЯ СПИСАНИЯ" + "\n" + "Остаток: " + server.getOstatok(pole1.getText());
                    }
                } else {
                    string = "НЕВЕРНЫЙ ПИН";
                }

            } else if (event.getSource() == button2) {
                if (pinValidator.validation(pole1.getText(), Integer.parseInt(pass.getText()))) {
                    if (server.popolnenie(pole1.getText(), Integer.parseInt(pole2.getText()))) {
                        string = String.format("Зачислено: " + pole2.getText() + "\n" +
                                "Остаток: " + server.getOstatok(pole1.getText()), event.getActionCommand());
                    } else {
                        string = "ОШИБКА" + "\n" + "Остаток: " + server.getOstatok(pole1.getText());
                    }
                } else {
                    string = "НЕВЕРНЫЙ ПИН";
                }
            }
            JOptionPane.showMessageDialog(null, string);


        }
    }

}
