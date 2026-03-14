
package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Diego
 */
public class Ventana extends JFrame{
    private JPanel panelNorte;
    private JPanel panelSur;
    private JPanel panelEste;
    private JPanel panelOeste;
    private JPanel panelCentro;
    
    
    public Ventana(){
    super("Tienda de tenis");
    setLayout(new BorderLayout(5,5));

        initNorte();
        initOeste();
        initCentro();
        initEste();
        initSur();

    
    }

    private void initNorte() {
        panelNorte = new JPanel(new BorderLayout());
        JButton btnMenu = new JButton(new ImageIcon(getClass().getResource("menu.png")));
        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        JButton btnCarrito = new JButton(new ImageIcon(getClass().getResource("carrito.png")));
        JButton btnBuscar = new JButton(new ImageIcon(getClass().getResource("buscar.png")));
        
        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panelIzquierdo.add(btnMenu);
        
        JPanel panelDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
        panelDerecha.add(btnBuscar);
        panelDerecha.add(btnCarrito);
    

        panelNorte.add(panelIzquierdo, BorderLayout.WEST);
        panelNorte.add(logo, BorderLayout.CENTER);
        panelNorte.add(panelDerecha, BorderLayout.EAST);

        add(panelNorte, BorderLayout.NORTH);
    }

    private void initOeste() {
    }

    private void initCentro() {
    }

    private void initEste() {
    }

    private void initSur() {
    }
}
