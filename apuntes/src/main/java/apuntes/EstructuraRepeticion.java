package apuntes;

public class EstructuraRepeticion {
    public static void main(String[] args) {

        /*
         * Inicialización. Permite inicializar la estructura iterativa, normalmente
         * consiste en la declaración e inicialización de la variable de control del
         * bucle.
         * 
         * Condición. Define la condición que se evalúa para ejecutar el bloque de
         * sentencias de la estructura iterativa. Dependiendo del tipo de estructura que
         * se utilice, la condición se comprueba antes o después de realizar cada
         * iteración.
         * 
         * Bloque de sentencias. Conjunto de sentencias que se ejecutan dentro de la
         * estructura iterativa.
         * 
         * Actualización. Actualización de la variable de control del bucle. Normalmente
         * se realiza al finalizar la ejecución del bloque de sentencias.
         * 
         */

        /*
         * El bucle while ejecuta el bloque mientras la condición sea verdadera (true).
         * 
         * while (condición) {
         * // código que se repite
         * }
         */

        int i = 1;

        while (i <= 5) {
            System.out.println("Número: " + i);
            i++; // incrementa para evitar bucle infinito
        }

        /*
         * do...while — ejecuta al menos una vez
         * 
         * Este bucle siempre se ejecuta al menos una vez, ya que la condición se evalúa
         * al final del ciclo.
         * 
         * do {
         * // código que se ejecuta al menos una vez
         * } while (condición);
         */

        int a = 1;

        do {
            System.out.println("Valor: " + a);
            i++;
        } while (a <= 3);

        /*
         * for — bucle controlado por contador
         * 
         * Usado cuando sabes cuántas veces quieres repetir algo.
         * 
         * for (inicialización; condición; incremento/decremento) {
         * // código que se repite
         * }
         */

        for (int b = 1; b <= 5; b++) {
            System.out.println("Iteración número " + b);
        }

        /*
         * int i = 1 → inicialización
         * 
         * i <= 5 → condición
         * 
         * i++ → incremento después de cada ciclo
         */

    }

}
