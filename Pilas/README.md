# Sistema de Pilas: Estáticas y Dinámicas (`estructuras_de_datos-/pilas`)

## 1. Lenguaje de Programación Utilizado
* **Java** (Es obligatorio **tener instalado el Java JDK** en tu equipo para poder compilar y ejecutar el programa).

## 2. Requisitos Previos
Asegúrate de tener instalado el Java JDK. Puedes verificarlo abriendo una terminal (CMD o PowerShell) y ejecutando:
```bash
java -version
```

## 3. Estructura y Diferencias Conceptuales
* **Almacenamiento Estático (`PilaSimple.java` - Contiguo en memoria):** 
  Utiliza un arreglo de tamaño fijo predefinido. Los elementos se almacenan en bloques de memoria contiguos, lo que permite un acceso rápido, pero tiene la limitación de un tamaño máximo estricto. Cuenta con controles de desbordamiento (`isFull`) y subdesbordamiento (`isEmpty`).
* **Almacenamiento Dinámico (`PilaDinamica.java` - Nodos enlazados):** 
  No utiliza arreglos ni tiene un límite de capacidad fijo. Se basa en una estructura de nodos independientes conectados mediante referencias (punteros `siguiente`). Crece o decrece en tiempo de ejecución según la memoria RAM disponible, eliminando el riesgo de desbordamiento por tamaño fijo.

## 4. Pasos para Compilar y Ejecutar
Sigue estos pasos en la terminal:

1. Ubícate dentro de la carpeta del proyecto que contiene los archivos fuente:
   ```bash
   cd estructuras_de_datos-/pilas
   ```
2. Compila todos los archivos del paquete (`Estructuras_lineales`):
   ```bash
   javac Estructuras_lineales/*.java
   ```
3. Ejecuta el programa principal (`Main`) desde la raíz del proyecto indicando el paquete completo:
   ```bash
   java Estructuras_lineales.Main
   ```

## 5. Ejemplo de Prueba y Salida por Consola
Al ejecutar el programa, obtendrás la siguiente salida:
```text
=== PILA DINÁMICA ===
¿Está vacía? true
Metiste (dinámico): 10
Metiste (dinámico): 20
Metiste (dinámico): 30
Pila dinámica actual: 30 20 10 
Elemento en la cima (peek): 30
Sacaste (dinámico): 30
Pila dinámica actual: 20 10 

=== PILA SIMPLE (ESTÁTICA) ===
¿La pila simple está vacía? true

--- Insertando elementos (Push) ---
Metiste: 100
Metiste: 200
Metiste: 300
Pila actual: 100 200 300 
Elemento actual en el tope (peek): 300
Metiste: 400
Metiste: 500
¿La pila simple está llena? true
Intentando agregar el 600 (la pila ya está llena):
¡Pila llena!

--- Sacando elementos (Pop) ---
Sacaste: 500
Pila actual: 100 200 300 400 
Nuevo tope después del pop (peek): 400
¿La pila simple está llena ahora? false
```
