package apuntes;

import java.util.Scanner;

public class Excepciones {

    // Ejemplo de excepción propia
    public static class MiExcepcion extends Exception {
        public MiExcepcion(String msg) {
            super(msg);
        }
    }

    public static void metodoQuePuedeFallar(int v) throws MiExcepcion {
        if (v < 0) {
            throw new MiExcepcion("Valor negativo no permitido: " + v);
        }
        System.out.println("Valor = " + v);
    }

    public static void main(String[] args) {
        // === 1. División por cero (ArithmeticException) ===
        try {
            int x = 10 / 0;
            System.out.println("Resultado: " + x);
        } catch (ArithmeticException e) {
            System.out.println("Error: división por cero: " + e.getMessage());
        }

        // === 2. Índice fuera de rango (ArrayIndexOutOfBoundsException) ===
        try {
            int[] arr = { 1, 2, 3 };
            int y = arr[5]; // error
            System.out.println("Valor: " + y);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: índice incorrecto: " + e.getMessage());
        }

        // === 3. NullPointerException ===
        try {
            String s = null;
            System.out.println("Longitud de s: " + s.length());
        } catch (NullPointerException e) {
            System.out.println("Error: referencia nula: " + e.getMessage());
        }

        // === 4. Cast inválido (ClassCastException) ===
        try {
            Object obj = "hola";
            Integer num = (Integer) obj; // error en tiempo de ejecución
            System.out.println("Número: " + num);
        } catch (ClassCastException e) {
            System.out.println("Error: cast inválido: " + e.getMessage());
        }

        // === 5. Formato inválido al convertir String a número (NumberFormatException)
        // ===
        try {
            String str = "abc";
            int z = Integer.parseInt(str);
            System.out.println("z = " + z);
        } catch (NumberFormatException e) {
            System.out.println("Error: formato no válido: " + e.getMessage());
        }

        // === 6. Excepción personalizada (throw / throws) ===
        try {
            metodoQuePuedeFallar(-5);
        } catch (MiExcepcion e) {
            System.out.println("Capturada MiExcepcion: " + e.getMessage());
        }

        // === 7. try/catch/finally ===
        try {
            int a = 5 / 0; // produce ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Esto se ejecuta siempre (finally).");
        }

        // === 8. Múltiples excepciones en un solo catch (desde Java 7) ===
        try {
            int[] arr2 = { 0 };
            int u = arr2[2]; // fuera de rango
            int v2 = Integer.parseInt("xyz"); // formato incorrecto
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error combinado: " + e.getClass().getSimpleName() + " — " + e.getMessage());
        }

        // === 9. Relanzar excepción desde catch ===
        try {
            int m = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Atrapo y relanzo:");
            throw e; // la excepción sigue hacia arriba — si quisieras manejarla fuera del main,
                     // tendrías que declararlo throws
        }

        // NOTA: Si relanzas la excepción (con throw), el programa dejará de ejecutarse
        // ahí
        // a menos que lo captures de nuevo más arriba.
    }
}
