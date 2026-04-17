package AdminTemas;
import javax.swing.*;
import java.awt.*;
public class AdminTemas {
    private static boolean modoOscuro = false;

    // Alternar el estado del modo oscuro
    public static void toggleModoOscuro() {
        modoOscuro = !modoOscuro;
    }

    // Obtener colores base.
    public static Color getFondo() {
        return modoOscuro ? new Color(30,30,30) : Color.WHITE;
    }

    public static Color getTexto() {
        return modoOscuro ? Color.WHITE : Color.BLACK;
    }

    // Actualizar iconos de botones según el modo.
    public static void actualizarIconos(JButton btnMenu, ImageIcon iconoMenuClaro, ImageIcon iconoMenuOscuro,
                                        JButton btnCarrito, ImageIcon iconoCarritoClaro, ImageIcon iconoCarritoOscuro,
                                        JButton btnFavoritos, ImageIcon iconoFavsClaro, ImageIcon iconoFavsOscuro,
                                        JButton adelante, ImageIcon iconoAdelanteClaro, ImageIcon iconoAdelanteOscuro,
                                        JButton atras, ImageIcon iconoAtrasClaro, ImageIcon iconoAtrasOscuro) {
        btnMenu.setIcon(modoOscuro ? iconoMenuClaro : iconoMenuOscuro);
        btnCarrito.setIcon(modoOscuro ? iconoCarritoClaro : iconoCarritoOscuro);
        btnFavoritos.setIcon(modoOscuro ? iconoFavsClaro : iconoFavsOscuro);
        adelante.setIcon(modoOscuro ? iconoAdelanteClaro : iconoAdelanteOscuro);
        atras.setIcon(modoOscuro ? iconoAtrasClaro : iconoAtrasOscuro);
    }

    // Aplicar tema recursivamente.
    public static void aplicarTemaRecursivo(Component c, Color fondo, Color texto) {
        if (c instanceof JPanel) {
            c.setBackground(fondo);
            for (Component hijo : ((JPanel) c).getComponents()) {
                aplicarTemaRecursivo(hijo, fondo, texto);
            }
        } else if (c instanceof JButton) {
            if(((JButton)c).getIcon() == null) {
                c.setBackground(fondo);
            }
            ((JButton) c).setForeground(texto);
        } else if (c instanceof JLabel) {
            ((JLabel) c).setForeground(texto);
        } else if (c instanceof JCheckBox || c instanceof JRadioButton) {
            c.setBackground(fondo);
            c.setForeground(texto);
        }
    }
}
