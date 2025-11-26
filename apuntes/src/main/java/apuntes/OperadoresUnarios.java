package apuntes;

public class OperadoresUnarios {
    public static void main(String[] args) {
         int a = 5;

        // ============================
        // 1. OPERADOR + (positivo)
        // ============================
        int positivo = +a; // El mismo valor, solo indica que es positivo
        System.out.println("Operador + (positivo): " + positivo); // 5

        // ============================
        // 2. OPERADOR - (negativo)
        // ============================
        int negativo = -a; // Cambia el signo
        System.out.println("Operador - (negativo): " + negativo); // -5

        // ============================
        // 3. OPERADOR ++ (incremento)
        // ============================

        // PRE-INCREMENTO: primero incrementa, luego usa el valor
        int pre = ++a;
        System.out.println("Pre-incremento (++a): " + pre); // 6

        // POST-INCREMENTO: primero usa el valor, luego incrementa
        int b = 10;
        int post = b++;
        System.out.println("Post-incremento (b++): " + post); // 10
        System.out.println("Valor de b después del post-incremento: " + b); // 11

        // ============================
        // 4. OPERADOR -- (decremento)
        // ============================

        // PRE-DECREMENTO
        int c = 8;
        int preDec = --c;
        System.out.println("Pre-decremento (--c): " + preDec); // 7

        // POST-DECREMENTO
        int d = 20;
        int postDec = d--;
        System.out.println("Post-decremento (d--): " + postDec); // 20
        System.out.println("Valor de d después del post-decremento: " + d); // 19

        // ============================
        // 5. OPERADOR ! (negación lógica)
        // ============================
        boolean verdadero = true;
        boolean negado = !verdadero;
        System.out.println("Negación lógica (!true): " + negado); // false

        // ============================
        // 6. OPERADOR ~ (complemento a nivel de bits)
        // ============================
        int bin = 2;         // 0000 0010 en binario
        int complemento = ~bin;
        System.out.println("Complemento bit a bit (~2): " + complemento); // -3
        // (~n) = -(n + 1)

        // ============================
        // 7. CASTING (conversión de tipo)
        // ============================
        double decimal = 7.89;
        int entero = (int) decimal; // Trunca, no redondea
        System.out.println("Casting double a int: " + entero); // 7
    }

}
