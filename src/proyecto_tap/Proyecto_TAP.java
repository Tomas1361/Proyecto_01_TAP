package proyecto_tap;

import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class Proyecto_TAP {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            Ventana ventana = new Ventana();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(900,600);
            ventana.setResizable(false);
            ventana.setVisible(true);
    });
    }
}
