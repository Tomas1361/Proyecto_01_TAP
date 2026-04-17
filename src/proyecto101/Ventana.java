package proyecto101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import botonesCompra.*;
import AdminTemas.*;

/**
 * Clase principal de la Interfaz Gráfica para la Tienda de Tenis.
 * Hereda de JFrame y configura todos los paneles, eventos y productos.
 */
public class Ventana extends JFrame {

    // ==============================================================================
    // 1. CONSTANTES Y CONFIGURACIÓN
    // ==============================================================================
    private final int ANCHO_ANUNCIOS = 900;
    private final int ALTO_ANUNCIOS = 400;
    private final int PRODUCTOS_POR_PAGINA = 3; // Anteriormente 'rango'

    // ==============================================================================
    // 2. VARIABLES DE ESTADO
    // ==============================================================================
    private int intervalo = 1; // Página actual del catálogo de productos
    private boolean menuActivado = false;
    private boolean modoOscuro = false;
    private boolean carritoComprado = false;
    
    // Listas para manejar el carrito y los favoritos
    private java.util.List<JPanel> favoritos = new ArrayList<>();
    private java.util.List<CarritoItem> carrito = new ArrayList<>();

    // ==============================================================================
    // 3. COMPONENTES DE LA INTERFAZ (UI)
    // ==============================================================================
    // Paneles principales
    private JPanel central;
    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelProductos;
    private JPanel panelMenu;
    private JPanel panelSur;

    // Botones de navegación y utilidades
    private JButton adelante;
    private JButton atras;
    private JButton btnMenu;
    private JButton btnCarrito;
    private JButton btnFavoritos; // Anteriormente btnBuscar

    // ==============================================================================
    // 4. RECURSOS GRÁFICOS (Iconos de la interfaz)
    // ==============================================================================
    private ImageIcon iconoMenuClaro, iconoMenuOscuro;
    private ImageIcon iconoCarritoClaro, iconoCarritoOscuro;
    private ImageIcon iconoFavsClaro, iconoFavsOscuro;
    private ImageIcon iconoAdelanteClaro, iconoAdelanteOscuro;
    private ImageIcon iconoAtrasClaro, iconoAtrasOscuro;

    // ==============================================================================
    // 5. DATOS DEL CATÁLOGO (Imágenes de los tenis)
    // ==============================================================================
    private ImageIcon[] converse = {
        new ImageIcon(getClass().getResource("ConverseNegro.png")),
        new ImageIcon(getClass().getResource("ConverseAzul.png")),
        new ImageIcon(getClass().getResource("ConverseRojo.png"))
    };
    private JRadioButton[] coloresConverse = {
        new botonesColores(botonesColores.NEGRO),
        new botonesColores(botonesColores.AZUL),
        new botonesColores(botonesColores.ROJO)
    };
    
    private ImageIcon[] airForce = {
        new ImageIcon(getClass().getResource("AirForceBlanco.png")),
        new ImageIcon(getClass().getResource("AirForceNegro.png")),
        new ImageIcon(getClass().getResource("AirForceRojo.png"))
    };
    private JRadioButton[] coloresAirForce = {
        new botonesColores(botonesColores.BLANCO),
        new botonesColores(botonesColores.NEGRO),
        new botonesColores(botonesColores.ROJO)
    };
    
    private ImageIcon[] airJordan = {
        new ImageIcon(getClass().getResource("AirJordanBYN.png")),
        new ImageIcon(getClass().getResource("AirJordanAzul.png")),
        new ImageIcon(getClass().getResource("AirJordanBlanco.png")),
        new ImageIcon(getClass().getResource("AirJordanNegro.png"))
    };
    private JRadioButton[] coloresJordan = {
        new botonesColores(botonesColores.BLANCO_NEGRO),
        new botonesColores(botonesColores.BLANCO_AZUL),
        new botonesColores(botonesColores.BLANCO),
        new botonesColores(botonesColores.NEGRO)
    };
    
