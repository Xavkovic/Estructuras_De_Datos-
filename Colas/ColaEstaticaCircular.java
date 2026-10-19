public class ColaEstaticaCircular {
    private int[] arreglo;
    private int frente;
    private int fin;
    private int capacidad;
    private int tamano;

    // El constructor recibe el tamaño estático al momento de crear el objeto
    public ColaEstaticaCircular(int tamano) {
        this.capacidad = tamano;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamano = 0; // Arranca en cero porque la cola empieza vacía
    }

    public void enqueue(int valor) { // Agregar un elemento al final de la cola
        if (tamano == capacidad) { // Cuando la fila está llena
            System.out.println("Error: La cola está llena.");
        } else {
            fin = (fin + 1) % capacidad; // Actualizamos fin de forma circular
            arreglo[fin] = valor; // Agregamos al arreglo
            tamano++;
            System.out.println("Entró a la fila: " + valor);
        }
    }

    public int dequeue() { // Saca al primero de la fila
        if (tamano == 0) { // Si el tamaño es 0, la fila está vacía
            System.out.println("Error: La cola está vacía.");
            return -1;
        } else {
            int atendido = arreglo[frente];
            System.out.println("Atendido y fuera: " + atendido);
            frente = (frente + 1) % capacidad; // Actualiza frente de forma circular
            tamano--;
            return atendido;
        }
    }

    // Método peek para consultar el elemento al frente sin extraerlo
    public int peek() {
        if (tamano == 0) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }

    public void mostrar() {
        if (tamano == 0) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Fila actual: ");
        int indice = frente;
        for (int i = 0; i < tamano; i++) {
            System.out.print(arreglo[indice] + " ");
            indice = (indice + 1) % capacidad; // Recorrido circular
        }
        System.out.println();
    }
}