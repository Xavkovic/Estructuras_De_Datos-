package Estructuras_lineales;

public class Main {
    public static void main(String[] args) {
        // ==========================================
        // PRUEBAS PARA PILA DINÁMICA (PilaDinamica)
        // ==========================================
        System.out.println("=== PILA DINÁMICA ===");
        PilaDinamica miPilaDinamica = new PilaDinamica();

        System.out.println("¿Está vacía? " + miPilaDinamica.isEmpty());

        miPilaDinamica.push(10);
        miPilaDinamica.push(20);
        miPilaDinamica.push(30);

        miPilaDinamica.mostrar();
        System.out.println("Elemento en la cima (peek): " + miPilaDinamica.peek());

        miPilaDinamica.pop();
        miPilaDinamica.mostrar();


        // ==========================================
        // PRUEBAS PARA PILA SIMPLE (Pila estática)
        // ==========================================
        System.out.println("\n=== PILA SIMPLE (ESTÁTICA) ===");
        PilaSimple miPilaSimple = new PilaSimple();

        // 1. Probar isEmpty() inicial
        System.out.println("¿La pila simple está vacía? " + miPilaSimple.isEmpty());

        // 2. Probar push() y isFull()
        System.out.println("\n--- Insertando elementos (Push) ---");
        miPilaSimple.push(100);
        miPilaSimple.push(200);
        miPilaSimple.push(300);

        // 3. Probar mostrar()
        miPilaSimple.mostrar();

        // 4. Probar peek() (consultar el tope)
        System.out.println("Elemento actual en el tope (peek): " + miPilaSimple.peek());

        // 5. Llenar la pila por completo (capacidad fija de 5 definida en PilaSimple)
        miPilaSimple.push(400);
        miPilaSimple.push(500);

        // Comprobar si está llena con isFull()
        System.out.println("¿La pila simple está llena? " + miPilaSimple.isFull());

        // Intentar meter un elemento extra para ver el control de desbordamiento
        miPilaSimple.push(600);

        // 6. Probar pop() (sacar elemento)
        System.out.println("\n--- Sacando elementos (Pop) ---");
        miPilaSimple.pop();
        miPilaSimple.mostrar();

        System.out.println("Nuevo tope después del pop (peek): " + miPilaSimple.peek());
        System.out.println("¿La pila simple está llena ahora? " + miPilaSimple.isFull());
    }
}