    private ImageIcon[] campus = {
        new ImageIcon(getClass().getResource("Campus00sBlanco.png")),
        new ImageIcon(getClass().getResource("Campus00sNCR.png")),
        new ImageIcon(getClass().getResource("Campus00sNegro.png")),
        new ImageIcon(getClass().getResource("Campus00sNegroAzul.png"))
    };
    private JRadioButton[] coloresCampus = {
        new botonesColores(botonesColores.BLANCO),
        new botonesColores(botonesColores.BLANCO_NEGRO_ROJO),
        new botonesColores(botonesColores.NEGRO),
        new botonesColores(botonesColores.AZUL)
    };
    
    private ImageIcon[] stars = {
        new ImageIcon(getClass().getResource("StarsNegros.png")),
        new ImageIcon(getClass().getResource("StarsAmarillos.png"))
    };
    private JRadioButton[] coloresStars = {
        new botonesColores(botonesColores.BLANCO_NEGRO),
        new botonesColores(botonesColores.AMARILLO_BLANCO_AZUL)
    };
    
    private ImageIcon[] under = {
        new ImageIcon(getClass().getResource("Under_Negro.png")),
        new ImageIcon(getClass().getResource("Under_Gris.png")),
        new ImageIcon(getClass().getResource("Under_Azul.png")),
        new ImageIcon(getClass().getResource("Under_Rojo.png")),
        new ImageIcon(getClass().getResource("Under_Verde.png"))
    };
    private JRadioButton[] coloresUnder = {
        new botonesColores(botonesColores.NEGRO),
        new botonesColores(botonesColores.GRIS),
        new botonesColores(botonesColores.AZUL),
        new botonesColores(botonesColores.ROJO),
        new botonesColores(botonesColores.VERDE)
    };

    // Array que contendrá todos los paneles de productos generados.
    private JPanel[] listaProductos;

    // ==============================================================================
    // CLASE INTERNA PARA EL CARRITO
    // ==============================================================================
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

    // ==============================================================================
    // CONSTRUCTOR PRINCIPAL
    // ==============================================================================
    public Ventana() {
        super("Tienda de tenis");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        // Habilitar atajo de teclado para modo oscuro
        atajoTeclado();

        central = new JPanel(new BorderLayout());

        // Cargar iconos de botones de navegación
        iconoAdelanteClaro = new ImageIcon(getClass().getResource("AdelanteB.png"));
        iconoAdelanteOscuro = new ImageIcon(getClass().getResource("Adelante.png"));
        iconoAtrasClaro = new ImageIcon(getClass().getResource("AtrasB.png"));
        iconoAtrasOscuro = new ImageIcon(getClass().getResource("Atras.png"));

        adelante = configurarBotonTransparente(new JButton(iconoAdelanteOscuro));
        atras = configurarBotonTransparente(new JButton(iconoAtrasOscuro));

        // Configuración del panel inferior (Catálogo de productos)
        panelProductos = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelProductos.setBackground(Color.WHITE);

        // Inicializar los productos
        inicializarProductos();

        // Configurar acciones de botones de navegación del catálogo
        atras.addActionListener(e -> {
            if (intervalo > 1) {
                intervalo--;
            } else {
                intervalo = 2; // Si hay 6 productos y paginamos de 3 en 3, la última página es 2
            }
            mostrarProductosVisibles();
        });

        adelante.addActionListener(e -> {
            int maxIntervalo = (int) Math.ceil((double) listaProductos.length / PRODUCTOS_POR_PAGINA);
            if (intervalo < maxIntervalo) {
                intervalo++;
            } else {
                intervalo = 1;
            }
            mostrarProductosVisibles();
        });

        // Inicializar las diferentes zonas de la ventana principal
        initNorte();
        initMenuLateral();
        initCentro();// Aquí se integran las imágenes del carrusel de ofertas
        initSur();

        // Mostrar los primeros productos al iniciar
        mostrarProductosVisibles();

        // Ensamblar la ventana
        central.add(panelNorte, BorderLayout.NORTH);
        central.add(panelCentro, BorderLayout.CENTER);
        central.add(panelProductos, BorderLayout.SOUTH);
        
        add(central, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);
    }

    // ==============================================================================
    // MÉTODOS DE INICIALIZACIÓN DE LA UI
    // ==============================================================================
    
