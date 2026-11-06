
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArbolBinarioBusqueda {
    private Nodo raiz;

    // Constructor: Carga automáticamente el inventario al arrancar
    public ArbolBinarioBusqueda() {
        this.raiz = null;
        cargarDesdeArchivo();
    }

    // =====================================================================
    // 1. INSERCIÓN: Agrega un nuevo producto respetando la propiedad del ABB
    // =====================================================================
    public void insertar(String nombre, int stock, double precio) {
        this.raiz = insertarRecursivo(this.raiz, nombre, stock, precio);
        guardarEnArchivo(); // Sincroniza automáticamente con el archivo
    }

    private Nodo insertarRecursivo(Nodo actual, String nombre, int stock, double precio) {
        if (actual == null) {
            return new Nodo(nombre, stock, precio);
        }

        int comparacion = nombre.compareTo(actual.nombre);

        if (comparacion < 0) {
            actual.izq = insertarRecursivo(actual.izq, nombre, stock, precio);
        } else if (comparacion > 0) {
            actual.der = insertarRecursivo(actual.der, nombre, stock, precio);
        } else {
            System.out.println("¡Aviso! El producto '" + nombre + "' ya existe en el inventario.");
        }

        return actual;
    }

    // =====================================================================
    // 2. BÚSQUEDA: Utiliza la técnica de "Divide y Vencerás" O(log n)
    // =====================================================================
    public Nodo buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private Nodo buscarRecursivo(Nodo actual, String nombre) {
        if (actual == null) {
            return null; // No encontrado
        }

        int comparacion = nombre.compareTo(actual.nombre);

        if (comparacion == 0) {
            return actual; // ¡Encontrado!
        }

        if (comparacion < 0) {
            return buscarRecursivo(actual.izq, nombre);
        }

        return buscarRecursivo(actual.der, nombre);
    }

    // =====================================================================
    // 3. ELIMINACIÓN: Maneja los 3 casos posibles para dar de baja un producto
    // =====================================================================
    public void eliminar(String nombre) {
        this.raiz = eliminarRecursivo(this.raiz, nombre);
        guardarEnArchivo(); // Actualiza el archivo tras eliminar
    }

    private Nodo eliminarRecursivo(Nodo actual, String nombre) {
        if (actual == null) return null;

        int comparacion = nombre.compareTo(actual.nombre);

        if (comparacion < 0) {
            actual.izq = eliminarRecursivo(actual.izq, nombre);
        } else if (comparacion > 0) {
            actual.der = eliminarRecursivo(actual.der, nombre);
        } else {
            // CASO 1: Es una HOJA (0 hijos)
            if (actual.izq == null && actual.der == null) {
                return null;
            }

            // CASO 2: Tiene EXACTAMENTE 1 HIJO
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            // CASO 3: Tiene 2 HIJOS (Sucesor Inorden: menor de la rama derecha)
            Nodo sucesor = obtenerMinimo(actual.der);

            actual.nombre = sucesor.nombre;
            actual.stock = sucesor.stock;
            actual.precio = sucesor.precio;

            actual.der = eliminarRecursivo(actual.der, sucesor.nombre);
        }

        return actual;
    }

    private Nodo obtenerMinimo(Nodo actual) {
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    // =====================================================================
    // 4. RECORRIDO INORDER: Muestra la lista completa ordenada alfabéticamente
    // =====================================================================
    public void imprimirInOrder() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        imprimirRec(this.raiz);
    }

    private void imprimirRec(Nodo actual) {
        if (actual != null) {
            imprimirRec(actual.izq);
            System.out.println(" - Producto: " + actual.nombre + " | Stock: " + actual.stock + " | Precio: $" + actual.precio);
            imprimirRec(actual.der);
        }
    }

    // =====================================================================
    // PERSISTENCIA DINÁMICA EN ARCHIVO (Ubicación automática según el proyecto)
    // =====================================================================
    private File obtenerArchivo() {
        try {
            File directorio = new File(ArbolBinarioBusqueda.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (directorio.isFile()) {
                directorio = directorio.getParentFile();
            }
            return new File(directorio, "inventario.txt");
        } catch (Exception e) {
            return new File("inventario.txt");
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(obtenerArchivo()))) {
            guardarRec(this.raiz, pw);
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario en el archivo.");
        }
    }

    private void guardarRec(Nodo actual, PrintWriter pw) {
        if (actual != null) {
            guardarRec(actual.izq, pw);
            pw.println(actual.nombre + " / " + actual.stock + " / " + actual.precio);
            guardarRec(actual.der, pw);
        }
    }

    private void cargarDesdeArchivo() {
        File archivo = obtenerArchivo();
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("/");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    int stock = Integer.parseInt(partes[1].trim());
                    double precio = Double.parseDouble(partes[2].trim());
                    this.raiz = insertarRecursivoCarga(this.raiz, nombre, stock, precio);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Aviso: No se pudo leer correctamente el archivo de inventario.");
        }
    }

    private Nodo insertarRecursivoCarga(Nodo actual, String nombre, int stock, double precio) {
        if (actual == null) {
            return new Nodo(nombre, stock, precio);
        }
        int comparacion = nombre.compareTo(actual.nombre);
        if (comparacion < 0) {
            actual.izq = insertarRecursivoCarga(actual.izq, nombre, stock, precio);
        } else if (comparacion > 0) {
            actual.der = insertarRecursivoCarga(actual.der, nombre, stock, precio);
        }
        return actual;
    }
}