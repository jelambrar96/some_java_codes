
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta aplciacion tiene un boton que al presionarse cambia el contenido de la 
 * etiqueta
 * 
 * @author jelambrar:
 */
public class ButtonPressed {
 
    public static void main(String[] args) {

        // se crea un objeto de tipo ventana
        JFrame ventana = new JFrame();
        
        // panel principal donde van TODOS los elementos de la ventana
        JPanel panel = new JPanel();
        // se define la organizacion de los elementos
        panel.setLayout(new BorderLayout());
        
        // se crea la etiqueta con su respectivo panel
        etiqueta = new JLabel();
        JPanel panel_etiqueta = new JPanel();
        panel_etiqueta.add(etiqueta);
        
        // se crea un boton con su respectivo panel, Tambien se le agrega la
        // clase que permite el cambio del texto en la etiqueta
        JButton boton = new JButton("Click me");
        boton.addActionListener(new CambiarEtiqueta());
        JPanel panel_boton = new JPanel();
        panel_boton.add(boton);
        
        // se agregan los elementos al panel principal
        panel.add(panel_etiqueta, BorderLayout.NORTH);
        panel.add(panel_boton, BorderLayout.SOUTH);
        
        // se agrega el panel principal a la ventana
        ventana.add(panel);
        
        // se obtiene la dimension de la pantalla del pc que se esta usando
        Dimension dimension_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // se establece la dimension de la ventana
        Dimension dimension_ventana = new Dimension(240, 96);
        // se establece la posicon de la ventana y sus dimensiones:
        // posicion x, posiscion y, ancho y alto,
        ventana.setBounds(dimension_pantalla.width/2 - dimension_ventana.width/2,
            dimension_pantalla.height/2 - dimension_ventana.height/2,
            dimension_ventana.width, dimension_ventana.height);
        // evita que el usuario le pueda cambiar el tamanio a la aplicacion
        ventana.setResizable(false);
        // hace que al cerrase la ventana, se termine la aplicacion
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // se hace la ventana visible
        ventana.setVisible(true);
 
    }
   
    // esta clase contiene el metodo que se ejecuta cuando el boton es
    // oprimido
    private static class CambiarEtiqueta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            etiqueta.setText("El boton ha sido presionado.");
        }
    }

    // se define la etiqueta como una variable privada para que la clase
    // CambiarEtiqueta pueda acceder a ella
    private static JLabel etiqueta;
}
