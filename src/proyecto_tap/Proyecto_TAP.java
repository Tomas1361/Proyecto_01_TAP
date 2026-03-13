
package proyecto_tap;

public class Proyecto_TAP {

    public static void main(String[] args) {
            SwingUtilities.invokeLater(()->{
            Ventana ventana= new Ventana();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(700,400);
            ventana.setLocationRelativeTo(null);
            ventana.setResizable(false);
            ventana.setVisible(true);
        });
    }
    
}
