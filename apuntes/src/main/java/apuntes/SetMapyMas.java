package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Iterator;

public class SetMapyMas {
    public static void main(String[] args) {
        // ============================
        // 1. MATRICES (Arrays Bidimensionales)
        // ============================
        // Una matriz es un array de arrays. Ojo: matriz[fila][columna]
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // TRUCO EXAMEN: Recorrer buscando vecinos sin salirse (Out of Bounds)
        int target = 5;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == target) {
                    System.out.println("Encontrado en: " + i + "," + j);

                    // CONTROL DE BORDES: Comprobar si existe arriba, abajo, izq, der
                    if (i > 0)
                        System.out.println("Arriba: " + matriz[i - 1][j]);
                    if (i < matriz.length - 1)
                        System.out.println("Abajo: " + matriz[i + 1][j]);
                    if (j > 0)
                        System.out.println("Izquierda: " + matriz[i][j - 1]);
                    if (j < matriz[i].length - 1)
                        System.out.println("Derecha: " + matriz[i][j + 1]);
                }
            }
        }

        // ============================
        // 2. LISTAS (ArrayList)
        // ============================
        // Dinámicas, pueden cambiar de tamaño. Solo guardan OBJETOS (Integer, no int).
        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add(1, "C++"); // Inserta en la posición 1, desplaza el resto

        // Metodos clave: size(), get(index), remove(index o objeto), contains(objeto)
        if (lista.contains("Java")) {
            System.out.println("La lista tiene Java en la posición: " + lista.indexOf("Java"));
        }

        // ============================
        // 3. SETS (HashSet / TreeSet)
        // ============================
        // ¡NO PERMITEN DUPLICADOS! Útiles para limpiar datos.
        // HashSet: Rápido, no mantiene orden.
        // TreeSet: Mantiene orden natural (alfabético o numérico).
        Set<Integer> miSet = new HashSet<>();
        miSet.add(10);
        miSet.add(10); // Esto se ignora, no da error pero no se añade.
        miSet.add(5);

        System.out.println("Tamaño del set: " + miSet.size()); // Imprimirá 2

        // ============================
        // 4. MAPS (HashMap)
        // ============================
        // Pareja Clave -> Valor. Las claves son únicas.
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("Manzanas", 50);
        inventario.put("Peras", 30);

        // Si usas put con una clave que ya existe, SOBREESCRIBE el valor.
        inventario.put("Manzanas", 100);

        // Recorrer un Map (Típico de examen):
        for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
            System.out.println("Producto: " + entrada.getKey() + " | Cantidad: " + entrada.getValue());
        }

        // ============================
        // 5. ITERATOR
        // ============================
        // La forma segura de borrar elementos mientras recorres una colección.
        // Si usas un for-each normal y haces .remove(), el programa explota
        // (ConcurrentModificationException).
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String lenguaje = it.next();
            if (lenguaje.equals("Python")) {
                it.remove(); // Borrado seguro
            }
        }

        // ============================
        // 6. BÚSQUEDA BINARIA (Divide y vencerás)
        // ============================
        // REQUISITO: El array DEBE ESTAR ORDENADO.
        // Es mucho más rápida que la lineal en arrays grandes.
        int[] nums = { 10, 20, 30, 40, 50, 60, 70 };
        int buscar = 60;
        int inicio = 0;
        int fin = nums.length - 1;
        int posicion = -1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; // Evita desbordamiento de memoria

            if (nums[medio] == buscar) {
                posicion = medio;
                break;
            } else if (nums[medio] < buscar) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        // Atajo de Java para búsqueda binaria (si no te obligan a programarla):
        // int pos = Arrays.binarySearch(nums, buscar);

        // ============================
        // 7. CONSEJOS EXTRA (Trampas comunes)
        // ============================
        /*
         * 1. Comparar Strings: NUNCA uses ==. Usa siempre: cadena1.equals(cadena2)
         * 2. Cuidado con null: Antes de hacer un .size() o .equals(), asegúrate de que
         * el objeto no sea null.
         * 3. Matrices irregulares: matriz[i].length puede variar en cada fila. No
         * asumas que todas miden lo mismo.
         * 4. Sort: Para ordenar una lista: Collections.sort(lista); Para un array:
         * Arrays.sort(array);
         */

        // ============================
        // 8. TRAMPAS CON MATRICES (Recorridos complejos)
        // ============================

        // TRAMPA 1: El "Efecto Espejo" o Transposición
        // A veces te piden intercambiar filas por columnas.
        // OJO: Si recorres la matriz entera e intercambias [i][j] con [j][i],
        // ¡lo acabarás intercambiando DOS VECES y se quedará igual!
        int[][] m = { { 1, 2 }, { 3, 4 } };
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[i].length; j++) { // J empieza en I + 1 (Triángulo superior)
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }

        // TRAMPA 2: La Matriz "Irregular" (Jagged Array)
        // No todas las filas tienen que medir lo mismo. Si usas matriz[0].length para
        // todo, petará.
        int[][] irregular = { { 1, 2, 3 }, { 4, 5 }, { 6 } };
        for (int i = 0; i < irregular.length; i++) {
            // SIEMPRE usa irregular[i].length, nunca un número fijo o la longitud de la
            // fila 0.
            for (int j = 0; j < irregular[i].length; j++) {
                // código...
            }
        }

        // ============================
        // 9. TRAMPAS CON LISTAS Y SETS
        // ============================

        // TRAMPA 3: El borrado fantasma en ArrayList
        // Si borras elementos con un for normal (i++), al borrar el elemento 2,
        // el que era el 3 pasa a ser el 2, el bucle salta al 3 y ¡TE SALTAS UNO SIN
        // REVISAR!
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == 2) {
                numeros.remove(i);
                i--; // SOLUCIÓN: Decrementar la i para no saltarse el siguiente elemento
            }
        }

        // TRAMPA 4: Objetos personalizados en Sets/Maps
        // Si creas una clase "Alumno" y no programas los métodos equals() y hashCode(),
        // el Set dejará meter dos alumnos con el mismo DNI porque "son objetos
        // distintos en memoria".
        // REGLA: Si usas Set con objetos propios, necesitas generar Equals/HashCode.

        // ============================
        // 10. TRAMPAS DE BÚSQUEDA BINARIA
        // ============================

        // TRAMPA 5: El "Bucle Infinito" en Búsqueda Binaria
        // Si olvidas el "+1" o "-1" al mover los límites, el bucle puede no terminar
        // nunca.
        // inicio = medio; <-- MAL (Bucle infinito si inicio y fin están pegados)
        // inicio = medio + 1; <-- BIEN

        // TRAMPA 6: El elemento no existe
        // Si el examen pide "insertar si no existe", recuerda que binarySearch de Java
        // devuelve un número negativo si no lo encuentra. No devuelve -1
        // necesariamente.

        // ============================
        // 11. TRAMPAS DE TIPOS DE DATOS (Casting)
        // ============================

        // TRAMPA 7: La división entera
        // Si buscas la media de una lista de notas:
        int suma = 15;
        int cantidad = 2;
        double media = suma / cantidad; // Resultado: 7.0 (¡Error! Pierdes los decimales antes de guardar)
        double mediaCorrecta = (double) suma / cantidad; // Resultado: 7.5

        // TRAMPA 8: Comparar Strings de entrada (Scanner)
        // Si lees un String de consola con .next() y el usuario pone "Hola Mundo",
        // .next() solo pillará "Hola". Usa .nextLine() para pillar la frase completa.

        // TRAMPA 9: El "===" en Objetos Wrapper
        Integer a = 120;
        Integer b = 120;
        Integer c = 200;
        Integer d = 200;
        // a == b es TRUE (Java cachea números pequeños)
        // c == d es FALSE (Son objetos distintos)
        // CONCLUSIÓN: Usa siempre .equals() para Integer, Double, String, etc.

        // ============================
        // 12. MAPS: El "null" y "containsKey"
        // ============================

        // TRAMPA 10: Intentar obtener algo que no existe
        Map<String, String> dicc = new HashMap<>();
        // String valor = dicc.get("clave").toLowerCase(); // ERROR:
        // NullPointerException si la clave no existe.
        if (dicc.containsKey("clave")) {
            // Ahora es seguro
        }
        // ============================
        // 13. MATRICES: EL "BUSCAMINAS" (Control Total)
        // ============================
        // TRAMPA: Te piden sumar los vecinos de una celda, pero la celda está en una
        // esquina.
        int[][] tablero = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        int fila = 0, col = 0; // Esquina superior izquierda
        int sumaVecinos = 0;

        // LA FORMA "PRO" (Evita 8 IFs manuales):
        // Usamos dos bucles que recorren de -1 a +1 relativo a la posición
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nFila = fila + i;
                int nCol = col + j;

                // TRAMPA: No sumarte a ti mismo y no salirte del array
                if (nFila >= 0 && nFila < tablero.length && nCol >= 0 && nCol < tablero[0].length) {
                    if (!(i == 0 && j == 0)) { // Si no es la celda origen
                        sumaVecinos += tablero[nFila][nCol];
                    }
                }
            }
        }

        // ============================
        // 14. LISTAS: ELIMINAR DUPLICADOS (Sin perder el orden)
        // ============================
        // TRAMPA: Si pasas una Lista a un HashSet, se borran los duplicados pero SE
        // PIERDE EL ORDEN.
        // Si el examen pide mantener el orden original:
        List<String> sucia = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B"));

        // SOLUCIÓN: LinkedHashSet (Mantiene orden de inserción y no permite duplicados)
        Set<String> limpia = new LinkedHashSet<>(sucia);
        sucia = new ArrayList<>(limpia);

        // ============================
        // 15. MAPS: FRECUENCIA DE ELEMENTOS
        // ============================
        // TRAMPA: "Dime cuántas veces aparece cada palabra en este array".
        String[] palabras = { "java", "python", "java", "c++", "java" };
        Map<String, Integer> contador = new HashMap<>();

        for (String p : palabras) {
            // Forma elegante (getOrDefault evita el IF de "si no existe, pon 0")
            contador.put(p, contador.getOrDefault(p, 0) + 1);
        }

        // ============================
        // 16. ITERATOR: FILTRADO DOBLE
        // ============================
        // TRAMPA: "Borra los números pares de la lista pero solo si son mayores que
        // 10".
        List<Integer> datos = new ArrayList<>(Arrays.asList(2, 12, 5, 20, 8));
        Iterator<Integer> iter = datos.iterator();
        while (iter.hasNext()) {
            int n = iter.next();
            if (n % 2 == 0 && n > 10) {
                iter.remove();
            }
        }

        // ============================
        // 17. BÚSQUEDA BINARIA: EL "PUNTO DE CORTE"
        // ============================
        // TRAMPA: No buscas un número, buscas el primer número mayor que X.
        int[] ordenados = { 10, 20, 30, 40, 50 };
        int limite = 25;
        int res = -1;
        int ini = 0, f = ordenados.length - 1;

        while (ini <= f) {
            int z = ini + (f - ini) / 2;
            if (ordenados[z] > limite) {
                res = ordenados[z]; // Guardamos el candidato
                f = z - 1; // Seguimos buscando a la izquierda por si hay uno más pequeño que también sea >
                           // 25
            } else {
                ini = z + 1;
            }
        }

        // ============================
        // 18. RECORRIDO EN ZIG-ZAG (Serpiente)
        // ============================
        // TRAMPA: Recorrer una matriz: fila 1 izq->der, fila 2 der->izq.
        int[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < m2.length; i++) {
            if (i % 2 == 0) { // Fila par: Normal
                for (int j = 0; j < m2[i].length; j++)
                    System.out.print(m2[i][j] + " ");
            } else { // Fila impar: Al revés
                for (int j = m2[i].length - 1; j >= 0; j--)
                    System.out.print(m2[i][j] + " ");
            }
        }

        // ============================
        // 19. TRUCOS FINALES DE SCANNER
        // ============================
        // TRAMPA: Leer números y luego un String.
        // int n = sc.nextInt();
        // String s = sc.nextLine(); // <-- ¡ESTO SE QUEDA VACÍO! Se come el "Enter" del
        // número.
        // SOLUCIÓN:
        // int n = Integer.parseInt(sc.nextLine()); // Leer todo como línea y convertir.
        // Mucho más seguro.

        // ============================
        // 20. MÉTODOS DE ORDENACIÓN (Sorting)
        // ============================

        // TRAMPA 1: El método Burbuja (Bubble Sort) - El más básico
        // Es ineficiente (O(n²)) pero muy común en exámenes.
        // ¡OJO! No olvides el "-1" en el límite del bucle 'j' para no salirte del array
        // al comparar con j+1.
        int[] paraBurbuja = { 5, 2, 8, 1, 9 };
        for (int i = 0; i < paraBurbuja.length - 1; i++) {
            for (int j = 0; j < paraBurbuja.length - 1 - i; j++) {
                if (paraBurbuja[j] > paraBurbuja[j + 1]) {
                    // Intercambio (Swap)
                    int temp = paraBurbuja[j];
                    paraBurbuja[j] = paraBurbuja[j + 1];
                    paraBurbuja[j + 1] = temp;
                }
            }
        }

        // TRAMPA 2: Ordenar Objetos Personalizados (Comparator vs Comparable)
        // Si tienes una lista de objetos "Coche", Collections.sort() no sabrá si
        // ordenar por precio, marca o año.
        // TRUCO EXAMEN: Usa una expresión Lambda (Java 8+) para no tener que crear
        // clases extra.
        List<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Zacarias", "Beto"));

        // Ordenar de mayor a menor (Inverso):
        nombres.sort((a2, b2) -> b2.compareTo(a2));

        // TRAMPA 3: Ordenar y perder el índice original
        // Si ordenas un array de precios, ya no sabrás a qué producto pertenecía cada
        // uno.
        // SOLUCIÓN: Si necesitas mantener la relación, usa un Map antes de ordenar o
        // crea una clase que guarde ambos datos.

        // TRAMPA 4: Arrays.sort() con tipos primitivos vs Objetos
        int[] arrP = { 3, 1, 2 };
        Arrays.sort(arrP); // Funciona directo.

        // Pero si quieres orden descendente con Arrays.sort, el array DEBE SER de
        // Objetos (Integer[]).
        Integer[] arrO = { 3, 1, 2 };
        Arrays.sort(arrO, (x, y) -> y - x); // Solo funciona con Integer[], no con int[].

        // TRAMPA 5: La estabilidad del orden
        // Si ordenas por "Apellido" y luego por "Nombre", asegúrate de que el método
        // sea "estable" para que no desordene los apellidos al organizar los nombres.
        // (Arrays.sort para objetos y Collections.sort son ESTABLES).

        // ============================
        // 21. RESUMEN RÁPIDO "MÉTODO SORT"
        // ============================
        /*
         * 1. Arrays de primitivos: Arrays.sort(miArray);
         * 2. Listas: Collections.sort(miLista); o miLista.sort(null);
         * 3. Orden Personalizado: lista.sort((o1, o2) -> o1.getValor() -
         * o2.getValor());
         * 4. ¡IMPORTANTE!: Ordenar SIEMPRE invalida cualquier búsqueda binaria previa.
         * Primero se ordena, LUEGO se busca.
         */

        // ============================
        // 22. RECURSIVIDAD (El clásico)
        // ============================
        // TRAMPA: Olvidar el "Caso Base". Sin él, el programa lanza un StackOverflowError.
        // Siempre debe haber una condición que detenga las llamadas.
        // Ejemplo: factorial(5) -> 5 * 4 * 3 * 2 * 1
        
        // (Nota: Esto iría como método fuera del main, pero aquí tienes la lógica)
        /*
        public static int factorial(int n) {
            if (n <= 1) return 1; // CASO BASE: Si no está, el bucle es infinito
            return n * factorial(n - 1); 
        }
        */

        // ============================
        // 23. TRATAMIENTO DE EXCEPCIONES (Try-Catch)
        // ============================
        // TRAMPA: El programa peta si el usuario mete una letra cuando pides un número.
        try {
            String entrada = "123a"; 
            int numero = Integer.parseInt(entrada); // Aquí saltará el error
        } catch (NumberFormatException e) {
            System.out.println("TRAMPA EVITADA: No se puede convertir una letra en número");
        } finally {
            // Este bloque se ejecuta SIEMPRE, haya error o no. 
            // Útil para cerrar Scanners o conexiones.
        }

        // ============================
        // 24. EFICIENCIA CON STRINGBUILDER
        // ============================
        // TRAMPA: Concatenar Strings con "+" dentro de un bucle muy largo.
        // Como los Strings son inmutables, Java crea un objeto nuevo en cada vuelta. Es LENTO.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("Dato").append(i).append(" "); // Mucho más rápido y eficiente
        }
        String resultadoFinal = sb.toString();

        // ============================
        // 25. DIAGONALES EN MATRICES (Geometría)
        // ============================
        int[][] mExamen = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < mExamen.length; i++) {
            for (int j = 0; j < mExamen[i].length; j++) {
                // TRAMPA: Diagonal Principal (1, 5, 9)
                if (i == j) { 
                    // Es elemento de la diagonal principal
                }
                // TRAMPA: Diagonal Secundaria (3, 5, 7)
                if (i + j == mExamen.length - 1) {
                    // Es elemento de la diagonal secundaria
                }
            }
        }
    }
}
