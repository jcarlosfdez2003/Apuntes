package apuntes;

import java.util.Arrays;

public class BucleFor {

    public static void main(String[] args) {

        // --- Arrays de Ejemplo para las Funciones ---
        int[] numeros = { 10, 25, 40, 25, 5, 80, 40 };
        int[] arrayAOrdenar = { 5, 1, 4, 2, 8 };
        int[] arrayDeConteo = { 1, 5, 2, 5, 3, 5, 4 };
        int[] arrayAInvertir = { 10, 20, 30, 40, 50, 60 };

        // =================================================================
        // PARTE 1: Recorridos Básicos
        // =================================================================

        System.out.println("=================================================================");
        System.out.println("--- 1. Recorrido Básico (Hacia Adelante) ---");
        System.out.print("Array: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        System.out.println("--- 2. Recorrido Inverso (Al Revés) ---");
        // Empezar en el último índice (length - 1) hasta el primero (0)
        System.out.print("Array inverso: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("\n");

        System.out.println("--- 3. Usando Múltiples Variables (i y j) ---");
        for (int i = 0, j = 10; i < 5; i++, j--) {
            System.out.println("Suma de índices: " + i + " + " + j + " = " + (i + j));
        }

        // =================================================================
        // PARTE 2: Algoritmos Clave para Exámenes (for Anidado y Lógica)
        // =================================================================

        System.out.println("\n=================================================================");
        System.out.println("--- 4. Algoritmo: Ordenamiento Burbuja (Bubble Sort) ---");
        System.out.println("Original: " + Arrays.toString(arrayAOrdenar));
        ordenarBurbuja(arrayAOrdenar); // Llama a la función Bubble Sort
        System.out.println("Ordenado: " + Arrays.toString(arrayAOrdenar));

        System.out.println("\n--- 5. Algoritmo: Contar Frecuencia de un Número ---");
        int numeroBuscado = 5;
        int repeticiones = contarFrecuencia(arrayDeConteo, numeroBuscado); // Llama a la función de conteo
        System.out.println("Array: " + Arrays.toString(arrayDeConteo));
        System.out.println("El número " + numeroBuscado + " aparece " + repeticiones + " veces.");

        System.out.println("\n--- 6. Algoritmo: Imprimir Elementos Únicos (Eliminar Repetidos) ---");
        System.out.println("Original: " + Arrays.toString(numeros));
        imprimirUnicos(numeros); // Llama a la función de elementos únicos

        System.out.println("\n--- 7. Algoritmo: Invertir el Array (En el lugar) ---");
        System.out.println("Original: " + Arrays.toString(arrayAInvertir));
        invertirArray(arrayAInvertir); // Llama a la función de inversión
        System.out.println("Invertido: " + Arrays.toString(arrayAInvertir));

        // =================================================================
        // PARTE 3: Bucle Anidado y Control de Flujo
        // =================================================================

        System.out.println("\n=================================================================");
        System.out.println("--- 8. Usando 'continue' para Omitir Pares ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Salta la iteración si es par
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // =================================================================
    // >>> FUNCIONES AUXILIARES (DEBES INCLUIRLAS EN TU CLASE) <<<
    // =================================================================

    /**
     * Ordena el array usando el método de la burbuja (for anidado).
     */
    public static void ordenarBurbuja(int[] arr) {
        int n = arr.length;
        int temp; // Variable temporal para el intercambio

        // Bucle externo: controla las pasadas
        for (int i = 0; i < n - 1; i++) {
            // Bucle interno: realiza las comparaciones y swaps
            // La condición (n - 1 - i) acorta el recorrido en cada pasada
            for (int j = 0; j < n - 1 - i; j++) {

                // Si el elemento actual es MAYOR que el siguiente, se intercambian
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece un número específico en el array (for simple).
     */
    public static int contarFrecuencia(int[] arr, int numeroBuscado) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numeroBuscado) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Imprime sólo los elementos que aparecen por primera vez (for anidado).
     */
    public static void imprimirUnicos(int[] arr) {
        System.out.print("Elementos Únicos Impresos: ");

        // Bucle externo: recorre todos los elementos
        for (int i = 0; i < arr.length; i++) {
            boolean esRepetidoAnteriormente = false;

            // Bucle interno: Comprueba si arr[i] ya apareció en los índices anteriores (j <
            // i)
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    esRepetidoAnteriormente = true;
                    break; // Se encontró una repetición, no es necesario seguir revisando
                }
            }

            // Si no se encontró repetido antes, lo imprimimos
            if (!esRepetidoAnteriormente) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * Invierte el orden del array en el lugar (for simple hasta la mitad).
     */
    public static void invertirArray(int[] arr) {
        int n = arr.length;
        int temp;

        // Iteramos sólo hasta la mitad (n / 2) para no revertir el intercambio
        for (int i = 0; i < n / 2; i++) {

            // Calcular el índice simétrico del final
            int j = n - 1 - i;

            // Intercambio (Swap)
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
