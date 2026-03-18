package proyecto101;

import javax.swing.JFrame;

public class Proyecto101 {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(900, 700);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
