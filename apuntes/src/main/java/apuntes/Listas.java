package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Listas {
    public static void main(String[] args) {

        // 1. CREACIÓN E INSERCIÓN
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10); // .add(valor) -> Añade al final
        numeros.add(20);
        numeros.add(0, 5); // .add(índice, valor) -> Inserta en posición
        numeros.addAll(Arrays.asList(30, 40, 10)); // .addAll() -> Añade varios de golpe

        System.out.println("Lista inicial: " + numeros);

        // 2. CONSULTA
        int tamaño = numeros.size(); // .size() -> Cuántos hay
        int primero = numeros.get(0); // .get(índice) -> Ver el valor de una posición
        boolean tieneDiez = numeros.contains(10); // .contains() -> ¿Existe el valor?
        int posicionDiez = numeros.indexOf(10); // .indexOf() -> Primera vez que aparece
        int ultimaPosicion = numeros.lastIndexOf(10); // .lastIndexOf() -> Última vez

        System.out.println("¿Tiene el 10?: " + tieneDiez + " en la posición: " + posicionDiez);

        // 3. MODIFICACIÓN Y ORDEN
        numeros.set(1, 15); // .set(índice, valor) -> Reemplaza el valor
        Collections.sort(numeros); // Ordena de menor a mayor
        Collections.reverse(numeros); // Invierte el orden
        Collections.shuffle(numeros); // Mezcla aleatoriamente (como un sorteo)

        // 4. ELIMINACIÓN
        numeros.remove(0); // .remove(índice) -> Borra por posición
        numeros.remove(Integer.valueOf(40)); // .remove(Objeto) -> Borra por valor específico
        numeros.removeIf(n -> n > 25); // .removeIf() -> Borra los que cumplan la condición

        // 5. CONVERSIÓN
        // Lista a Array de int (Primitivo)
        int[] arrayInt = numeros.stream().mapToInt(Integer::intValue).toArray();

        // Lista a Array de Objetos
        Integer[] arrayObj = numeros.toArray(new Integer[0]);

        // 6. RECORRIDO (IMPRESIÓN)
        System.out.println("--- Recorrido con forEach ---");
        numeros.forEach(n -> System.out.println("Número: " + n));

        // 7. VACIADO
        numeros.clear(); // .clear() -> Borra todo
        System.out.println("¿Está vacía?: " + numeros.isEmpty());

    }
} 
