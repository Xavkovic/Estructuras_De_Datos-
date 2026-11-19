import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Path;

public class IntercaladorBloques {

    /**
     * Compara e intercala bloques ordenados de tamano L provenientes de dos
     * archivos auxiliares (F1 y F2) hacia un archivo de salida.
     */
    public void intercalarBloques(Path archivoF1, Path archivoF2,
                                  Path archivoSalida, int L) {

        try (
                BufferedReader lector1 = new BufferedReader(new FileReader(archivoF1.toFile()));
                BufferedReader lector2 = new BufferedReader(new FileReader(archivoF2.toFile()));
                PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida.toFile()))
        ) {
            String linea1 = lector1.readLine();
            String linea2 = lector2.readLine();

            int elementosEscritos1 = 0;
            int elementosEscritos2 = 0;

            while (linea1 != null && linea2 != null) {

                if (elementosEscritos1 >= L && elementosEscritos2 >= L) {
                    elementosEscritos1 = 0;
                    elementosEscritos2 = 0;
                }

                // CASO 1: Quedan elementos por comparar en AMBOS bloques de tamano L
                if (elementosEscritos1 < L && elementosEscritos2 < L) {
                    int val1 = Integer.parseInt(linea1.trim());
                    int val2 = Integer.parseInt(linea2.trim());

                    // TODO 1: El numero de F1 es menor o igual al de F2
                    if (val1 <= val2) {
                        escritor.println(val1);
                        linea1 = lector1.readLine();
                        elementosEscritos1++;
                    } else {
                        // TODO 2: Si el menor fue el de F2
                        escritor.println(val2);
                        linea2 = lector2.readLine();
                        elementosEscritos2++;
                    }
                }
                // CASO 2: El bloque de F2 llego a L; vaciamos lo que resta del bloque de F1
                else if (elementosEscritos1 < L) {
                    escritor.println(linea1.trim());
                    linea1 = lector1.readLine();
                    elementosEscritos1++;
                }
                // CASO 3: El bloque de F1 llego a L; vaciamos lo que resta del bloque de F2
                else {
                    // TODO 3: Vaciar el elemento restante del bloque actual de F2
                    escritor.println(linea2.trim());
                    linea2 = lector2.readLine();
                    elementosEscritos2++;
                }
            }

            while (linea1 != null) {
                escritor.println(linea1.trim());
                linea1 = lector1.readLine();
            }

            while (linea2 != null) {
                escritor.println(linea2.trim());
                linea2 = lector2.readLine();
            }

            System.out.println("Bloques intercalados con exito en: " + archivoSalida.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error en E/S de archivos: " + e.getMessage());
        }
    }

    /**
     * Deja el archivo indicado vacio (con 0 elementos/lineas).
     */
    public void vaciarArchivo(Path archivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivo.toFile(), false))) {
            System.out.println(archivo.getFileName() + " vaciado (0 elementos).");
        } catch (IOException e) {
            System.out.println("Error al vaciar " + archivo.getFileName() + ": " + e.getMessage());
        }
    }
}