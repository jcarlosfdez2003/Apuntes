package apuntes;

public class Copias {

    public static void main(String[] args) {
        // 1. Creamos el objeto original
        Motor motorOriginal = new Motor("V8");
        Coche original = new Coche("Ferrari", motorOriginal);

        // --- ESCENARIO 1: ALIAS ---
        Coche alias = original;

        // --- ESCENARIO 2: COPIA SUPERFICIAL (Shallow Copy) ---
        Coche superficial = new Coche(original.marca, original.motor);

        // --- ESCENARIO 3: COPIA PROFUNDA (Deep Copy) ---
        // Creamos un nuevo Motor basado en el del original
        Motor motorNuevo = new Motor(original.motor.tipo);
        Coche profundo = new Coche(original.marca, motorNuevo);

        // --- PRUEBA DE INDEPENDENCIA ---
        System.out.println("Modificando el motor del coche original a 'V12'...");
        original.motor.tipo = "V12";

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Original:    " + original);
        System.out.println("Alias:       " + alias + " (CAMBIÓ, es el mismo objeto)");
        System.out.println("Superficial: " + superficial + " (CAMBIÓ, comparte el motor)");
        System.out.println("Profundo:    " + profundo + " (NO CAMBIÓ, tiene su propio motor)");
    }

    // Clase interna para el ejemplo
    static class Motor {
        String tipo;

        Motor(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }
    }

    // Clase principal para el ejemplo
    static class Coche {
        String marca;
        Motor motor;

        Coche(String marca, Motor motor) {
            this.marca = marca;
            this.motor = motor;
        }

        @Override
        public String toString() {
            return "Coche [Marca=" + marca + ", Motor=" + motor + "]";
        }
    }
}
