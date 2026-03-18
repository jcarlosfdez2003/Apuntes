package apuntes;


/**
 * REPASO POO: CLASES, OBJETOS Y ENCAPSULAMIENTO
 * * CLASE: Es el molde o plantilla (ej. Coche, Usuario, Animal).
 * OBJETO: Es la instancia real creada a partir del molde (ej. miCoche, usuarioJuan).
 */
public class objetos {

    // ATRIBUTOS (Estado del objeto)
    // Se suelen poner 'private' para que no se modifiquen desde fuera (Encapsulamiento).
    private String nombre;
    private int nota;

    /**
     * CONSTRUCTOR
     * Método especial que se llama al usar 'new'. 
     * Sirve para inicializar el objeto y darle sus valores iniciales.
     */
    public objetos(String nombre, int nota) {
        this.nombre = nombre; // 'this' diferencia el atributo de la clase del parámetro
        this.nota = nota;
    }

    /**
     * GETTERS (Obtener)
     * Permiten leer el valor de un atributo privado desde fuera de la clase.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SETTERS (Establecer/Modificar)
     * Permiten cambiar el valor de un atributo privado de forma controlada.
     * Aquí es donde se puede validar la información.
     */
    public void setNota(int nuevaNota) {
        if (nuevaNota >= 0 && nuevaNota <= 10) {
            this.nota = nuevaNota;
        } else {
            System.out.println("Error: Nota no válida.");
        }
    }

    /**
     * MÉTODOS (Comportamiento)
     * Acciones que el objeto puede realizar.
     */
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " | Nota: " + nota);
    }

    // --- EJEMPLO DE USO ---
    public static void main(String[] args) {
        // INSTANCIAR: Crear un objeto a partir de la clase usando 'new'
        objetos alumno1 = new objetos("Carlos", 8);

        // Uso de GETTER
        System.out.println("Nombre del alumno: " + alumno1.getNombre());

        // Uso de SETTER
        alumno1.setNota(9); 
        
        // Uso de MÉTODO
        alumno1.mostrarInfo();
    }
}

