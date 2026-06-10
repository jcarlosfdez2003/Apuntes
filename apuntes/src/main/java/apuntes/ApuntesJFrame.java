package apuntes;

import javax.swing.*;
import java.awt.*;

public class ApuntesJFrame extends JFrame {

    public ApuntesJFrame() {
        // 1. TÍTULO Y CIERRE
        setTitle("Ventana Blindada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el proceso al salir

        // 2. TAMAÑO Y REDIMENSIÓN
        setSize(500, 400); 
        setResizable(false); // BLOQUEA el agrandar o encoger la ventana

        // 3. POSICIONAMIENTO
        // Centrar la ventana en la pantalla (IMPORTANTE: llamar después de setSize)
        setLocationRelativeTo(null); 

        // Posición manual exacta (x, y)
        // setLocation(100, 100); 

        // Combinar posición y tamaño en un solo método
        // setBounds(x, y, ancho, alto);

        // 4. ESTADO Y VISIBILIDAD
        setAlwaysOnTop(true); // La ventana siempre estará por encima de las demás apps
        
        // Hacer que aparezca maximizada desde el inicio
        // setExtendedState(JFrame.MAXIMIZED_BOTH); 

        // 5. DECORACIÓN (Quitar bordes, botones de cerrar/min/max)
        // setUndecorated(true); // CUIDADO: Si haces esto, debes crear tu propio botón de cerrar

        // 6. ICONO DE LA VENTANA
        // Image icono = Toolkit.getDefaultToolkit().getImage("ruta/al/icono.png");
        // setIconImage(icono);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApuntesJFrame().setVisible(true);
        });
    }
    // Dentro de un Listener o método
public void abrirVentanaBloqueante(JFrame padre) {
    // El booleano 'true' activa el MODAL (bloqueo)
    JDialog dialogo = new JDialog(padre, "Ventana de Bloqueo", true);
    
    dialogo.setSize(300, 200);
    dialogo.setLocationRelativeTo(padre); // Se centra respecto a la principal
    dialogo.setLayout(new FlowLayout());
    dialogo.add(new JLabel("No puedes tocar la de atrás hasta cerrarme"));
    
    dialogo.setVisible(true); // El código se detiene aquí hasta que cierres el diálogo
}


}