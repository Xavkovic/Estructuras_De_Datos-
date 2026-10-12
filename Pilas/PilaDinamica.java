package Estructuras_lineales;

public class PilaDinamica {
    Nodo cima; // Apunta al nodo superior de la pila

    public PilaDinamica() {
        this.cima = null;
    }

    // Insertar un nodo en la cima
    void push(int x) {
        Nodo nuevo = new Nodo(x);
        nuevo.siguiente = cima;
        cima = nuevo;
        System.out.println("Metiste (dinámico): " + x);
    }

    // Extraer el nodo de la cima
    void pop() {
        if (!isEmpty()) {
            System.out.println("Sacaste (dinámico): " + cima.dato);
            cima = cima.siguiente;
        } else {
            System.out.println("¡Pila vacía!");
        }
    }

    // Recorrer e imprimir los elementos
    void mostrar() {
        Nodo actual = cima;
        System.out.print("Pila dinámica actual: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // --- MÉTODOS SOLICITADOS ---

    // Verificar si la cima no contiene nodos (cima == null)
    boolean isEmpty() {
        return cima == null;
    }

    // Consultar el valor en la cima sin desvincular el nodo
    int peek() {
        if (!isEmpty()) {
            return cima.dato;
        } else {
            System.out.println("¡Pila vacía! No hay elementos.");
            return -1;
        }
    }
}