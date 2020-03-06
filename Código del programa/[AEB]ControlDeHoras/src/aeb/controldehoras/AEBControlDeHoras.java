package aeb.controldehoras;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author EddyReyes
 */
public class AEBControlDeHoras {

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println("Lugar: "+e.getLocalizedMessage()+"\nMensaje: "+e.getMessage());
        }
        ListadoEstudiantes e = new ListadoEstudiantes();
        e.setVisible(true);
    }

}
