package apuntes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * APUNTES INTEGRADOS: DE JSON A STREAMS Y PERSISTENCIA
 * Este ejemplo une Jackson, Mapas, Listas y la API Stream avanzada.
 */
public class GestionDatosPro {

    // 1. MODELO DE DATOS INTEGRADO
    public static class Registro {
        @JsonProperty("id") private int id;
        @JsonProperty("ciudad") private String ciudad;
        @JsonProperty("valor") private double valor;
        @JsonProperty("fecha") private List<Integer> fecha; // Formato: [año, mes, día]

        public Registro() {} // Obligatorio para Jackson

        public int getId() { return id; }
        public String getCiudad() { return ciudad; }
        public double getValor() { return valor; }
        public List<Integer> getFecha() { return fecha; }
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // ---------------------------------------------------------
        // FASE 1: CARGA DE DATOS (LECTURA JSON)
        // ---------------------------------------------------------
        InputStream is = ClassLoader.getSystemResourceAsStream("datos.json");
        if (is == null) throw new RuntimeException("¡Archivo no encontrado!");
        
        // Convertimos el JSON en una lista manejable
        List<Registro> registros = Arrays.asList(mapper.readValue(is, Registro[].class));


        // ---------------------------------------------------------
        // FASE 2: PROFUNDIZACIÓN EN STREAMS (EL "MOTOR")
        // ---------------------------------------------------------
        
        // A. FILTRADO COMPLEJO (Encadenando condiciones)
        // Buscamos registros de "Badajoz" en la segunda decena del mes (días 10-20)
        List<Registro> filtrados = registros.stream()
                .filter(r -> r.getCiudad().equalsIgnoreCase("Badajoz"))
                .filter(r -> r.getFecha().get(2) >= 10 && r.getFecha().get(2) <= 20)
                .collect(Collectors.toList());

        // B. TRANSFORMACIÓN (map)
        // Obtenemos solo los nombres de ciudades únicas en MAYÚSCULAS
        Set<String> ciudadesUnicas = registros.stream()
                .map(r -> r.getCiudad().toUpperCase())
                .collect(Collectors.toSet()); // .toSet() elimina duplicados automáticamente

        // C. ESTADÍSTICAS COMPLETAS (DoubleSummaryStatistics)
        // En lugar de calcular media y max por separado, sacamos todas las estadísticas de golpe
        DoubleSummaryStatistics stats = registros.stream()
                .mapToDouble(Registro::getValor)
                .summaryStatistics();

        System.out.println("Registros procesados: " + stats.getCount());
        System.out.println("Valor Promedio: " + String.format("%.2f", stats.getAverage()));
        System.out.println("Valor Máximo: " + stats.getMax());


        // ---------------------------------------------------------
        // FASE 3: AGRUPACIÓN AVANZADA (GROUPING BY)
        // ---------------------------------------------------------
        
        // Creamos un MAPA que suma todos los valores acumulados por cada ciudad
        // Esto es como hacer un "GROUP BY" en SQL
        Map<String, Double> sumaPorCiudad = registros.stream()
                .collect(Collectors.groupingBy(
                        Registro::getCiudad, 
                        Collectors.summingDouble(Registro::getValor)
                ));


        // ---------------------------------------------------------
        // FASE 4: PERSISTENCIA (GUARDADO DE RESULTADOS)
        // ---------------------------------------------------------
        
        // Guardamos el mapa de resultados en un nuevo archivo JSON
        File salida = new File("informe_ciudades.json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(salida, sumaPorCiudad);
        
        System.out.println("Proceso finalizado. Archivo guardado en: " + salida.getAbsolutePath());
    }
}