public class ColaEstatica {
    private int[] arreglo;
    private int frente;
    private int fin;
    private int capacidad;

    // El constructor recibe el tamaño estático al momento de crear el objeto, en este caso=3
    public ColaEstatica(int tamano) {
        this.capacidad = tamano;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;
        this.fin = -1;
    }

    public void enqueue(int valor) { // agregar un elemento al final de la cola
        if (fin == capacidad - 1) { // cuando la fila esta llena
            System.out.println("Error: La cola está llena.");
        } else {
            fin++; // actualizamos la fila
            arreglo[fin] = valor; // agregamos al arreglo
            System.out.println("Entró a la fila: " + valor); // imprimimos
        }
    }

    public int dequeue() { // saca al primero de la fila
        if (frente > fin) { // si frente llega a ser mayor que fin la fila se vacia.
            System.out.println("Error: La cola está vacía.");
            return -1;
        }
        int atendido = arreglo[frente];
        System.out.println("Atendido y fuera: " + atendido); // atiende e imprime
        frente++; // actualiza frente cuando se atiende un elemento de la fila.
        return atendido;
    }

    // Método peek para consultar el elemento al frente de la fila sin extraerlo
    public int peek() {
        if (frente > fin) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }

    public void mostrar() {
        if (frente > fin) {
            System.out.println("La cola está vacía.");
            return; // ya no hace nada de lo de abajo
        }
        System.out.print("Fila actual: ");
        for (int i = frente; i <= fin; i++) { // DESDE EL INICIO DE LA FILA HASTA EL FINAL
            System.out.print(arreglo[i] + " "); // IMPRIMIMOS EL ARREGLO
        }
        System.out.println();
    }
}