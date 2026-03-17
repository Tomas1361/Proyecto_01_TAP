
package proyectopt2;


import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author lupit
 */
public class VentanProject extends JFrame{
    //At
  private JLabel ImagenTeni ;
  private JLabel Desc;
//Cons
 public VentanProject (){
        super ("Ofertas");
        setLayout(new FlowLayout());
        
    
    ImageIcon iconoTenis = new ImageIcon("Tenis.png"); 
    ImagenTeni = new JLabel(iconoTenis); 
    add(ImagenTeni);
    
    ImageIcon iconoDesc = new ImageIcon("Desc.png");
    Desc = new JLabel(iconoDesc);
    add(Desc);
 }
 
}
