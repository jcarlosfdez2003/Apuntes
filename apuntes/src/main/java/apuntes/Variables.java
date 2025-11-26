package apuntes;

import java.util.ArrayList;
import java.util.HashMap;

public class Variables {
    public static void main(String[] args) {

        /*
         * Tipo de dato Tamaño Valor mínimo Valor máximo Ejemplo de uso
         * byte 8 bits -128 127 byte edad = 25;
         * short 16 bits -32,768 32,767 short año = 2025;
         * int 32 bits -2,147,483,648 2,147,483,647 int poblacion = 1000000;
         * long 64 bits -9,223,372,036,854,775,808 9,223,372,036,854,775,807 long
         * distancia = 12345678900L;
         * float 32 bits ~1.4E-45 ~3.4E+38 float pi = 3.14f;
         * double 64 bits ~4.9E-324 ~1.7E+308 double peso = 72.45;
         * char 16 bits (0) (65,535) char letra = 'A';
         * boolean 1 bit (depende del sistema) false true boolean activo = true;
         */

        byte edad = 25;
        short año = 2025;
        int poblacion = 1000000;
        long distancia = 12345678900L;
        float pi = 3.14f;
        double peso = 72.45;
        char letra = 'A';
        boolean activo = true;

        System.out.println("Edad: " + edad);
        System.out.println("Año: " + año);
        System.out.println("Población: " + poblacion);
        System.out.println("Distancia: " + distancia);
        System.out.println("Pi: " + pi);
        System.out.println("Peso: " + peso);
        System.out.println("Letra: " + letra);
        System.out.println("Activo: " + activo);

        
         // ================================
        // 🔸 TIPOS PRIMITIVOS
        // ================================

        byte miByte = 100;          // Pequeño entero
        short miShort = 10000;      // Entero más grande
        int miEntero = 500000;      // Entero más común
        long miLong = 10000000000L; // Entero grande (con 'L')

        float miFloat = 5.75f;      // Decimal con menos precisión
        double miDouble = 19.99;    // Decimal con más precisión

        char miChar = 'J';          // Un solo carácter
        boolean miBoolean = true;   // Verdadero o falso

        System.out.println("Primitivos:");
        System.out.println("byte: " + miByte);
        System.out.println("short: " + miShort);
        System.out.println("int: " + miEntero);
        System.out.println("long: " + miLong);
        System.out.println("float: " + miFloat);
        System.out.println("double: " + miDouble);
        System.out.println("char: " + miChar);
        System.out.println("boolean: " + miBoolean);

        // ================================
        // 🔹 TIPOS NO PRIMITIVOS (OBJETOS)
        // ================================

        String miString = "Hola mundo";               // Cadena de texto
        Integer enteroObjeto = 123;                   // Objeto envoltorio para int
        Double decimalObjeto = 45.67;                 // Objeto envoltorio para double
        Boolean booleanoObjeto = false;               // Objeto booleano

        int[] miArray = {1, 2, 3, 4};                 // Arreglo de enteros

        ArrayList<String> lista = new ArrayList<>();  // Lista (debes importar java.util)
        lista.add("Java");
        lista.add("Python");

        HashMap<String, Integer> mapa = new HashMap<>(); // Mapa clave-valor
        mapa.put("Juan", 30);
        mapa.put("Ana", 25);

        System.out.println("\nNo primitivos:");
        System.out.println("String: " + miString);
        System.out.println("Integer: " + enteroObjeto);
        System.out.println("Double: " + decimalObjeto);
        System.out.println("Boolean: " + booleanoObjeto);

        System.out.print("Array: ");
        for (int num : miArray) {
            System.out.print(num + " ");
        }

        System.out.println("\nLista: " + lista);
        System.out.println("Mapa: " + mapa);

        // ================================
        // Ejemplo de null (solo en objetos)
        // ================================
        String textoNulo = null;
        System.out.println("\nTexto nulo: " + textoNulo);
    }

}
