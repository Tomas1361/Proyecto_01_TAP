package proyecto_tap;
//@author tomas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    private JPanel producto1 = crearProducto("Producto 1", "Descripción corta", "$120", Color.RED);
    private JPanel producto2 = crearProducto("Producto 2", "Descripción corta", "$80", Color.GREEN);
    private JPanel producto3 = crearProducto("Producto 3", "Descripción corta", "$200", Color.BLUE);
    private JLabel lInfo,lImagen,lNombre,lPrecio;

    public Ventana() {
        
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelProductos.setBackground(Color.WHITE);
        panelProductos.setPreferredSize(new Dimension(800, 300));

        panelProductos.add(producto1);
        panelProductos.add(producto2);
        panelProductos.add(producto3);

        add(panelProductos, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel crearProducto(String nombre, String info, String precio, Color color) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 180));
        panel.setBackground(color);
        panel.setLayout(new BorderLayout());
        

        JLabel imagen = new JLabel("Imagen", SwingConstants.CENTER);
        imagen.setPreferredSize(new Dimension(150, 80));
        imagen.setForeground(Color.WHITE);

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(3,1));
        panelTexto.setOpaque(false);

        JLabel labelNombre = new JLabel(nombre, SwingConstants.CENTER);
        labelNombre.setForeground(Color.WHITE);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel lInfo = new JLabel(info, SwingConstants.CENTER);
        lInfo.setForeground(Color.WHITE);

        JLabel lPrecio = new JLabel(precio, SwingConstants.CENTER);
        lPrecio.setForeground(Color.YELLOW);

        panelTexto.add(labelNombre);
        panelTexto.add(lInfo);
        panelTexto.add(lPrecio);

        panel.add(imagen, BorderLayout.NORTH);
        panel.add(panelTexto, BorderLayout.CENTER);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setPreferredSize(new Dimension(200, 220));
                panel.revalidate();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setPreferredSize(new Dimension(150, 180));
                panel.revalidate();
            }
        });
        return panel;
    }}


