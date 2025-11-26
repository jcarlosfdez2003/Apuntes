package apuntes;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class InsertarTexto {
    public static void main(String[] args) {

      // ============ CONSOLA: MOSTRAR ============
        System.out.print("Esto se muestra sin salto de línea.");
        System.out.println(" Ahora con salto de línea.");
        System.out.printf("Formato: Nombre: %s, Edad: %d%n", "Ana", 25);

        // ============ CONSOLA: PEDIR DATOS ============
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombreConsola = sc.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edadConsola = sc.nextInt();

        System.out.println("Consola: Hola " + nombreConsola + ", tienes " + edadConsola + " años.");

        // ============ JOPTIONPANE: MOSTRAR ============
        JOptionPane.showMessageDialog(null, "¡Hola desde JOptionPane!");
        JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Advertencia", JOptionPane.WARNING_MESSAGE);

        // ============ JOPTIONPANE: PEDIR DATOS ============
        String nombreVentana = JOptionPane.showInputDialog("¿Cómo te llamas?");
        String edadTextoVentana = JOptionPane.showInputDialog("¿Qué edad tienes?");
        int edadVentana = Integer.parseInt(edadTextoVentana); // Convertir a int

        JOptionPane.showMessageDialog(null, "Ventana: Hola " + nombreVentana + ", tienes " + edadVentana + " años.");

        sc.close(); // Cerrar Scanner

       /*  String mensaje = """
                calculo
                -----------------
                horas: %.2f
                cxxxx: %.2f
                """.formatted(horas, cx);



        String textoLargo = """
                Este es un texto
                que ocupa
                varias líneas.
                """;

        JOptionPane.showMessageDialog(null, textoLargo, "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/

    }

}
