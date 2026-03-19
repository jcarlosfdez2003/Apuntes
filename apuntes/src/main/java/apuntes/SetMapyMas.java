package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SetMapyMas {
    public static void main(String[] args) {
        // Ejemplo mínimo funcional para Set, Map, List e Iterator.
        Set<Integer> miSet = new HashSet<>();
        miSet.add(10);
        miSet.add(10);
        miSet.add(5);
        System.out.println("miSet = " + miSet);

        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("Manzanas", 50);
        inventario.put("Peras", 30);
        inventario.put("Manzanas", 100);

        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add(1, "C++");

        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String lenguaje = it.next();
            if ("Python".equals(lenguaje)) {
                it.remove();
            }
        }
        System.out.println("lista final = " + lista);

        // Ejemplos de hash set y linked hash set para eliminar duplicados manteniendo orden.
        List<String> sucia = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B"));
        List<String> limpia = new ArrayList<>(new LinkedHashSet<>(sucia));
        System.out.println("sucia = " + sucia);
        System.out.println("limpia = " + limpia);

        // Ejemplo con scanner y manejo de excepción
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduce un número (o texto): ");
            String input = sc.nextLine();
            int n = Integer.parseInt(input);
            System.out.println("Número leído = " + n);
        } catch (NumberFormatException e) {
            System.out.println("No es un número válido.");
        }

        sc.close();
    }
}
