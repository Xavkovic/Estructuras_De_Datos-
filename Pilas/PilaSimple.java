package Estructuras_lineales;

public class PilaSimple {
    int[] datos = new int[5]; // Capacidad fija de 5
    int tope = -1;            // Empieza vacía

    // 1. Meter dato (Push) // Llenar la pila
    void push(int x) {
        if (!isFull()) {
            tope++;
            datos[tope] = x;
            System.out.println("Metiste: " + x);
        } else {
            System.out.println("¡Pila llena!");
        }
    }

    // 2. Sacar dato (Pop)
    void pop() {
        if (!isEmpty()) {
            System.out.println("Sacaste: " + datos[tope]);
            tope--;
        } else {
            System.out.println("¡Pila vacía!");
        }
    }

    // Ver la pila
    void mostrar() {
        System.out.print("Pila actual: ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }

    // --- MÉTODOS SOLICITADOS ---

    // Verificar si la pila está vacía (tope == -1)
    boolean isEmpty() {
        return tope == -1;
    }

    // Verificar si el arreglo alcanzó su límite
    boolean isFull() {
        return tope == datos.length - 1;
    }

    // Consultar el elemento en el tope sin eliminarlo
    int peek() {
        if (!isEmpty()) {
            return datos[tope];
        } else {
            System.out.println("¡Pila vacía! No hay elementos.");
            return -1; // Valor de control
        }
    }
}