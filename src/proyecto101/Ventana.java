package proyecto101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame {

    private ImageIcon converse[] = {
        new ImageIcon(getClass().getResource("ConverseNegro.png")),
        new ImageIcon(getClass().getResource("ConverseAzul.png")),
        new ImageIcon(getClass().getResource("ConverseRojo.png"))
    };
    private ImageIcon coloresConverse[] = {
        new ImageIcon(getClass().getResource("Negro.png")),
        new ImageIcon(getClass().getResource("Azul.png")),
        new ImageIcon(getClass().getResource("Rojo.png")),
        new ImageIcon(getClass().getResource("Borde_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Azul.png")),
        new ImageIcon(getClass().getResource("Borde_Rojo.png"))
    };
    private ImageIcon airForce[] = {
        new ImageIcon(getClass().getResource("AirForceBlanco.png")),
        new ImageIcon(getClass().getResource("AirForceNegro.png")),
        new ImageIcon(getClass().getResource("AirForceRojo.png"))
    };
    private ImageIcon coloresAirForce[] = {
        new ImageIcon(getClass().getResource("Blanco.png")),
        new ImageIcon(getClass().getResource("Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Blanco_Rojo.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Rojo.png")),};
    private ImageIcon airJordan[] = {
        new ImageIcon(getClass().getResource("AirJordanBYN.png")),
        new ImageIcon(getClass().getResource("AirJordanAzul.png")),
        new ImageIcon(getClass().getResource("AirJordanBlanco.png")),
        new ImageIcon(getClass().getResource("AirJordanNegro.png"))
    };
    private ImageIcon coloresJordan[] = {
        new ImageIcon(getClass().getResource("Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Blanco_Azul.png")),
        new ImageIcon(getClass().getResource("Blanco.png")),
        new ImageIcon(getClass().getResource("Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Azul.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco.png")),
        new ImageIcon(getClass().getResource("Borde_Negro.png"))
    };
    private ImageIcon campus[] = {
        new ImageIcon(getClass().getResource("Campus00sBlanco.png")),
        new ImageIcon(getClass().getResource("Campus00sNCR.png")),
        new ImageIcon(getClass().getResource("Campus00sNegro.png")),
        new ImageIcon(getClass().getResource("Campus00sNegroAzul.png"))
    };
    private ImageIcon coloresCampus[] = {
        new ImageIcon(getClass().getResource("Blanco.png")),
        new ImageIcon(getClass().getResource("Blanco_Negro_Rojo.png")),
        new ImageIcon(getClass().getResource("Negro.png")),
        new ImageIcon(getClass().getResource("Azul.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Negro_Rojo.png")),
        new ImageIcon(getClass().getResource("Borde_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Azul.png"))
    };
    private ImageIcon stars[] = {
        new ImageIcon(getClass().getResource("StarsNegros.png")),
        new ImageIcon(getClass().getResource("StarsAmarillos.png"))
    };
    private ImageIcon coloresStars[] = {
        new ImageIcon(getClass().getResource("Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Amarillo_Blanco_Azul.png")),
        new ImageIcon(getClass().getResource("Borde_Blanco_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Amarillo_Blanco_Azul.png"))
    };
    private ImageIcon under[] = {
        new ImageIcon(getClass().getResource("Under_Negro.png")),
        new ImageIcon(getClass().getResource("Under_Gris.png")),
        new ImageIcon(getClass().getResource("Under_Azul.png")),
        new ImageIcon(getClass().getResource("Under_Rojo.png")),
        new ImageIcon(getClass().getResource("Under_Verde.png"))
    };
    private ImageIcon coloresUnder[] = {
        new ImageIcon(getClass().getResource("Negro.png")),
        new ImageIcon(getClass().getResource("Gris.png")),
        new ImageIcon(getClass().getResource("Azul.png")),
        new ImageIcon(getClass().getResource("Rojo.png")),
        new ImageIcon(getClass().getResource("Verde.png")),
        new ImageIcon(getClass().getResource("Borde_Negro.png")),
        new ImageIcon(getClass().getResource("Borde_Gris.png")),
        new ImageIcon(getClass().getResource("Borde_Azul.png")),
        new ImageIcon(getClass().getResource("Borde_Rojo.png")),
        new ImageIcon(getClass().getResource("Borde_Verde.png"))
    };

    // Atributos de los productos
    private JPanel producto1 = crearProducto("Converse", 1599, "Tenis Converse Chuck Taylor All Star Negros en Bota de Lona Unisex", converse, coloresConverse);
    private JPanel producto2 = crearProducto("Air Force 1", 2399, "Tenis Unisex Nike Air Force 1 '07 Cw2288-111", airForce, coloresAirForce);
    private JPanel producto3 = crearProducto("Air Jordan 3", 4299, "Nike WMNS Air Jordan 3 RETRO", airJordan, coloresJordan);
    private JPanel producto4 = crearProducto("Campus 00s", 2299, "Tenis Adidas Campus 00's Clasico Original", campus, coloresCampus);
    private JPanel producto5 = crearProducto("Stars", 799, "TENIS HOMBRE STARS CU413", stars, coloresStars);
    private JPanel producto6 = crearProducto("UA Rogue 4", 1699, "Tenis deportivos Under Armour ligeros con suela blanca texturizada.", under, coloresUnder);

    private JPanel listaProductos[] = {producto1, producto2, producto3, producto4, producto5, producto6};

    private JButton adelante, atras;
    private int rango = 3;
    private int interbalo = 1;

    private final int anchoAnuncios = 900;
    private final int altoAnuncios = 400;

    // Paneles generales
    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel central;
    private JPanel panelProductos;

    // Atributos integrados del primer código (Ofertas)

    // Atributos del menu hamburguesa y modo oscuro
    private JPanel panelMenu; // Panel lateral del menú
    private boolean activedMenu = false;
    private boolean modoOscuro = false;
    private JButton btnMenu;
    private JButton btnCarrito;
    private JButton btnBuscar;
    private ImageIcon iconoMenuOscuro;
    private ImageIcon iconoMenuClaro;
    private ImageIcon iconoCarritoOscuro;
    private ImageIcon iconoCarritoClaro;
    private ImageIcon iconoFavsOscuro;
    private ImageIcon iconoFavsClaro;
    private ImageIcon iconoAdelanteClaro;
    private ImageIcon iconoAdelanteOscuro;
    private ImageIcon iconoAtrasClaro;
    private ImageIcon iconoAtrasOscuro;

    private JFrame ventana = this;

    // Arreglo para la ventana de "Favoritos"
    private java.util.List<JPanel> favoritos = new ArrayList<>();
    // Arreglo para la ventana de Carrito
    private java.util.List<CarritoItem> carrito = new ArrayList<>();
    
    // Clase interna para guardar datos del carrito
    private class CarritoItem {

        String nombre;
        ImageIcon imagen;
        int precio;

        CarritoItem(String nombre, ImageIcon imagen, int precio) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.precio = precio;
        }
    }

    public Ventana() {
        super("Tienda de tenis");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        atajo(ventana);

        central = new JPanel(new BorderLayout());

        adelante = new JButton(new ImageIcon(getClass().getResource("Adelante.png")));
        adelante.setContentAreaFilled(false);
        adelante.setBorderPainted(false);
        adelante.setFocusPainted(false);
        atras = new JButton(new ImageIcon(getClass().getResource("Atras.png")));
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);

        // Configuración del panel de productos (Sur)
        panelProductos = new JPanel();
        panelProductos.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelProductos.setBackground(Color.WHITE);

        panelProductos.add(atras, BorderLayout.WEST);
        mostrar(panelProductos);

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (interbalo > 1) {
                    interbalo--;
                } else {
                    interbalo = 2;
                }
                mostrar(panelProductos);
            }
        });

        adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (interbalo < (listaProductos.length / 3)) {
                    interbalo++;
                } else {
                    interbalo = 1;
                }
                mostrar(panelProductos);
            }
        });

        // Inicializar las diferentes zonas de la ventana
        initNorte();
        initCentro(); // Aquí se integran las imágenes de las ofertas

        panelMenu = new JPanel();
        panelMenu.setBackground(Color.BLACK); // O LIGHT_GRAY según prefieras
        panelMenu.setPreferredSize(new Dimension(150, getHeight())); // ancho fijo
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        // Ejemplo de opciones dentro del menú
        JButton inicio = new JButton("Inicio");
        inicio.setForeground(Color.WHITE);
        inicio.setBackground(Color.BLACK);
        inicio.setBorderPainted(false);
        inicio.setFocusPainted(false);
        panelMenu.add(inicio);

        // Botón Modo Oscuro agregado del Código 1
        JButton oscuro = new JButton("Modo Oscuro");
        oscuro.setForeground(Color.WHITE);
        oscuro.setBackground(Color.BLACK);
        oscuro.setBorderPainted(false);
        oscuro.setFocusPainted(false);
        oscuro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleModoOscuro();
            }
        });
        panelMenu.add(oscuro);
        
        JButton ofertas = new JButton("Creditos");
        ofertas.setForeground(Color.WHITE);
        ofertas.setBackground(Color.BLACK);
        ofertas.setBorderPainted(false);
        ofertas.setFocusPainted(false);
        ofertas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelCentro, """
                                                    Creditos:
                                                    Marcos García López
                                                    Pedro Tomás Gutiérrez González
                                                    Ricardo Ottmar Gutiérrez Guzmán
                                                    Diego Palacio Flores
                                                    Maria Guadalupe Zuñiga Alcantar""");
            }
            
        });
        panelMenu.add(ofertas);
        
        panelMenu.setVisible(false); // empieza oculto
        add(panelMenu, BorderLayout.WEST);
        

        // Agregar el panel de productos a la parte inferior
        add(panelProductos, BorderLayout.SOUTH);

        central.add(panelNorte, BorderLayout.NORTH);
        central.add(panelCentro, BorderLayout.CENTER);
        central.add(panelProductos, BorderLayout.SOUTH);
        add(central, BorderLayout.CENTER);
        add(new JLabel("Claro/Oscuro -> Ctrl + T"), BorderLayout.SOUTH);

        // Configuración final de la ventana principal
        setSize(850, 600);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    private JPanel crearProducto(String nombre, int precio, String descripcion, ImageIcon[] listaIconos, ImageIcon[] listaColores) {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 180));
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JLabel imagen = new JLabel("", SwingConstants.CENTER);
        imagen.setPreferredSize(new Dimension(130, 130));
        imagen.setIcon(new ImageIcon(listaIconos[0].getImage().getScaledInstance(imagen.getPreferredSize().width, imagen.getPreferredSize().height, Image.SCALE_SMOOTH)));

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(3, 1));
        panelTexto.setOpaque(false);

        JLabel labelNombre = new JLabel(nombre, SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel labelPrecio = new JLabel(String.format("$%d MXN", precio), SwingConstants.CENTER);
        labelPrecio.setFont(new Font("Arial", Font.BOLD, 16));

        panelTexto.add(labelNombre);
        panelTexto.add(labelPrecio);

        panel.add(imagen, BorderLayout.NORTH);
        panel.add(panelTexto, BorderLayout.CENTER);

        // Eventos del ratón para el efecto hover y el clic
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setPreferredSize(new Dimension(200, 220));
                panel.revalidate();
                panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setPreferredSize(new Dimension(150, 180));
                panel.revalidate();
                panel.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Abre una ventana sencilla con el nombre del modelo al hacer clic
                JFrame detalleTenis = new JFrame(nombre);
                JPanel panelTenis = new JPanel(new FlowLayout());

                panelTenis.setBackground(Color.WHITE);
                mostrarTenis(panelTenis, listaIconos, listaColores, descripcion, precio, nombre);
                detalleTenis.add(panelTenis);
                detalleTenis.setSize(750, 500);
                detalleTenis.setLocationRelativeTo(ventana);
                detalleTenis.setResizable(false);
                detalleTenis.setVisible(true);
            }
        });
        return panel;
    }

    private void initNorte() {
        panelNorte = new JPanel(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(700, 75));
        panelNorte.setBackground(Color.WHITE);

        // Carga de imágenes para el menú superior
        iconoMenuClaro = new ImageIcon(getClass().getResource("menuB.png"));
        iconoMenuOscuro = new ImageIcon(getClass().getResource("menu.png"));
        iconoFavsClaro = new ImageIcon(getClass().getResource("favoritosB.png"));
        iconoFavsOscuro = new ImageIcon(getClass().getResource("favoritos.png"));
        iconoCarritoClaro = new ImageIcon(getClass().getResource("carritoB.png"));
        iconoCarritoOscuro = new ImageIcon(getClass().getResource("carrito.png"));
        iconoAdelanteClaro = new ImageIcon(getClass().getResource("AdelanteB.png"));
        iconoAdelanteOscuro = new ImageIcon(getClass().getResource("Adelante.png"));
        iconoAtrasClaro = new ImageIcon(getClass().getResource("AtrasB.png"));
        iconoAtrasOscuro = new ImageIcon(getClass().getResource("Atras.png"));

        btnMenu = new JButton(iconoMenuOscuro);
        // Funcionamiento del boton del menu
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activedMenu = !activedMenu;
                panelMenu.setVisible(activedMenu);
                ventana.revalidate();
                ventana.repaint();
            }
        });
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusPainted(false);

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        btnCarrito = new JButton(new ImageIcon(getClass().getResource("carrito.png")));

        // Funcionamiento del botón del carrito (Panel Superior)
        btnCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaCarrito = new JFrame("Carrito de Compras");
                JPanel panelCarrito = new JPanel(new FlowLayout());
                panelCarrito.setBackground(Color.WHITE);
                JButton comprar = new JButton();
                int total = 0;
                
                for (CarritoItem item : carrito) {
                    JPanel prod = new JPanel(new BorderLayout());
                    prod.setBackground(Color.WHITE);

                    JLabel img = new JLabel(new ImageIcon(
                            item.imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)
                    ));
                    JLabel nombre = new JLabel(item.nombre, SwingConstants.CENTER);
                    nombre.setBackground(Color.WHITE);

                    comprar.setBackground(Color.BLACK);
                    comprar.setForeground(Color.WHITE);
                    prod.add(img, BorderLayout.CENTER);
                    prod.add(nombre, BorderLayout.NORTH);

                    panelCarrito.add(prod);
                    total += item.precio;
                    comprar.setText(String.format("Comprar $%d MNX", total));
                }
                    ventanaCarrito.add(comprar, BorderLayout.SOUTH);
                ventanaCarrito.add(new JScrollPane(panelCarrito));
                ventanaCarrito.setSize(600, 400);
                ventanaCarrito.setLocationRelativeTo(ventana);
                ventanaCarrito.setVisible(true);
            }
        });
        btnCarrito.setContentAreaFilled(false);
        btnCarrito.setBorderPainted(false);
        btnCarrito.setFocusPainted(false);

        btnBuscar = new JButton(new ImageIcon(getClass().getResource("favoritos.png")));
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaFavs = new JFrame("Favoritos");
                JPanel panelFavs = new JPanel(new FlowLayout());
                panelFavs.setBackground(Color.WHITE);

                // Mostrar todos los favoritos
                for (JPanel prod : favoritos) {
                    panelFavs.add(prod);
                }

                ventanaFavs.add(new JScrollPane(panelFavs)); // scroll si hay muchos
                ventanaFavs.setSize(600, 400);
                ventanaFavs.setLocationRelativeTo(ventana);
                ventanaFavs.setVisible(true);
            }
        });

        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelIzquierdo.add(btnMenu);
        panelIzquierdo.setBackground(Color.WHITE);

        JPanel panelDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        panelDerecha.add(btnBuscar);
        panelDerecha.add(btnCarrito);
        panelDerecha.setBackground(Color.WHITE);

        panelNorte.add(panelIzquierdo, BorderLayout.WEST);
        panelNorte.add(logo, BorderLayout.CENTER);
        panelNorte.add(panelDerecha, BorderLayout.EAST);
    }

    private void initCentro() {
        // Inicialización a nivel de clase
        panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setBackground(new Color(220, 220, 220));

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel anuncios = new JLabel();
        ImageIcon listaAnuncios[] = {
            new ImageIcon(getClass().getResource("Banner (1).png")),
            new ImageIcon(getClass().getResource("Banner (2).png")),
            new ImageIcon(getClass().getResource("Banner (3).png")),
            new ImageIcon(getClass().getResource("Banner (4).png")),
            new ImageIcon(getClass().getResource("Banner (5).png"))
        };

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        anuncios.setPreferredSize(new Dimension(anchoAnuncios, altoAnuncios));
        anuncios.setIcon(new ImageIcon(listaAnuncios[0].getImage().getScaledInstance(anchoAnuncios, altoAnuncios, Image.SCALE_SMOOTH)));
        panelCentro.add(anuncios, gbc);
        Timer timer;
        timer = new Timer(5000, new ActionListener() {
            int i = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                anuncios.setIcon(new ImageIcon(listaAnuncios[i].getImage().getScaledInstance(anchoAnuncios, altoAnuncios, Image.SCALE_SMOOTH)));
                i++;
                if (i >= listaAnuncios.length) {
                    i = 0;
                }
            }
        });
        timer.start();
    }

    private void mostrarTenis(JPanel panel, ImageIcon[] listaIconos, ImageIcon[] listaColores, String desc, int prec, String nombre) {
        JRadioButton colores[] = new JRadioButton[listaIconos.length];
        ButtonGroup grupoColores = new ButtonGroup();
        JLabel lblTeni = new JLabel(new ImageIcon(listaIconos[0].getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        JPanel panelDetallesTenis = new JPanel();
        JLabel descripcion = new JLabel("<html>" + desc + "</html>");
        JLabel costo = new JLabel(String.format("$%d MXN", prec));
        JButton comprar = new JButton("Comprar");
        JButton btnCarrito = new JButton(new ImageIcon(getClass().getResource("Carrito_blanco.png")));

        // Agregar producto a la ventana de carrito
        btnCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.add(new CarritoItem(nombre, listaIconos[0], prec));
                JOptionPane.showMessageDialog(panel, "Producto agregado al carrito");
            }
        });
        JCheckBox favs = new JCheckBox(new ImageIcon(getClass().getResource("favoritos.png")));

        // Agregar producto a la ventana de favoritos
        favs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (favs.isSelected()) {
                    favs.setIcon(new ImageIcon(getClass().getResource("favorito_Seleccionado.png")));
                    favoritos.add(panel); // agrega el panel del producto a la lista
                } else {
                    favs.setIcon(new ImageIcon(getClass().getResource("favoritos.png")));
                    favoritos.remove(panel); // lo quita de la lista si se desmarca
                }
            }
        });

        descripcion.setFont(new Font("Arial", Font.PLAIN, 16));
        descripcion.setAlignmentX(Component.LEFT_ALIGNMENT);
        costo.setFont(new Font("Arial", Font.BOLD, 18));
        costo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelDetallesTenis.setPreferredSize(new Dimension(300, 300));
        panelDetallesTenis.setLayout(new BoxLayout(panelDetallesTenis, BoxLayout.Y_AXIS));
        panelDetallesTenis.setBackground(Color.WHITE);

        Dimension tamBotones = new Dimension(panelDetallesTenis.getPreferredSize().width, 50);

        comprar.setPreferredSize(tamBotones);
        comprar.setMaximumSize(tamBotones);
        comprar.setBackground(Color.BLACK);
        comprar.setForeground(Color.WHITE);
        comprar.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnCarrito.setPreferredSize(tamBotones);
        btnCarrito.setMaximumSize(tamBotones);
        btnCarrito.setBackground(Color.BLACK);
        btnCarrito.setForeground(Color.WHITE);
        btnCarrito.setAlignmentX(Component.LEFT_ALIGNMENT);

        favs.setContentAreaFilled(false);

        panelDetallesTenis.add(descripcion);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(costo);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(comprar);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(btnCarrito);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(favs);

        panel.add(lblTeni);
        panel.add(panelDetallesTenis);
        for (int i = 0; i < colores.length; i++) {
            colores[i] = new JRadioButton("", new ImageIcon(listaColores[i].getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)), (i == 0));
            colores[i].setPreferredSize(new Dimension(30, 30));
            colores[i].setSelectedIcon(new ImageIcon(listaColores[i + (listaColores.length / 2)].getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            colores[i].setBackground(Color.WHITE);
            grupoColores.add(colores[i]);
            panel.add(colores[i]);
            final int indice = i;
            colores[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    lblTeni.setIcon(new ImageIcon(listaIconos[indice].getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
                }
            });
        }
    }

    private void mostrar(JPanel panelProducto) {
        for (int i = 0; i < listaProductos.length; i++) {
            panelProducto.add(listaProductos[i]);
            listaProductos[i].setVisible(false);
        }
        for (int i = (rango * (interbalo - 1)); i < (rango * interbalo); i++) {
            panelProducto.add(listaProductos[i]);
            listaProductos[i].setVisible(true);
        }
        panelProducto.add(adelante);
    }

    private void atajo(JFrame panel) {
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_T) {
                    toggleModoOscuro();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    private void toggleModoOscuro() {
        modoOscuro = !modoOscuro;

        Color fondo = modoOscuro ? Color.BLACK : Color.WHITE;
        Color texto = modoOscuro ? Color.WHITE : Color.BLACK;

        // Cambiando dinámicamente el icono del menú hamburguesa
        btnMenu.setIcon(modoOscuro ? iconoMenuClaro : iconoMenuOscuro);
        btnCarrito.setIcon(modoOscuro ? iconoCarritoClaro : iconoCarritoOscuro);
        btnBuscar.setIcon(modoOscuro ? iconoFavsClaro : iconoFavsOscuro);
        adelante.setIcon(modoOscuro ? iconoAdelanteClaro : iconoAdelanteOscuro);
        atras.setIcon(modoOscuro ? iconoAtrasClaro : iconoAtrasOscuro);

        // Paneles principales
        panelNorte.setBackground(fondo);
        panelMenu.setBackground(Color.BLACK); // Mantiene el fondo del menú constante
        panelCentro.setBackground(fondo);
        panelProductos.setBackground(fondo);
        getContentPane().setBackground(fondo);

        // Aplicar tema a todos los componentes dentro de cada panel
        aplicarTema(panelNorte, fondo, texto);
        aplicarTema(panelMenu, fondo, texto);
        aplicarTema(panelCentro, fondo, texto);
        aplicarTema(panelProductos, fondo, texto);

        ventana.revalidate();
        ventana.repaint();
    }

    private void aplicarTema(Component c, Color fondo, Color texto) {
        if (c instanceof JPanel) {
            c.setBackground(fondo);
            for (Component hijo : ((JPanel) c).getComponents()) {
                aplicarTema(hijo, fondo, texto);
            }
        } else if (c instanceof JButton) {
            c.setBackground(fondo);
            ((JButton) c).setForeground(texto);
        } else if (c instanceof JLabel) {
            ((JLabel) c).setForeground(texto);
        } else if (c instanceof JCheckBox) {
            c.setBackground(fondo);
            ((JCheckBox) c).setForeground(texto);
        } else if (c instanceof JRadioButton) {
            c.setBackground(fondo);
            ((JRadioButton) c).setForeground(texto);
        }
    }
}
