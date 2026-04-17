package botonesCompra;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Comprar extends JButton {

    // 1. Constantes
    public static final int NINGUNO = -1; // Estado base
    public static final int CARRITO = 0;
    public static final int COMPRAR = 1;
    
    // 2. Variable privada para el Getter y Setter
    private int tipoBotonActual = NINGUNO;
    
    // =======================================================
    // CONSTRUCTORES
    // =======================================================
    public Comprar(){
        this.setFont(new Font("Arial", Font.BOLD, 15));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setPreferredSize(new Dimension(300, 100));
        this.setMaximumSize(new Dimension(300,100));
        this.setMinimumSize(new Dimension(300,40));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public Comprar(int tipoBoton) {
        this(); // Llama al constructor de arriba para aplicar el diseño base
        this.setTipoBotonActual(tipoBoton); // Usa el Setter para configurarlo
    }

    // =======================================================
    // GETTER Y SETTER
    // =======================================================
    public int getTipoBotonActual() {
        return tipoBotonActual;
    }

    public void setTipoBotonActual(int tipoBoton) {
        this.tipoBotonActual = tipoBoton;

        // ASIGNACIÓN: Le damos su nueva identidad usando tus constantes
        switch (tipoBoton) {
            case CARRITO:
                Carrito(this);
                break;
            case COMPRAR:
                Comprar(this);
                break;
            case NINGUNO:
                // Se queda como un botón negro vacío
                break;
        }
    }

    // =======================================================
    // MÉTODOS DE CONFIGURACIÓN
    // =======================================================

    private void Carrito(JButton carrito) {
        carrito.setIcon(new ImageIcon(getClass().getResource("/proyecto101/carritoB.png")));
        
        carrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                carrito.setIcon(null);
                carrito.setText("SE AÑADIÓ AL CARRITO");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                carrito.setIcon(new ImageIcon(getClass().getResource("/proyecto101/carrito.png")));
                carrito.setBackground(Color.WHITE);
                carrito.setForeground(Color.BLACK);
                carrito.setText(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                carrito.setIcon(new ImageIcon(getClass().getResource("/proyecto101/carritoB.png")));
                carrito.setBackground(Color.BLACK);
                carrito.setForeground(Color.WHITE);
                carrito.setText(null);
            }
        });
    }

    private void Comprar(JButton comprar) {
        comprar.setText("Comprar");
        
        comprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                comprar.setText(null);
                comprar.setIcon(new ImageIcon(getClass().getResource("/proyecto101/comprado.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                comprar.setText("Comprar");
                comprar.setBackground(Color.WHITE);
                comprar.setForeground(Color.BLACK);
                comprar.setIcon(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                comprar.setText("Comprar");
                comprar.setBackground(Color.BLACK); 
                comprar.setForeground(Color.WHITE);
                comprar.setIcon(null);
            }
        });
    }
}