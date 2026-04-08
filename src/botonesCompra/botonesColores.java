package botonesCompra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class botonesColores extends JRadioButton {

    // 1. Constantes PUBLICAS (Solo una lista, los índices coinciden para ambos arreglos)
    public static final int AMARILLO_BLANCO_AZUL = 0;
    public static final int AZUL = 1;
    public static final int BLANCO = 2;
    public static final int BLANCO_AZUL = 3;
    public static final int BLANCO_NEGRO = 4;
    public static final int BLANCO_NEGRO_ROJO = 5;
    public static final int BLANCO_ROJO = 6;
    public static final int GRIS = 7;
    public static final int NEGRO = 8;
    public static final int ROJO = 9;
    public static final int VERDE = 10;

    // 2. Arreglos de imágenes (Usando el método auxiliar de abajo para que sea más limpio)
    private Icon[] colores = {
        escalar("Amarillo_Blanco_Azul.png"),
        escalar("Azul.png"),
        escalar("Blanco.png"),
        escalar("Blanco_Azul.png"),
        escalar("Blanco_Negro.png"),
        escalar("Blanco_Negro_Rojo.png"),
        escalar("Blanco_Rojo.png"),
        escalar("Gris.png"),
        escalar("Negro.png"),
        escalar("Rojo.png"),
        escalar("Verde.png")
    };

    private Icon[] coloresBorde = {
        escalar("Borde_Amarillo_Blanco_Azul.png"),
        escalar("Borde_Azul.png"),
        escalar("Borde_Blanco.png"),
        escalar("Borde_Blanco_Azul.png"),
        escalar("Borde_Blanco_Negro.png"),
        escalar("Borde_Blanco_Negro_Rojo.png"),
        escalar("Borde_Blanco_Rojo.png"),
        escalar("Borde_Gris.png"),
        escalar("Borde_Negro.png"),
        escalar("Borde_Rojo.png"),
        escalar("Borde_Verde.png")
    };

    // =======================================================
    // 3. EL CONSTRUCTOR (El puente que te faltaba)
    // =======================================================
    public botonesColores(int colorElegido) {
        
        // Magia de Java: Asignamos las imágenes usando el número que nos pasan
        this.setIcon(colores[colorElegido]);
        this.setSelectedIcon(coloresBorde[colorElegido]);
        
        // Limpieza visual: quitamos los cuadritos feos por defecto del RadioButton
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setBackground(Color.WHITE); 

        // Fijamos el tamaño (30x30 es un buen tamaño para clics, pero puedes cambiarlo)
        Dimension tam = new Dimension(30, 30);
        this.setPreferredSize(tam);
        this.setMaximumSize(tam);
        this.setMinimumSize(tam);
    }
    
    // =======================================================
    // 4. MÉTODO AUXILIAR PARA ESCALAR
    // =======================================================
    private ImageIcon escalar(String nombreArchivo) {
        // Asume que las imágenes están en la misma carpeta que esta clase
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(nombreArchivo));
        // Las escalamos automáticamente a 25x25 (para que quepan en el botón de 30x30)
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }
}