# Sistema De Estructuras De Colas (Estática, Circular, Dinamica)

## 1. Lenguaje de Programación Utilizado
- **Java** (Es obligatorio **tener instalado el Java JDK** en tu equipo para poder compilar y ejecutar el programa).

## 2. Requisitos Previos
Asegúrate de tener instalado el Java JDK. Puedes verificarlo abriendo una terminal (CMD o PowerShell) y ejecutando:
```bash
java -version
```

## 3. Pasos para Compilar y Ejecutar
Sigue estos pasos en la terminal:

1. Ubícate dentro de la carpeta que contiene los archivos fuente:
   ```bash
   cd /Colas
   ```
2. Compila todos los archivos del proyecto:
   ```bash
   javac *.java
   ```
3. Ejecuta el programa principal con su respectivo paquete:
   ```bash
   java MainColaEsta
   java MainColaCir
   java MainColaDin
   ```

## 4. Ejemplo de Prueba y Salida por Consola
Al ejecutar el programa, obtendrás la siguiente salida:
```text
  D:\Estructuras De Datos\Colas>java MainColaEsta
Entró a la fila: 10
Entró a la fila: 20
Entró a la fila: 30
Fila actual: 10 20 30
Elemento al frente (peek): 10
Atendido y fuera: 10
Fila actual: 20 30
Nuevo elemento al frente (peek): 20

D:\Estructuras De Datos\Colas>java MainColaCir
Entró a la fila: 10
Entró a la fila: 20
Entró a la fila: 30
Fila actual: 10 20 30
Elemento al frente (peek): 10
Atendido y fuera: 10
Entró a la fila: 40
Fila actual: 20 30 40
Nuevo elemento al frente (peek): 20

D:\Estructuras De Datos\Colas>java MainColaDin
¿La cola está vacía? true
Entró a la fila: 100
Entró a la fila: 200
Entró a la fila: 300
¿La cola está vacía ahora? false
Frente -> [100] [200] [300] <- Fin
Número total de elementos: 3
Elemento al frente (peek): 100
Desencolado: 100
Frente -> [200] [300] <- Fin
Nuevo número de elementos: 2
Nuevo elemento al frente (peek): 200

## 5. Desarrollador
**By:** Xavier Adair Gutierrez Rivera
