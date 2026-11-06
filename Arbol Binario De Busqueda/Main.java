
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        int opcion = 0;
        boolean mostrarInventario = true; // Controla si el inventario se muestra automáticamente en pantalla

        do {
            // Si el interruptor está activo, mostramos el inventario ordenado antes del menú
            if (mostrarInventario) {
                System.out.println("\n--- INVENTARIO COMPLETO (ORDEN ALFABÉTICO) ---");
                arbol.imprimirInOrder();
                System.out.println("----------------------------------------------");
            }

            System.out.println("\n========================================");
            System.out.println("      SISTEMA DE GESTIÓN DE INVENTARIO  ");
            System.out.println("========================================");
            System.out.println("a) Registrar / Insertar nuevo producto (nombre / cantidad / precio)");
            System.out.println("b) Buscar producto por nombre");
            System.out.println("c) Dar de baja / Eliminar producto");
            System.out.println("d) Mostrar / Ocultar inventario automático (Actual: " + (mostrarInventario ? "VISIBLE" : "OCULTO") + ")");
            System.out.println("e) Salir");
            System.out.print("Seleccione una opción (a-e): ");

            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.isEmpty()) continue;
            char opcionChar = entrada.charAt(0);

            switch (opcionChar) {
                case 'a':
                    System.out.print("Ingrese en formato (nombre / cantidad / precio) [o escriba 'n' para cancelar]: ");
                    String lineaRegistro = scanner.nextLine().trim();

                    // Si el usuario escribe 'n' o 'N', cancelamos la operación
                    if (lineaRegistro.equalsIgnoreCase("n")) {
                        System.out.println("Operación de registro cancelada.");
                        break;
                    }

                    try {
                        String[] partes = lineaRegistro.split("/");
                        if (partes.length == 3) {
                            String nombre = partes[0].trim();
                            int stock = Integer.parseInt(partes[1].trim());
                            double precio = Double.parseDouble(partes[2].trim());

                            arbol.insertar(nombre, stock, precio);
                            System.out.println("¡Producto registrado exitosamente!");
                        } else {
                            System.out.println("Error: Formato incorrecto. Asegúrate de separar con barras (/).");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: La cantidad (stock) debe ser entera y el precio un número válido.");
                    }
                    break;

                case 'b':
                    System.out.print("Ingrese el nombre del producto a buscar (o 'n' para cancelar): ");
                    String nombreBuscar = scanner.nextLine().trim();
                    if (nombreBuscar.equalsIgnoreCase("n")) break;

                    Nodo encontrado = arbol.buscar(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println("\n[¡PRODUCTO ENCONTRADO!]");
                        System.out.println("Nombre: " + encontrado.nombre);
                        System.out.println("Stock:  " + encontrado.stock);
                        System.out.println("Precio: $" + encontrado.precio);
                    } else {
                        System.out.println("El producto '" + nombreBuscar + "' no se encuentra registrado.");
                    }
                    break;

                case 'c':
                    System.out.print("Ingrese el nombre del producto a dar de baja (o 'n' para cancelar): ");
                    String nombreEliminar = scanner.nextLine().trim();
                    if (nombreEliminar.equalsIgnoreCase("n")) break;

                    Nodo verificar = arbol.buscar(nombreEliminar);
                    if (verificar != null) {
                        arbol.eliminar(nombreEliminar);
                        System.out.println("El producto '" + nombreEliminar + "' ha sido dado de baja exitosamente.");
                    } else {
                        System.out.println("Error: No se puede eliminar, el producto no existe.");
                    }
                    break;

                case 'd':
                    // Cambia el estado del interruptor (si estaba true pasa a false y viceversa)
                    mostrarInventario = !mostrarInventario;
                    System.out.println(mostrarInventario ? "-> Inventario automático activado." : "-> Inventario automático ocultado.");
                    break;

                case 'e':
                    System.out.println("Saliendo del sistema de inventario. ¡Hasta luego!");
                    opcion = 5;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija entre 'a' y 'e'.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}