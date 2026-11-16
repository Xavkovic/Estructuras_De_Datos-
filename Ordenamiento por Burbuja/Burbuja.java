
/**
 * Clase que implementa el algoritmo de ordenamiento interno burbuja.
 * Incluye la optimización con bandera para lograr complejidad O(n) en el mejor caso.
 */
public class Burbuja {

    /**
     * Ordena un arreglo de enteros de forma ascendente mediante comparaciones adyacentes.
     * @param arr Arreglo de enteros a ordenar.
     */
    public static void ordenar(int[] arr) {
        int n = arr.length;
        boolean intercambiado; // Bandera para detectar si hubo cambios en la pasada actual

        // Bucle externo: controla las pasadas necesarias a través del arreglo.
        // En cada pasada 'i', el elemento más grande restante "flota" hacia su posición final a la derecha.
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false; // Reiniciamos la bandera al inicio de cada pasada

            // Bucle interno: compara elementos adyacentes.
            // Se resta 'i' porque los últimos 'i' elementos ya están ordenados de pasadas anteriores.
            for (int j = 0; j < n - i - 1; j++) {

                // Si el elemento actual es mayor que el siguiente, están desordenados.
                if (arr[j] > arr[j + 1]) {
                    // Intercambio (Swap clásico usando una variable temporal)
                    int temp = arr[j]; // temp ayuda a no perder el número.
                    arr[j] = arr[j + 1]; // igualamos los números o lugares.
                    arr[j + 1] = temp; // recuperamos el número.

                    // Marcamos que sí hubo un intercambio en esta pasada.
                    intercambiado = true;
                }
            }

            // OPTIMIZACIÓN: Si terminamos la pasada y la bandera sigue en falso,
            // significa que el arreglo ya está completamente ordenado y nos ahorramos ciclos innecesarios.
            if (!intercambiado) { // Si intercambiado es falso, si no hubo movimiento.
                break; // rompemos el ciclo
            }
        }
    }

    /**
     * Método auxiliar para imprimir los elementos de un arreglo en formato de consola.
     * @param arr Arreglo a imprimir.
     */
    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
//BY XAVIER