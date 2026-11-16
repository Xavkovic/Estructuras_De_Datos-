//BY XAVIER
public class Mainburbuja {

    public static void main(String[] args) {
        // Usamos nuestro arreglo de ejemplo de clase
        int[] arreglo = {6, 1, 5, 8, 3, 2, 7, 4, 9, 17, 10, 15, 11, 80,11};

        System.out.println("Arreglo original:");
        Burbuja.imprimirArreglo(arreglo);

        // Llamamos al método de ordenamiento
        Burbuja.ordenar(arreglo);

        System.out.println("Arreglo ordenado:");
        Burbuja.imprimirArreglo(arreglo);
    }
}