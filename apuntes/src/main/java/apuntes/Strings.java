package apuntes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static void main(String[] args) {

        // 1. Declaración y creación de Strings
        String a1 = "Hola";
        String a2 = new String("Hola");

        // 2. Concatenación
        String b1 = "Hola";
        String b2 = "Mundo";
        String b3 = b1 + " " + b2; // "Hola Mundo"
        String b4 = b1.concat(" ").concat(b2); // "Hola Mundo"

        // 3. Comparación
        String c1 = "Hola";
        String c2 = "hola";

        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equalsIgnoreCase(c2)); // true
        System.out.println(c1 == c2); // false (diferente referencia)
        System.out.println(c1.compareTo(c2)); // valor negativo porque "H" < "h"

        // 4. Búsqueda y verificación
        String d = "Hola Mundo";

        System.out.println(d.contains("Mundo")); // true
        System.out.println(d.startsWith("Hola")); // true
        System.out.println(d.endsWith("do")); // true
        System.out.println(d.indexOf("a")); // 3
        System.out.println(d.lastIndexOf("o")); // 9
        System.out.println(d.matches(".*Mundo")); // true

        // 5. Substring
        String e = "Hola Mundo";

        System.out.println(e.substring(5)); // "Mundo"
        System.out.println(e.substring(0, 4)); // "Hola"

        // 6. Mayúsculas y minúsculas
        String f = "Java";

        System.out.println(f.toUpperCase()); // "JAVA"
        System.out.println(f.toLowerCase()); // "java"

        // 7. Reemplazo y limpieza
        String g = " Hola Mundo ";

        System.out.println(g.trim()); // "Hola Mundo"
        System.out.println(g.replace("o", "0")); // " H0la Mund0 "
        System.out.println(g.replaceAll("\\s", "")); // "HolaMundo"
        System.out.println(g.replaceFirst("o", "O")); // " HOla Mundo "

        // 8. Conversión y parsing
        int edad = 25;
        String edadStr = String.valueOf(edad); // "25"

        String numeroStr = "123";
        int numero = Integer.parseInt(numeroStr); // 123

        double pi = Double.parseDouble("3.1416"); // 3.1416

        String mensaje = String.format("Hola %s, tienes %d años", "Ana", 30);
        // "Hola Ana, tienes 30 años"

        // 9. División y unión
        String datos = "Juan,Pedro,Ana";

        String[] nombres = datos.split(",");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        String unidos = String.join("-", nombres);
        System.out.println(unidos); // "Juan-Pedro-Ana"

        // 10. Caracteres individuales
        String s = "Hola";

        System.out.println(s.charAt(0)); // 'H'
        System.out.println(s.codePointAt(0)); // 72 (código Unicode de 'H')

        // 11. StringBuilder y StringBuffer
        StringBuilder sb = new StringBuilder("Hola");
        sb.append(" Mundo");
        sb.insert(0, "¡");
        sb.delete(0, 1);
        sb.reverse();

        System.out.println(sb.toString()); // "odnuM aloH"

        // 12. Funciones útiles
        String h = "  ";

        System.out.println(h.length()); // 2
        System.out.println(h.isEmpty()); // false
        System.out.println(h.isBlank()); // true (Java 11+)

        String repetir = "Ha".repeat(3); // "HaHaHa"

        // 13. Limpieza de caracteres
        String sucio = "H@o#l$a123!";
        String limpio = sucio.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(limpio); // "Hola123"

    }

}
