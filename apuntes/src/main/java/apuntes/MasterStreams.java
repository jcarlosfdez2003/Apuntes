package apuntes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * MANUAL DEFINITIVO DE STREAMS PARA EXAMEN
 * Estructura: ORIGEN -> OPERACIONES INTERMEDIAS -> OPERACIÓN TERMINAL
 */
public class MasterStreams {

    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Juan", "Pedro", "Ana", "Maria", "Jose", "Beatriz");
        List<Integer> edades = Arrays.asList(20, 25, 30, 15, 40, 25, 18);

        // =========================================================
        // 1. OPERACIONES INTERMEDIAS (Devuelven otro Stream)
        // =========================================================

        System.out.println("--- Operaciones Intermedias ---");

        nombres.stream()
                .filter(n -> n.startsWith("A")) // .filter: El portero. Solo pasan los que empiezan por A
                .distinct() // .distinct: Sin repetidos (usa equals())
                .map(String::toUpperCase) // .map: Transforma cada elemento (a mayúsculas)
                .sorted() // .sorted: Orden natural (alfabético/numérico)
                .limit(2) // .limit: Solo los 2 primeros resultados
                .peek(n -> System.out.println("Viendo: " + n)) // .peek: Espía para debug (no altera el flujo)
                .collect(Collectors.toList()); // (Terminal para poder ejecutar el peek)

        // =========================================================
        // 2. OPERACIONES TERMINALES (Cierran el Stream)
        // =========================================================

        System.out.println("\n--- Operaciones Terminales ---");

        // .count(): Devuelve long con el total
        long total = nombres.stream().filter(n -> n.length() > 4).count();

        // .anyMatch / .allMatch / .noneMatch: Devuelven boolean
        boolean algunoMenor = edades.stream().anyMatch(e -> e < 18); // ¿Hay algún menor?
        boolean todosAdultos = edades.stream().allMatch(e -> e >= 18); // ¿Todos son >= 18?

        // .findFirst() / .findAny(): Devuelven un Optional
        Optional<String> primero = nombres.stream().sorted().findFirst();
        primero.ifPresent(n -> System.out.println("El primero alfabéticamente: " + n));

        // .reduce(): Combina todo en un solo valor (ej: sumar todas las edades)
        int sumaEdades = edades.stream().reduce(0, (a, b) -> a + b);

        // =========================================================
        // 3. STREAMS NUMÉRICOS (Estadísticas Avanzadas)
        // =========================================================

        System.out.println("\n--- Estadísticas Numéricas ---");

        // .mapToInt / .mapToDouble: Pasa de Stream de Objetos a Stream Primitivo
        IntSummaryStatistics stats = edades.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics(); // ¡LA JOYA! Saca todo de golpe

        System.out.println("Media: " + stats.getAverage());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Suma: " + stats.getSum());

        // =========================================================
        // 4. AGRUPACIONES (Collectors.groupingBy) - NIVEL DIOS
        // =========================================================

        System.out.println("\n--- Agrupaciones ---");

        // Agrupar nombres por su longitud (Key: longitud, Value: Lista de nombres)
        Map<Integer, List<String>> porLongitud = nombres.stream()
                .collect(Collectors.groupingBy(String::length));

        // Contar cuántas veces aparece cada nombre (Frecuencia)
        Map<String, Long> conteoNombres = nombres.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Agrupar por condición (Mayores de edad vs Menores)
        Map<Boolean, List<Integer>> porMayoriaEdad = edades.stream()
                .collect(Collectors.partitioningBy(e -> e >= 18)); // partitioningBy es para booleanos

        System.out.println("Conteo de nombres: " + conteoNombres);
        System.out.println("Mayores de edad (true): " + porMayoriaEdad.get(true));

        // =========================================================
        // 5. TRUCOS EXTRA PARA EXAMEN
        // =========================================================

        // Crear un Stream de números en un rango (del 1 al 100)
        IntStream.rangeClosed(1, 100).filter(n -> n % 10 == 0).forEach(System.out::println);

        // Convertir el Stream a un String separado por comas
        String texto = nombres.stream().collect(Collectors.joining(", "));
        System.out.println("\nNombres unidos: " + texto);
    }
    /*
    // APUNTE: Comparadores encadenados
List<Registro> listaOrdenada = lista.stream()
    .sorted(Comparator.comparing(Registro::getCiudad) // Primero por ciudad
        .thenComparingDouble(Registro::getValor)    // Luego por valor
        .reversed())                                // Todo en orden inverso
    .collect(Collectors.toList());
    */
}