    /**
     * Inicializa el arreglo de productos creando los paneles correspondientes.
     */
    private void inicializarProductos() {
        listaProductos = new JPanel[]{
            crearProducto("Converse", 1599, "Tenis Converse Chuck Taylor All Star Negros en Bota de Lona Unisex", converse, coloresConverse),
            crearProducto("Air Force 1", 2399, "Tenis Unisex Nike Air Force 1 '07 Cw2288-111", airForce, coloresAirForce),
            crearProducto("Air Jordan 3", 4299, "Nike WMNS Air Jordan 3 RETRO", airJordan, coloresJordan),
            crearProducto("Campus 00s", 2299, "Tenis Adidas Campus 00's Clasico Original", campus, coloresCampus),
            crearProducto("Stars", 799, "TENIS HOMBRE STARS CU413", stars, coloresStars),
            crearProducto("UA Rogue 4", 1699, "Tenis deportivos Under Armour ligeros con suela blanca texturizada.", under, coloresUnder)
        };
    }

    /**
     * Configura el panel superior (Logo, menú hamburguesa, carrito, favoritos).
     */
    private void initNorte() {
        panelNorte = new JPanel(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(700, 75));
        panelNorte.setBackground(Color.WHITE);

        // Carga de imágenes para los botones superiores
        iconoMenuClaro = new ImageIcon(getClass().getResource("menuB.png"));
        iconoMenuOscuro = new ImageIcon(getClass().getResource("menu.png"));
        iconoFavsClaro = new ImageIcon(getClass().getResource("favoritosB.png"));
        iconoFavsOscuro = new ImageIcon(getClass().getResource("favoritos.png"));
        iconoCarritoClaro = new ImageIcon(getClass().getResource("carritoB.png"));
        iconoCarritoOscuro = new ImageIcon(getClass().getResource("carrito.png"));

        // Botón Menú Hamburguesa
        btnMenu = configurarBotonTransparente(new JButton(iconoMenuOscuro));
        btnMenu.addActionListener(e -> {
            menuActivado = !menuActivado;
            panelMenu.setVisible(menuActivado);
            revalidate();
            repaint();
        });

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        
        // Botón Carrito
        btnCarrito = configurarBotonTransparente(new JButton(iconoCarritoOscuro));
        btnCarrito.addActionListener(e -> abrirVentanaCarrito());

        // Botón Favoritos (anteriormente btnBuscar)
        btnFavoritos = configurarBotonTransparente(new JButton(iconoFavsOscuro));
        btnFavoritos.addActionListener(e -> abrirVentanaFavoritos());

        // Ensamblado del panel Norte
        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelIzquierdo.add(btnMenu);
        panelIzquierdo.setOpaque(false); // Permite heredar el color del panelNorte

        JPanel panelDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        panelDerecha.add(btnFavoritos);
        panelDerecha.add(btnCarrito);
        panelDerecha.setOpaque(false);

        panelNorte.add(panelIzquierdo, BorderLayout.WEST);
        panelNorte.add(logo, BorderLayout.CENTER);
        panelNorte.add(panelDerecha, BorderLayout.EAST);
    }

    /**
     * Configura el menú lateral desplegable.
     */
    private void initMenuLateral() {
        panelMenu = new JPanel();
        panelMenu.setBackground(Color.BLACK);
        panelMenu.setPreferredSize(new Dimension(150, getHeight()));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        // Botón Inicio
        JButton inicio = new JButton("Inicio");
        configurarBotonMenuLateral(inicio);
        panelMenu.add(inicio);

        // Botón Modo Oscuro
        JButton oscuro = new JButton("Modo Oscuro");
        configurarBotonMenuLateral(oscuro);
        oscuro.addActionListener(e -> toggleModoOscuro());
        panelMenu.add(oscuro);
        
        // Botón Créditos
        JButton creditos = new JButton("Créditos");
        configurarBotonMenuLateral(creditos);
        creditos.addActionListener(e -> {
            JOptionPane.showMessageDialog(panelCentro, """
                                                       Créditos:
                                                       Marcos García López
                                                       Pedro Tomás Gutiárrez Gonzáles
                                                       Ricardo Ottmar Gutiérrez Guzmán
                                                       Diego Palacio Flores
                                                       Maria Guadalupe Zuñiga Alcantar
                                                       """);
        });
        panelMenu.add(creditos);
        
        panelMenu.setVisible(false); // Inicia oculto
        add(panelMenu, BorderLayout.WEST);
    }

