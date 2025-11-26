package apuntes;

public class EstructurasControl {
    public static void main(String[] args) {
        
        // Operador ternario

        int num1 = 1;
        int num2 = 2;
        String resultado =(num1!=num2)?"hola":"adios";

         // ============================
        // 1. ESTRUCTURA IF - ELSE
        // ============================
        int edad = 18;

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        // ============================
        // 2. IF - ELSE IF - ELSE
        // ============================
        int nota = 85;

        if (nota >= 90) {
            System.out.println("Excelente");
        } else if (nota >= 70) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        // ============================
        // 3. SWITCH (multiple selección)
        // ============================
        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            default:
                System.out.println("Otro día");
        }

        // ============================
        // 4. WHILE (bucle mientras)
        // ============================
        int i = 0;
        while (i < 3) {
            System.out.println("while: i = " + i);
            i++;
        }

        // ============================
        // 5. DO-WHILE (ejecuta al menos una vez)
        // ============================
        int j = 0;
        do {
            System.out.println("do-while: j = " + j);
            j++;
        } while (j < 3);

        // ============================
        // 6. FOR (bucle con control total)
        // ============================
        for (int k = 0; k < 3; k++) {
            System.out.println("for: k = " + k);
        }

        // ============================
        // 7. FOR-EACH (para colecciones o arrays)
        // ============================
        String[] frutas = {"Manzana", "Banana", "Naranja"};
        for (String fruta : frutas) {
            System.out.println("Fruta: " + fruta);
        }

        // ============================
        // 8. BREAK (sale del bucle)
        // ============================
        for (int x = 0; x < 10; x++) {
            if (x == 5) {
                System.out.println("Break en x = " + x);
                break; // termina el bucle cuando x = 5
            }
        }

        // ============================
        // 9. CONTINUE (salta a la siguiente iteración)
        // ============================
        for (int y = 0; y < 5; y++) {
            if (y == 2) {
                continue; // salta el resto del bucle cuando y = 2
            }
            System.out.println("continue: y = " + y);
        }

        // ============================
        // 10. RETURN (sale del método)
        // ============================
        System.out.println("Probando return:");
        metodoConReturn();
    }

    // Método adicional para probar return
    public static void metodoConReturn() {
        System.out.println("Estoy dentro del método");
        return; // Sale de la función aquí
        // System.out.println("Esto no se ejecutará"); // Esto daría error si está descomentado
        
    }

}
