package calculadora;

import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        JFrame f = new JFrame("Calculadora");
        f.setSize(250, 300);
        f.setLocation(100, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MiPanel(), "Center");
        
        f.setVisible(true);
    }
}