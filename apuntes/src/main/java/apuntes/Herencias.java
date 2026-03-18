package apuntes;


import java.util.*;
import java.awt.Point; // Usamos la de la API de Java como permite el enunciado

// =========================================================
// 1. JERARQUÍA DE CLASES E INTERFACES
// =========================================================

abstract class Figura {
    private String id;
    private String color;

    public Figura(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public abstract double area();

    // Getters y Setters
    public String getId() { return id; }
    public String getColor() { return color; }

    // Sobrescritura final: no se puede tocar en subclases
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figura)) return false;
        Figura figura = (Figura) o; // CONVERSIÓN EXPLÍCITA (Downcasting)
        return id.equals(figura.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s [ID: %s, Color: %s]", this.getClass().getSimpleName(), id, color);
    }
}

interface Movible {
    void moverIzq(int x); void moverDer(int x);
    void moverArr(int y); void moverAba(int y);
}

interface Dibujable {
    void dibujar();
}

abstract class Poligono extends Figura {
    private int base, altura, numeroLados;

    public Poligono(String id, String color, int base, int altura, int lados) {
        super(id, color);
        this.base = base;
        this.altura = altura;
        this.numeroLados = lados;
    }

    public int getBase() { return base; }
    public int getAltura() { return altura; }
}

final class Rectangulo extends Poligono implements Dibujable, Movible {
    private Point posicion = new Point(0, 0);

    public Rectangulo(String id, String color, int base, int altura) {
        super(id, color, base, altura, 4);
    }

    @Override
    public double area() { return getBase() * getAltura(); }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Rectángulo " + getId() + ":");
        for (int i = 0; i < getAltura(); i++) {
            for (int j = 0; j < getBase(); j++) System.out.print("* ");
            System.out.println();
        }
    }

    // Implementación Movible
    public void moverDer(int x) { posicion.x += x; }
    public void moverArr(int y) { posicion.y += y; }
    public void moverIzq(int x) { posicion.x -= x; }
    public void moverAba(int y) { posicion.y -= y; }
}

final class Circulo extends Figura implements Movible {
    private int radio;
    private Point centro = new Point(0, 0);

    public Circulo(String id, String color, int radio) {
        super(id, color);
        this.radio = radio;
    }

    @Override
    public double area() { return Math.PI * Math.pow(radio, 2); }

    public void moverDer(int x) { centro.x += x; }
    public void moverArr(int y) { centro.y += y; }
    public void moverIzq(int x) { centro.x -= x; }
    public void moverAba(int y) { centro.y -= y; }
}

// =========================================================
// 2. CLASE PRINCIPAL (EJECUTABLE)
// =========================================================

public class Herencias {

    public static void main(String[] args) {
        // --- Paso 1: Conjunto de objetos Figura ---
        Set<Figura> conjunto = new HashSet<>();
        // CONVERSIONES IMPLÍCITAS (Upcasting): Rectangulo/Circulo se tratan como Figura
        conjunto.add(new Rectangulo("R1", "Rojo", 4, 3));
        conjunto.add(new Rectangulo("R2", "Verde", 5, 2));
        conjunto.add(new Circulo("C1", "Azul", 5));
        conjunto.add(new Circulo("C2", "Rojo", 3));

        // --- Paso 2: Mostrar datos con foreach ---
        System.out.println("--- LISTADO DE FIGURAS ---");
        for (Figura f : conjunto) {
            System.out.println(f + " | Área: " + String.format("%.2f", f.area()));
        }

        // --- Paso 3: Crear lista a partir del conjunto ---
        List<Figura> lista = new ArrayList<>(conjunto);

        // --- Paso 4: Ordenar por ID (Lambda) ---
        lista.sort((f1, f2) -> f1.getId().compareTo(f2.getId()));
        System.out.println("\nOrdenadas por ID: " + lista);

        // --- Paso 5: Búsqueda binaria por ID ---
        // Se requiere un objeto comparable con el mismo ID
        Figura clave = new Rectangulo("R1", "", 0, 0); 
        int pos = Collections.binarySearch(lista, clave, (f1, f2) -> f1.getId().compareTo(f2.getId()));
        System.out.println("Búsqueda R1: Encontrado en posición " + pos);

        // --- Paso 6: Ordenar por Color y luego ID (thenComparing) ---
        lista.sort(Comparator.comparing(Figura::getColor).thenComparing(Figura::getId));
        System.out.println("Ordenadas por Color/ID: " + lista);

        // --- Paso 7: Filtrar Dibujables y Movibles ---
        List<Dibujable> listaDibujables = new ArrayList<>();
        List<Movible> listaMovibles = new ArrayList<>();

        for (Figura f : lista) {
            if (f instanceof Dibujable) {
                // CONVERSIÓN EXPLÍCITA (Downcasting): Forzamos a que Figura sea Dibujable
                listaDibujables.add((Dibujable) f);
            }
            if (f instanceof Movible) {
                listaMovibles.add((Movible) f);
            }
        }

        // --- Paso 8: Llamar a dibujar ---
        System.out.println("\n--- EJECUTANDO DIBUJAR() ---");
        listaDibujables.forEach(Dibujable::dibujar);

        // --- Paso 9: Movimientos específicos ---
        for (Movible m : listaMovibles) {
            if (m instanceof Rectangulo) {
                m.moverDer(2); // Mover 2 a la derecha si es Rectángulo
            } else if (m instanceof Circulo) {
                m.moverArr(3); // Mover 3 arriba si es Círculo
            }
        }

        // --- Paso 10: Estructura Figura -> Área ---
        Map<Figura, Double> mapa = obtenerMapaAreas(conjunto);
        System.out.println("\nMapa de Áreas generado con éxito.");
    }

    // Método de clase para obtener el mapa
    public static Map<Figura, Double> obtenerMapaAreas(Set<Figura> figuras) {
        Map<Figura, Double> mapaResultado = new HashMap<>();
        for (Figura f : figuras) {
            mapaResultado.put(f, f.area());
        }
        return mapaResultado;
    }
}

