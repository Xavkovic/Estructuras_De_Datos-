public class Nodo {
    String nombre; // Llave alfabética única del producto
    int stock;     // Cantidad disponible en el almacén
    double precio; // Costo unitario del producto
    Nodo izq;      // Apuntador a la rama izquierda (nombres alfabéticamente menores)
    Nodo der;      // Apuntador a la rama derecha (nombres alfabéticamente mayores)

    // Constructor para inicializar el nodo con los datos del producto
    public Nodo(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.izq = null;
        this.der = null;
    }
}