package apuntes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SetMapYmas2 {
    /*
     * =====================================================
     * 1. ¿QUÉ ES UN SET?
     * =====================================================
     * - Colección SIN elementos duplicados
     * - NO tiene índices (no get(i))
     * - Usa equals() y hashCode() para detectar duplicados
     */

    void ejemploSet() {
        Set<String> nombres = new HashSet<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana"); // ❌ duplicado, no se añade

        System.out.println(nombres);
    }

    /*
     * =====================================================
     * 2. HASHSET
     * =====================================================
     * - No mantiene orden
     * - Muy rápido
     */

    void ejemploHashSet() {
        Set<Integer> numeros = new HashSet<>();
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);

        // El orden NO está garantizado
        System.out.println(numeros);
    }

    /*
     * =====================================================
     * 3. TREESET
     * =====================================================
     * - Mantiene los elementos ordenados
     * - Requiere Comparable o Comparator
     */

    void ejemploTreeSet() {
        Set<Integer> numeros = new TreeSet<>();
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);

        // Salida ordenada: [1, 2, 3]
        System.out.println(numeros);
    }

    /*
     * =====================================================
     * 4. CLASE PERSONA (para Set y Map)
     * =====================================================
     */

    class Persona implements Comparable<Persona> {
        private String nif;
        private String nombre;
        private String apellido;
        private LocalDate fechaNacimiento;

        public Persona(String nif, String nombre, String apellido, LocalDate fechaNacimiento) {
            this.nif = nif;
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getNif() {
            return nif;
        }

        // equals y hashCode basados SOLO en nif
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Persona))
                return false;
            Persona persona = (Persona) o;
            return Objects.equals(nif, persona.nif);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nif);
        }

        // Orden natural por nif
        @Override
        public int compareTo(Persona o) {
            return this.nif.compareTo(o.nif);
        }

        @Override
        public String toString() {
            return nombre + " " + apellido + " (" + nif + ")";
        }
    }

    /*
     * =====================================================
     * 5. SET DE OBJETOS
     * =====================================================
     */

    void setDePersonas() {
        Set<Persona> personas = new HashSet<>();

        personas.add(new Persona("1A", "Pepe", "Perez", LocalDate.of(1990, 1, 1)));
        personas.add(new Persona("1A", "Pepe", "Perez", LocalDate.of(1990, 1, 1))); // duplicado

        // Solo habrá una persona
        System.out.println(personas);
    }

    /*
     * =====================================================
     * 6. ¿QUÉ ES UN MAP?
     * =====================================================
     * - Estructura clave → valor
     * - Claves NO se repiten
     * - Valores SÍ pueden repetirse
     */

    void ejemploMap() {
        Map<String, String> paises = new HashMap<>();
        paises.put("ES", "España");
        paises.put("FR", "Francia");
        paises.put("ES", "Spain"); // sobrescribe

        System.out.println(paises);
    }

    /*
     * =====================================================
     * 7. HASHMAP
     * =====================================================
     * - No mantiene orden
     */

    void ejemploHashMap() {
        Map<String, Persona> agenda = new HashMap<>();

        agenda.put("1A", new Persona("1A", "Pepe", "Perez", LocalDate.now()));
        agenda.put("2B", new Persona("2B", "Ana", "Lopez", LocalDate.now()));

        // Recorrer el mapa
        for (String clave : agenda.keySet()) {
            System.out.println(clave + " -> " + agenda.get(clave));
        }
    }

    /*
     * =====================================================
     * 8. TREEMAP
     * =====================================================
     * - Mantiene orden por clave
     */

    void ejemploTreeMap() {
        Map<String, String> diccionario = new TreeMap<>();
        diccionario.put("Dog", "Perro");
        diccionario.put("Cat", "Gato");
        diccionario.put("Bird", "Pájaro");

        diccionario.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    /*
     * =====================================================
     * 9. OBTENER CLAVES Y VALORES DE UN MAP
     * =====================================================
     */

    void clavesYValores() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("A", "Uno");
        mapa.put("B", "Dos");

        Set<String> claves = mapa.keySet();
        Collection<String> valores = mapa.values();

        System.out.println(claves);
        System.out.println(valores);
    }

    /*
     * =====================================================
     * 10. CONVERSIONES ENTRE COLECCIONES
     * =====================================================
     */

    void conversiones() {
        List<String> lista = Arrays.asList("A", "B", "A");

        // List → Set (elimina duplicados)
        Set<String> set = new HashSet<>(lista);

        System.out.println(set);
    }

    /*
     * =====================================================
     * 11. LIST → MAP CON STREAMS
     * =====================================================
     */

    void listToMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("1A", "Pepe", "Perez", LocalDate.now()));
        personas.add(new Persona("2B", "Ana", "Lopez", LocalDate.now()));

        Map<String, Persona> mapa = personas.stream()
                .collect(Collectors.toMap(Persona::getNif, Function.identity()));

        System.out.println(mapa);
    }

    /*
     * =====================================================
     * 12. OPERACIONES CON SET (MUY IMPORTANTE)
     * =====================================================
     */

    void operacionesSet() {
        Set<String> a = new HashSet<>(Set.of("A", "B", "C"));
        Set<String> b = new HashSet<>(Set.of("B", "C", "D"));

        // Unión
        Set<String> union = new HashSet<>(a);
        union.addAll(b);

        // Intersección
        Set<String> interseccion = new HashSet<>(a);
        interseccion.retainAll(b);

        // Diferencia
        Set<String> diferencia = new HashSet<>(a);
        diferencia.removeAll(b);

        System.out.println("Unión: " + union);
        System.out.println("Intersección: " + interseccion);
        System.out.println("Diferencia: " + diferencia);
    }

    /*
     * =====================================================
     * 13. OPERACIONES CLAVE CON MAP
     * =====================================================
     */

    void operacionesMap() {
        Map<String, Integer> notas = new HashMap<>();

        notas.put("Ana", 8);
        notas.put("Luis", 6);

        // Comprobar si existe una clave
        if (notas.containsKey("Ana")) {
            System.out.println("Existe Ana");
        }

        // Obtener valor con valor por defecto
        int notaPepe = notas.getOrDefault("Pepe", 0);
        System.out.println("Nota de Pepe: " + notaPepe);

        // Eliminar una clave
        notas.remove("Luis");

        System.out.println(notas);
    }

    /*
     * =====================================================
     * 14. RECORRER UN MAP (FORMAS CLÁSICAS DE EXAMEN)
     * =====================================================
     */

    void recorrerMap() {
        Map<String, Integer> notas = new HashMap<>();
        notas.put("Ana", 8);
        notas.put("Luis", 6);

        // 1. Recorrer claves
        for (String clave : notas.keySet()) {
            System.out.println(clave);
        }

        // 2. Recorrer valores
        for (Integer valor : notas.values()) {
            System.out.println(valor);
        }

        // 3. Recorrer clave y valor (LA MEJOR OPCIÓN)
        for (Map.Entry<String, Integer> entry : notas.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}

/*
 * =====================================================
 * 15. ERRORES TÍPICOS (IMPORTANTE SABERLOS)
 * =====================================================
 * 
 * ❌ TreeSet sin Comparable → ClassCastException
 * ❌ HashMap sobrescribe valores con la misma clave
 * ❌ toMap con claves duplicadas → IllegalStateException
 * ❌ Set no permite acceder por índice
 * 
 */

/*
 * =====================================================
 * 16. EJERCICIOS PROPUESTOS (TIPO EXAMEN)
 * =====================================================
 * Enunciados + pistas. Pensados para usar MAPS
 * (juegos tipo Conecta 4, Hundir la Flota, etc.)
 */

/*
 * -----------------------------------------------------
 * EJERCICIO 1: TABLERO DE CONECTA 4 (SIMPLIFICADO)
 * -----------------------------------------------------
 * Usa un Map para representar el tablero.
 * 
 * 
 * - La clave será la posición (ej: "3,4")
 * - El valor será el jugador ('X' o 'O')
 * 
 * 
 * Pide:
 * - Insertar una ficha
 * - Mostrar el tablero
 * - Comprobar si una posición está ocupada
 * 
 * 
 * Pista:
 * Map<String, Character> tablero = new HashMap<>();
 */

/*
 * -----------------------------------------------------
 * EJERCICIO 2: HUNDIR LA FLOTA (POSICIONES OCUPADAS)
 * -----------------------------------------------------
 * Usa un Map para guardar barcos.
 * 
 * 
 * - Clave: posición (ej: "A3")
 * - Valor: tipo de barco ("Submarino", "Destructor")
 * 
 * 
 * Operaciones:
 * - Colocar barcos
 * - Disparar a una posición
 * - Indicar AGUA o TOCADO
 * 
 * 
 * Pista:
 * Map<String, String> barcos = new HashMap<>();
 */

/*
 * -----------------------------------------------------
 * EJERCICIO 3: JUEGO DE MEMORIA (CARTAS)
 * -----------------------------------------------------
 * Usa un Map para representar cartas boca abajo.
 * 
 * 
 * - Clave: número de carta
 * - Valor: símbolo (ej: "🐶", "🐱")
 * 
 * 
 * Operaciones:
 * - Girar carta
 * - Comprobar si dos cartas coinciden
 * - Eliminar pareja acertada
 */

/*
 * -----------------------------------------------------
 * EJERCICIO 4: CONTADOR DE MOVIMIENTOS
 * -----------------------------------------------------
 * Usa un Map para contar acciones de jugadores.
 * 
 * 
 * - Clave: nombre del jugador
 * - Valor: número de movimientos
 * 
 * 
 * Cada vez que juegue un jugador:
 */