    /**
     * Configura el área central donde se encuentra el carrusel de anuncios.
     */
    private void initCentro() {
        panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setBackground(new Color(220, 220, 220));

        GridBagConstraints gbc = new GridBagConstraints();
        JLabel anuncios = new JLabel();
        
        ImageIcon[] listaAnuncios = {
            new ImageIcon(getClass().getResource("Banner (1).png")),
            new ImageIcon(getClass().getResource("Banner (2).png")),
            new ImageIcon(getClass().getResource("Banner (3).png")),
            new ImageIcon(getClass().getResource("Banner (4).png")),
            new ImageIcon(getClass().getResource("Banner (5).png"))
        };

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        anuncios.setPreferredSize(new Dimension(ANCHO_ANUNCIOS, ALTO_ANUNCIOS));
        anuncios.setIcon(escalarImagen(listaAnuncios[0], ANCHO_ANUNCIOS, ALTO_ANUNCIOS));
        
        panelCentro.add(anuncios, gbc);
        
        // Temporizador para el carrusel (5 segundos)
        Timer timer = new Timer(5000, new ActionListener() {
            int i = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                anuncios.setIcon(escalarImagen(listaAnuncios[i], ANCHO_ANUNCIOS, ALTO_ANUNCIOS));
                i = (i + 1) % listaAnuncios.length; // Lógica más limpia para reiniciar el índice
            }
        });
        timer.start();
    }
    
    private void initSur(){
        panelSur = new JPanel(new FlowLayout());
        panelSur.add(new JLabel("Claro/Oscuro -> Ctrl + T"));
        panelSur.setBorder(BorderFactory.createLineBorder(new Color(191, 191, 191)));
        panelSur.setBackground(Color.WHITE);
    }

    // ==============================================================================
    // MÉTODOS PARA CREACIÓN Y GESTIÓN DE PRODUCTOS
    // ==============================================================================

    /**
     * Crea un panel individual para un producto que se mostrará en el catálogo.
     */
    private JPanel crearProducto(String nombre, int precio, String descripcion, ImageIcon[] listaIconos, JRadioButton[] listaColores) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 180));
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JLabel imagen = new JLabel("", SwingConstants.CENTER);
        imagen.setPreferredSize(new Dimension(130, 130));
        imagen.setIcon(escalarImagen(listaIconos[0], imagen.getPreferredSize().width, imagen.getPreferredSize().height));

        JPanel panelTexto = new JPanel(new GridLayout(3, 1));
        panelTexto.setOpaque(false);

        JLabel labelNombre = new JLabel(nombre, SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel labelPrecio = new JLabel(String.format("$%d MXN", precio), SwingConstants.CENTER);
        labelPrecio.setFont(new Font("Arial", Font.BOLD, 16));

        panelTexto.add(labelNombre);
        panelTexto.add(labelPrecio);

        panel.add(imagen, BorderLayout.NORTH);
        panel.add(panelTexto, BorderLayout.CENTER);

        // Eventos del ratón (Hover y Click)
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setPreferredSize(new Dimension(200, 220));
                panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
                panel.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setPreferredSize(new Dimension(150, 180));
                panel.setBorder(null);
                panel.revalidate();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                abrirDetalleProducto(nombre, precio, descripcion, listaIconos, listaColores);
            }
        });
        return panel;
    }

    /**
     * Abre una ventana con los detalles completos de un modelo específico.
     */
    private void abrirDetalleProducto(String nombre, int precio, String desc, ImageIcon[] listaIconos, JRadioButton[] listaColores) {
        JFrame detalleTenis = new JFrame(nombre);
        // Evita que la aplicación entera se cierre si solo cerramos el producto
        detalleTenis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        JPanel panelTenis = new JPanel(new FlowLayout());
        panelTenis.setBackground(Color.WHITE);
        
        mostrarTenis(panelTenis, listaIconos, listaColores, desc, precio, nombre);
        
        detalleTenis.add(panelTenis);
        detalleTenis.setSize(750, 500);
        detalleTenis.setLocationRelativeTo(this);
        detalleTenis.setResizable(false);
        detalleTenis.setVisible(true);
    }

    /**
     * Construye el contenido interno de la ventana de detalles de un producto (Variantes, botones).
     */
    private void mostrarTenis(JPanel panel, ImageIcon[] listaIconos, JRadioButton[] listaColores, String desc, int prec, String nombre) {
        JRadioButton[] colores = new JRadioButton[listaIconos.length];
        ButtonGroup grupoColores = new ButtonGroup();
        
        JLabel lblTeni = new JLabel(escalarImagen(listaIconos[0], 400, 400));
        
        JPanel panelDetallesTenis = new JPanel();
        panelDetallesTenis.setLayout(new BoxLayout(panelDetallesTenis, BoxLayout.Y_AXIS));
        panelDetallesTenis.setPreferredSize(new Dimension(300, 300));
        panelDetallesTenis.setBackground(Color.WHITE);

        JLabel descripcion = new JLabel("<html>" + desc + "</html>");
        descripcion.setFont(new Font("Arial", Font.PLAIN, 16));
        descripcion.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel costo = new JLabel(String.format("$%d MXN", prec));
        costo.setFont(new Font("Arial", Font.BOLD, 18));
        costo.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Botón Comprar Directo
        Comprar comprar = new Comprar(Comprar.COMPRAR);
        comprar.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Compraste el producto exitosamente."));
        
        // Botón Añadir a Carrito
        Comprar btnAddCarrito = new Comprar(Comprar.CARRITO);
        btnAddCarrito.addActionListener(e -> {
            carrito.add(new CarritoItem(nombre, listaIconos[0], prec));
            JOptionPane.showMessageDialog(panel, "Producto agregado al carrito");
        });
        
        // Checkbox Favoritos
        JCheckBox favs = new JCheckBox(new ImageIcon(getClass().getResource("favoritos.png")));
        favs.setContentAreaFilled(false);
        favs.addItemListener(e -> {
            if (favs.isSelected()) {
                favs.setIcon(new ImageIcon(getClass().getResource("favorito_Seleccionado.png")));
                favoritos.add(panel); 
            } else {
                favs.setIcon(new ImageIcon(getClass().getResource("favoritos.png")));
                favoritos.remove(panel);
            }
        });

        // Ensamblar panel de detalles
        panelDetallesTenis.add(descripcion);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(costo);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(comprar);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(btnAddCarrito);
        panelDetallesTenis.add(Box.createVerticalStrut(30));
        panelDetallesTenis.add(favs);

        panel.add(lblTeni);
        panel.add(panelDetallesTenis);
        
        // Generar selectores de colores
        for (int i = 0; i < colores.length; i++) {
            colores[i] = listaColores[i];
            colores[0].setSelected(true);
            // Aseguramos no salir de índice para la selección
            grupoColores.add(colores[i]);
            panel.add(colores[i]);
            
            final int indice = i;
            colores[i].addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblTeni.setIcon(escalarImagen(listaIconos[indice], 400, 400));
                }
            });
        }
    }

    /**
     * Actualiza el panel inferior mostrando solo los productos de la página actual.
     */
    private void mostrarProductosVisibles() {
        panelProductos.removeAll(); // Limpiar el panel antes de añadir nuevos
        panelProductos.add(atras);
        
        int inicio = PRODUCTOS_POR_PAGINA * (intervalo - 1);
        int fin = Math.min(inicio + PRODUCTOS_POR_PAGINA, listaProductos.length);
        
        for (int i = inicio; i < fin; i++) {
            panelProductos.add(listaProductos[i]);
        }
        
        panelProductos.add(adelante);
        
        // Repintar para que los cambios surtan efecto en pantalla
        panelProductos.revalidate();
        panelProductos.repaint();
    }

    // ==============================================================================
    // VENTANAS SECUNDARIAS (Carrito y Favoritos)
    // ==============================================================================
    
    private void abrirVentanaCarrito() {
        JFrame ventanaCarrito = new JFrame("Carrito de Compras");
        ventanaCarrito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panelContenedorCarrito = new JPanel(new FlowLayout());
        panelContenedorCarrito.setBackground(Color.WHITE);
        
        JButton btnComprarTodo = new JButton();
        btnComprarTodo.setBackground(Color.BLACK);
        btnComprarTodo.setForeground(Color.WHITE);
        
        btnComprarTodo.addActionListener(e -> {
            if(carrito.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El carrito está vacío.");
                return;
            }
            carritoComprado = true;
            JOptionPane.showMessageDialog(this, "¡Compra realizada con éxito!");
            carrito.clear();
            ventanaCarrito.dispose();
        });
        
        int total = 0;
        
        for (CarritoItem item : carrito) {
            JPanel prod = new JPanel(new BorderLayout());
            prod.setBackground(Color.WHITE);

            JLabel img = new JLabel(escalarImagen(item.imagen, 100, 100));
            JLabel nombre = new JLabel(item.nombre, SwingConstants.CENTER);

            prod.add(img, BorderLayout.CENTER);
            prod.add(nombre, BorderLayout.NORTH);

            panelContenedorCarrito.add(prod);
            total += item.precio;
        }
        
        btnComprarTodo.setText(String.format("Comprar todo: $%d MXN", total));
        
        ventanaCarrito.add(new JScrollPane(panelContenedorCarrito), BorderLayout.CENTER);
        ventanaCarrito.add(btnComprarTodo, BorderLayout.SOUTH);
        ventanaCarrito.setSize(600, 400);
        ventanaCarrito.setLocationRelativeTo(this);
        ventanaCarrito.setVisible(true);
    }
    
    private void abrirVentanaFavoritos() {
        JFrame ventanaFavs = new JFrame("Mis Favoritos");
        ventanaFavs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panelFavs = new JPanel(new FlowLayout());
        panelFavs.setBackground(Color.WHITE);

        for (JPanel prod : favoritos) {
            panelFavs.add(prod);
        }

        ventanaFavs.add(new JScrollPane(panelFavs));
        ventanaFavs.setSize(600, 400);
        ventanaFavs.setLocationRelativeTo(this);
        ventanaFavs.setVisible(true);
    }

    // ==============================================================================
    // UTILIDADES GLOBALES (Tema oscuro, atajos y configuración UI)
    // ==============================================================================

    private void atajoTeclado() {
        // 1. Obtenemos la raíz de toda la ventana
        JRootPane rootPane = this.getRootPane();
        
        // 2. Pedimos el mapa de entrada con la regla mágica: "CUANDO LA VENTANA TENGA EL FOCO"
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = rootPane.getActionMap();

        // 3. Registramos el atajo de teclado (Ctrl + T) y le ponemos un nombre clave
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK), "cambiarTema");

        // 4. Le decimos a Java qué código ejecutar cuando escuche ese nombre clave
        actionMap.put("cambiarTema", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleModoOscuro();
            }
        });
    }

    private void toggleModoOscuro() {
        AdminTemas.toggleModoOscuro();

    Color fondo = AdminTemas.getFondo();
    Color texto = AdminTemas.getTexto();

    // Actualizar iconos
    AdminTemas.actualizarIconos(btnMenu, iconoMenuClaro, iconoMenuOscuro,
                                  btnCarrito, iconoCarritoClaro, iconoCarritoOscuro,
                                  btnFavoritos, iconoFavsClaro, iconoFavsOscuro,
                                  adelante, iconoAdelanteClaro, iconoAdelanteOscuro,
                                  atras, iconoAtrasClaro, iconoAtrasOscuro);

    // Actualizar paneles
    panelNorte.setBackground(fondo);
    panelCentro.setBackground(fondo);
    panelProductos.setBackground(fondo);
    panelSur.setBackground(fondo);
    getContentPane().setBackground(fondo);

    // Propagar tema
    AdminTemas.aplicarTemaRecursivo(panelNorte, fondo, texto);
    AdminTemas.aplicarTemaRecursivo(panelCentro, fondo, texto);
    AdminTemas.aplicarTemaRecursivo(panelProductos, fondo, texto);
    AdminTemas.aplicarTemaRecursivo(panelSur, fondo, texto);

    revalidate();
    repaint();
    }
    /**
     * Métodos auxiliares para reducir código repetitivo al crear botones e imágenes
     */
    private ImageIcon escalarImagen(ImageIcon iconoBase, int ancho, int alto) {
        return new ImageIcon(iconoBase.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
    }
    
    private JButton configurarBotonTransparente(JButton btn) {
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        return btn;
    }
    
    private void configurarBotonMenuLateral(JButton btn) {
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
    }
}