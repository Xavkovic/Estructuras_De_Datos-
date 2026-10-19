public class MainColaDin {
    public static void main(String[] args) {
        ColaDinamica miCola = new ColaDinamica();

        System.out.println("¿La cola está vacía? " + miCola.estaVacia());

        // Encolamos elementos (ahora se imprimirá el mensaje de entrada)
        miCola.encolar(100);
        miCola.encolar(200);
        miCola.encolar(300);

        // Verificamos de nuevo si la cola está vacía tras meter elementos
        System.out.println("¿La cola está vacía ahora? " + miCola.estaVacia());

        // Mostramos la cola
        miCola.mostrar();

        // Probamos los métodos nuevos de análisis
        System.out.println("Número total de elementos: " + miCola.contarElementos());
        System.out.println("Elemento al frente (peek): " + miCola.peek());

        // Desencolamos un elemento
        System.out.println("Desencolado: " + miCola.desencolar());

        // Mostramos el estado actualizado
        miCola.mostrar();
        System.out.println("Nuevo número de elementos: " + miCola.contarElementos());
        System.out.println("Nuevo elemento al frente (peek): " + miCola.peek());
    }
}