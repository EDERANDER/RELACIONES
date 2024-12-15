
/*
 * esta libreria en si no es ilegal usarla
 * porque simplemente le dices al programa que tipo de datos esperas
 * es decir por ejemplo si declaramos un 
 * int variable1 = f;
 * el compilador botara el siguiente error
 * incompatible types: char cannot be converted to int
 * entonces nosotros compiamos ese error y lo ponemos en un try catch
 * y para eso usamos la libreria InputMismatchException que sirve cuando el tipo de 
 * dato no es el esperado
 */

import java.util.InputMismatchException;

import java.util.Scanner;

/**
 * Clase RelacionesM
 * 
 * Esta clase permite trabajar con matrices binarias para determinar propiedades
 * de relaciones como reflexividad, simetría, transitividad, entre otras. Se
 * incluyen métodos para verificar diferentes propiedades y una interfaz para
 * ingresar la matriz desde la consola.
 */
public class RelacionesM {
    static Scanner sc = new Scanner(System.in);

    /**
     * Método para ingresar una matriz desde la consola.
     * 
     * @return Una matriz binaria (int[][]) ingresada por el usuario.
     */
    public int[][] IngresarMatriz() {
        int tamanio = 0;

        try {
            System.out.print("Ingrese tamaño de matriz, ejemplo 2: ");
            tamanio = sc.nextInt();
            if (tamanio <= 1) {
                System.out.println("El tamaño de la matriz debe ser mayor a 1");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Solo se permiten números enteros para el tamaño de la matriz.");
            System.exit(0);
        }

        String matri = """



                                    Matriz de ejemplo, dejando un espacio entre cada numero,
                                    y para cambiar de fila presionar enter
                                    1 0 0
                                    1 1 1
                                    0 1 1
                """;
        System.out.println(matri);
        System.out.println();
        System.out.println("Matriz de " + tamanio + "x" + tamanio);

        int[][] matriz = new int[tamanio][tamanio];

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                try {
                    int valor = sc.nextInt();
                    if (valor != 0 && valor != 1) {
                        System.out.println("Error: Solo se permiten valores de 0 y 1.");
                        System.exit(0);
                    }
                    matriz[i][j] = valor;
                } catch (InputMismatchException e) {
                    System.out.println(
                            "Error: Solo se permiten números enteros (0 o 1) para los elementos de la matriz.");
                    System.exit(0);
                }
            }
        }
        return matriz;
    }

    /**
     * Método para imprimir una matriz.
     * 
     * @param matriz La matriz que se desea imprimir.
     */
    public void imprimir(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    /**
     * Verifica si una matriz es reflexiva.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es reflexiva, false en caso contrario.
     */
    public boolean reflexiva(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si una matriz es irreflexiva.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es irreflexiva, false en caso contrario.
     */
    public boolean irreflexiva(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si una matriz es simétrica.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es simétrica, false en caso contrario.
     */
    public boolean simetrica(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si una matriz es asimétrica.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es asimétrica, false en caso contrario.
     */
    public boolean asimetrica(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != j && matriz[i][j] == matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si una matriz es antisimétrica.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es antisimétrica, false en caso contrario.
     */
    public boolean antisimetrica(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != j && matriz[i][j] == 1 && matriz[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si una matriz es transitiva.
     * 
     * @param matriz La matriz a verificar.
     * @return true si es transitiva, false en caso contrario.
     */
    public static boolean esTransitiva(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (matriz[j][k] == 1 && matriz[i][k] == 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Método principal para ejecutar el programa.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        RelacionesM m = new RelacionesM();
        int[][] matriz = m.IngresarMatriz();

        if (m.reflexiva(matriz)) {
            System.out.println("La matriz es reflexiva: ");
            System.out.println("Es reflexiva porque toda la diagonal principal es 1");
        } else {
            System.out.println("No es reflexiva");
            System.out.println("No es reflexiva porque al menos un elemento de la diagonal principal es 0");
        }

        System.out.println();
        if (m.irreflexiva(matriz)) {
            System.out.println("La matriz es irreflexiva: ");
            System.out.println("Es irreflexiva porque todos los elementos de la diagonal principal son 0");
        } else {
            System.out.println("No es irreflexiva");
            System.out.println("No es irreflexiva porque al menos un elemento de la diagonal principal es 1");
        }

        System.out.println();
        if (m.simetrica(matriz)) {
            System.out.println("Es simétrica");
            System.out.println("Es simétrica porque la matriz es igual a su transpuesta");
            m.imprimir(matriz);
        } else {
            System.out.println("No es simétrica");
            System.out.println("No es simétrica porque la matriz no es igual a su transpuesta");
            m.imprimir(matriz);
        }

        System.out.println();
        if (m.asimetrica(matriz) && m.irreflexiva(matriz)) {
            System.out.println("Es asimétrica");
            System.out.println("Es asimétrica porque no hay elementos simétricos y es irreflexiva");
        } else {
            System.out.println("No es asimétrica");
            System.out.println("No es asimétrica porque hay elementos simétricos o no es irreflexiva");
        }

        System.out.println();
        if (m.antisimetrica(matriz)) {
            System.out.println("Es antisimétrica");
            System.out.println("Es antisimétrica porque si A[i][j] = 1 y A[j][i] = 1, entonces i == j");
        } else {
            System.out.println("No es antisimétrica");
            System.out.println("No es antisimétrica porque hay elementos A[i][j] = 1 y A[j][i] = 1 con i != j");
        }

        System.out.println();
        if (m.esTransitiva(matriz)) {
            System.out.println("Es transitiva");
            System.out.println("Es transitiva porque si A[i][j] = 1 y A[j][k] = 1, entonces A[i][k] = 1");
        } else {
            System.out.println("No es transitiva");
            System.out.println("No es transitiva porque hay A[i][j] = 1 y A[j][k] = 1, pero A[i][k] = 0");
        }

        System.out.println();
        if (m.esTransitiva(matriz) && m.reflexiva(matriz) && m.simetrica(matriz)) {
            System.out.println("Es de equivalencia");
            System.out.println("Es de equivalencia porque es transitiva, reflexiva y simétrica");
        } else {
            System.out.println("No es de equivalencia");
            System.out.println(
                    "No es de equivalencia porque no cumple con ser transitiva, reflexiva y simétrica simultáneamente");
        }
    }
}
