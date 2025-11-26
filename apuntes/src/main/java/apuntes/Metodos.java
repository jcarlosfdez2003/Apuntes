package apuntes;

public class Metodos {
    // Ejemplo completo con varios métodos / formas de usarlos

    // Método estático que no devuelve nada (acción simple)
    public static void mostrarSaludo() {
        System.out.println("¡Hola, mundo!");
    }

    // Método estático que devuelve un int (suma)
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Sobrecarga: otro método sumar, con 3 parámetros
    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método de instancia: pertenece a un objeto
    public String saludar(String nombre) {
        return "¡Hola, " + nombre + "!";
    }

    // Sobrecarga de método de instancia: sin parámetros
    public String saludar() {
        return "¡Hola!";
    }

    // Ejemplo método con diferente tipo de retorno
    public double multiplicar(double x, double y) {
        return x * y;
    }

    public static void main(String[] args) {
        // Llamadas a métodos estáticos
        mostrarSaludo();
        int res1 = sumar(5, 3);
        System.out.println("5 + 3 = " + res1);
        int res2 = sumar(2, 4, 6);
        System.out.println("2 + 4 + 6 = " + res2);

        // Llamadas a métodos de instancia
        Metodos obj = new Metodos();
        String saludo1 = obj.saludar("Ana");
        System.out.println(saludo1);
        String saludo2 = obj.saludar();
        System.out.println(saludo2);

        double prod = obj.multiplicar(2.5, 4.0);
        System.out.println("2.5 * 4.0 = " + prod);
    }
}
