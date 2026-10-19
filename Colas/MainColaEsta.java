public class MainColaEsta {
    public static void main(String[] args) {
        // Creamos una cola con espacio para 3 personas/elementos
        ColaEstatica miCola = new ColaEstatica(3);

        // Metemos elementos
        miCola.enqueue(10);
        miCola.enqueue(20);
        miCola.enqueue(30);

        // Vemos cómo queda la fila
        miCola.mostrar();

        // Consultamos el frente con peek
        System.out.println("Elemento al frente (peek): " + miCola.peek());

        // Atendemos al primero
        miCola.dequeue();

        // Vemos cómo queda la fila despues de atender
        miCola.mostrar();

        // Consultamos el nuevo frente con peek
        System.out.println("Nuevo elemento al frente (peek): " + miCola.peek());
    }
}