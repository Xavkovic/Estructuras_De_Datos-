public class MainColaCir {
    public static void main(String[] args) {
        // Creamos una cola circular con espacio para 3 elementos
        ColaEstaticaCircular miCola = new ColaEstaticaCircular(3);

        // Metemos elementos
        miCola.enqueue(10);
        miCola.enqueue(20);
        miCola.enqueue(30);

        // Vemos cómo queda la fila
        miCola.mostrar();

        // Consultamos el frente con peek
        System.out.println("Elemento al frente (peek): " + miCola.peek());

        // Atendemos al primero (sale el 10)
        miCola.dequeue();

        // Ingresamos un nuevo elemento para comprobar el comportamiento circular
        miCola.enqueue(40);

        // Vemos cómo queda la fila
        miCola.mostrar();

        // Consultamos el nuevo frente con peek
        System.out.println("Nuevo elemento al frente (peek): " + miCola.peek());
    }
}