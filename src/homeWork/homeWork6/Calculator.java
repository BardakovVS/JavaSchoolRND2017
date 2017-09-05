package homeWork.homeWork6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class Calculator {

    JPanel windowContent;
    //JLabel displayField;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonP;
    JButton buttonM;
    JButton buttonU;
    JButton buttonR;
    JButton buttonC;
    JButton buttonZ;
    JButton buttonS;
    JButton buttonX;
    JPanel p1;

    Calculator() {
        windowContent = new JPanel();
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        displayField = new JTextField(20);
        displayField.setFont(new Font("Dialog", Font.BOLD, 20));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setDisabledTextColor(Color.BLACK);
        displayField.setEnabled(false);
        windowContent.add("North", displayField);

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonP = new JButton("+");
        buttonM = new JButton("-");
        buttonU = new JButton("*");
        buttonR = new JButton("/");
        buttonC = new JButton("<-");
        buttonS = new JButton("C");
        buttonZ = new JButton("+/-");
        buttonX = new JButton("");

        p1 = new JPanel();
        GridLayout gl = new GridLayout(5, 4);
        p1.setLayout(gl);

        p1.add(buttonC);
        p1.add(buttonS);
        p1.add(buttonX);
        p1.add(buttonU);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(buttonR);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(buttonP);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(buttonM);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonZ);
        p1.add(buttonEqual);


        windowContent.add("Center", p1);
        JFrame frame = new JFrame("Calcularoe");
        frame.setContentPane(windowContent);

        frame.pack();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Obrabotchik obrabotka = new Obrabotchik();
        button0.addActionListener(obrabotka);
        button1.addActionListener(obrabotka);
        button2.addActionListener(obrabotka);
        button3.addActionListener(obrabotka);
        button4.addActionListener(obrabotka);
        button5.addActionListener(obrabotka);
        button6.addActionListener(obrabotka);
        button7.addActionListener(obrabotka);
        button8.addActionListener(obrabotka);
        button9.addActionListener(obrabotka);
        buttonPoint.addActionListener(obrabotka);
        buttonEqual.addActionListener(obrabotka);
        buttonP.addActionListener(obrabotka);
        buttonM.addActionListener(obrabotka);
        buttonU.addActionListener(obrabotka);
        buttonR.addActionListener(obrabotka);
        buttonC.addActionListener(obrabotka);
        buttonS.addActionListener(obrabotka);
        buttonZ.addActionListener(obrabotka);
        // buttonX.addActionListener(obrabotka);;

    }

    private class Obrabotchik implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ////////////////////////////////////////////////////////
            Class[] classes = new Class[]{CalculationsInterface.class};
            CalculationsInterface proxy = (CalculationsInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    classes, new MyProxy(new Calculations()));
            //proxy.getCalculation("11+22=");
            ////////////////////////////////////////////////////////
            JButton clickedButton = (JButton) event.getSource();
            String string = "";
            char[] chArr;
            boolean bool = true;

            try {
                byte[] bytes = clickedButton.getText().toString().getBytes("ascii");
                if ((bytes[0] >= 48) && (bytes[0] <= 57)) {
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            switch (clickedButton.getText()) {
                case ".":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 46 || c == 61) bool = false;
                        if (c == 45 || c == 43 || c == 47 || c == 42) bool = true;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                    break;
                case "=":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);

                        try {
                            Calculations calculations = new Calculations(/*displayField.getText()*/);
                            //string = calculations.getCalculation(displayField.getText());
                            string = proxy.getCalculation(displayField.getText());
                            displayField.setText(displayField.getText() + string);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Некорректное выражение!");
                        }
                    }
                    break;
                case "*":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 45 || c == 43 || c == 47 || c == 42 || c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                    break;
                case "/":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 45 || c == 43 || c == 47 || c == 42 || c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                    break;
                case "+":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 45 || c == 43 || c == 47 || c == 42 || c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                    break;
                case "-":
                    chArr = displayField.getText().toCharArray();
                    for (char c : chArr) {
                        if (c == 45 || c == 43 || c == 47 || c == 42 || c == 61) bool = false;
                    }
                    if (bool) {
                        string = clickedButton.getText();
                        displayField.setText(displayField.getText() + string);
                    }
                    break;
                case "<-":
                    if (displayField.getText().length() > 0) {
                        string = displayField.getText().substring(0, displayField.getText().length() - 1);
                        displayField.setText(string);
                    }
                    break;
                case "C":
                    displayField.setText("");
                    break;
            }
            //JOptionPane.showMessageDialog(null, string);
//            Class[] classes =new Class[]{CalculationsInterface.class};
//            CalculationsInterface proxy = (CalculationsInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
//                    classes,new MyProxy(new Calculations()));
//            proxy.getCalculation("11+22=");
        }
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();


    }
}
