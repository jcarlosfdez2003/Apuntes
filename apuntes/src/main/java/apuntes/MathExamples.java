package apuntes;

public class MathExamples {
    public static void main(String[] args) {

      // ===============================
        // 1. CONSTANTES
        // ===============================
        System.out.println("PI: " + Math.PI);       // Constante del número pi (3.14159...)
        System.out.println("E: " + Math.E);         // Constante de Euler (2.71828...)

        // ===============================
        // 2. OPERACIONES BÁSICAS
        // ===============================
        System.out.println("Máximo entre 10 y 20: " + Math.max(10, 20)); // Devuelve el mayor valor
        System.out.println("Mínimo entre 10 y 20: " + Math.min(10, 20)); // Devuelve el menor valor
        System.out.println("Valor absoluto de -15: " + Math.abs(-15));   // Convierte a positivo

        // ===============================
        // 3. RAÍCES Y POTENCIAS
        // ===============================
        System.out.println("Raíz cuadrada de 25: " + Math.sqrt(25));     // √25 = 5.0
        System.out.println("Raíz cúbica de 27: " + Math.cbrt(27));       // ³√27 = 3.0
        System.out.println("2 elevado a la 3: " + Math.pow(2, 3));       // 2^3 = 8.0

        // ===============================
        // 4. REDONDEOS
        // ===============================
        double numero = 5.6;
        System.out.println("Redondeo hacia arriba (ceil): " + Math.ceil(numero));   // 6.0
        System.out.println("Redondeo hacia abajo (floor): " + Math.floor(numero));  // 5.0
        System.out.println("Redondeo al entero más cercano: " + Math.round(numero)); // 6
        System.out.println("Redondeo al entero más cercano (rint): " + Math.rint(numero)); // 6.0

        // ===============================
        // 5. EXPONENCIALES Y LOGARITMOS
        // ===============================
        System.out.println("e^1: " + Math.exp(1));             // Exponencial (≈ 2.718)
        System.out.println("Logaritmo natural de e: " + Math.log(Math.E)); // ln(e) = 1
        System.out.println("Logaritmo base 10 de 100: " + Math.log10(100)); // log10(100) = 2

        // Más precisos para valores pequeños
        System.out.println("e^x - 1 (expm1): " + Math.expm1(1));       // exp(1) - 1
        System.out.println("log(1 + x) (log1p): " + Math.log1p(0.5));  // log(1 + 0.5)

        // ===============================
        // 6. TRIGONOMETRÍA (ángulos en radianes)
        // ===============================
        double rad = Math.PI / 2;  // 90 grados en radianes
        System.out.println("Seno de π/2: " + Math.sin(rad));   // 1.0
        System.out.println("Coseno de π/2: " + Math.cos(rad)); // ≈ 0.0
        System.out.println("Tangente de π/2: " + Math.tan(rad)); // muy grande (infinito)

        // Funciones trigonométricas inversas
        System.out.println("arco seno de 1: " + Math.asin(1));   // π/2
        System.out.println("arco coseno de 0: " + Math.acos(0)); // π/2
        System.out.println("arco tangente de 1: " + Math.atan(1)); // π/4

        // ===============================
        // 7. CONVERSIÓN DE ÁNGULOS
        // ===============================
        System.out.println("Convertir 180 grados a radianes: " + Math.toRadians(180)); // π
        System.out.println("Convertir π radianes a grados: " + Math.toDegrees(Math.PI)); // 180

        // ===============================
        // 8. SIGNO Y DIRECCIÓN
        // ===============================
        System.out.println("Signo de -10: " + Math.signum(-10)); // -1.0
        System.out.println("Signo de 0: " + Math.signum(0));     // 0.0
        System.out.println("Signo de 5: " + Math.signum(5));     // 1.0

        // ===============================
        // 9. NÚMEROS ALEATORIOS
        // ===============================
        double aleatorio = Math.random(); // Número aleatorio entre 0.0 y 1.0
        System.out.println("Número aleatorio entre 0.0 y 1.0: " + aleatorio);

        // Número aleatorio entre 1 y 10
        int aleatorioEntre1y10 = (int) (Math.random() * 10) + 1;
        System.out.println("Número aleatorio entre 1 y 10: " + aleatorioEntre1y10);

        // ===============================
        // 10. OPERACIONES EXACTAS (Java 8+)
        // ===============================
        System.out.println("Incrementar 5: " + Math.incrementExact(5));      // 6
        System.out.println("Decrementar 5: " + Math.decrementExact(5));      // 4
        System.out.println("Negar 5: " + Math.negateExact(5));               // -5
        System.out.println("Suma exacta de 10 + 5: " + Math.addExact(10, 5));// 15
        System.out.println("Multiplicación exacta 3 * 4: " + Math.multiplyExact(3, 4)); // 12

        // División y módulo con truncamiento hacia abajo
        System.out.println("División floorDiv(7,2): " + Math.floorDiv(7, 2));   // 3
        System.out.println("Módulo floorMod(7,2): " + Math.floorMod(7, 2));     // 1
    }

}
