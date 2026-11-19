import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    /**
     * Obtiene el directorio exacto donde esta ubicado Main.
     */
    private static Path obtenerDirectorioMain() {
        try {
            Path ubicacion = Paths.get(Main.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI());
            return ubicacion.toFile().isDirectory()
                    ? ubicacion
                    : ubicacion.getParent();
        } catch (URISyntaxException | NullPointerException e) {
            return Paths.get("").toAbsolutePath();
        }
    }

    private static void asegurarArchivosBase(Path archivoF1, Path archivoF2) {
        if (!archivoF1.toFile().exists()) {
            try (PrintWriter out1 = new PrintWriter(new FileWriter(archivoF1.toFile()))) {
                out1.println(45);
            } catch (IOException e) {
                System.out.println("Error al crear f1.txt: " + e.getMessage());
            }
        }
        if (!archivoF2.toFile().exists()) {
            try (PrintWriter out2 = new PrintWriter(new FileWriter(archivoF2.toFile()))) {
                out2.println(12);
            } catch (IOException e) {
                System.out.println("Error al crear f2.txt: " + e.getMessage());
            }
        }
    }

    private static void imprimirArchivoEnConsola(Path archivo) {
        System.out.println("\n--- Contenido actual de " + archivo.getFileName() + " ---");
        int numeroLinea = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo.toFile()))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                System.out.println(numeroLinea + ": " + linea);
            }
            if (numeroLinea == 0) {
                System.out.println("(vacio - 0 elementos)");
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer " + archivo.getFileName() + ": " + e.getMessage());
        }
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Path directorioMain = obtenerDirectorioMain();
        Path archivoF1 = directorioMain.resolve("f1.txt");
        Path archivoF2 = directorioMain.resolve("f2.txt");
        Path archivoSalida = directorioMain.resolve("f3.txt");
        int tamanoBloque = 1;

        System.out.println("Directorio de Main: " + directorioMain.toAbsolutePath());

        asegurarArchivosBase(archivoF1, archivoF2);

        IntercaladorBloques intercalador = new IntercaladorBloques();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENU MEZCLA DIRECTA ===");
            System.out.println("1. Intercalar bloques (f1 y f2 -> f3)");
            System.out.println("2. Vaciar f3.txt (dejarlo en 0 elementos)");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingresa un numero valido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    intercalador.intercalarBloques(archivoF1, archivoF2, archivoSalida, tamanoBloque);
                    imprimirArchivoEnConsola(archivoSalida);
                    break;
                case 2:
                    intercalador.vaciarArchivo(archivoSalida);
                    imprimirArchivoEnConsola(archivoSalida);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}