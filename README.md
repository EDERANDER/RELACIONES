
# Relaciones

Antes de ver el trabajo te invito a ver mi perfil de GitHub y darle me gusta https://github.com/EDERANDER/
Puedes contactarme en mi Perfil de Linkedin https://www.linkedin.com/in/eder-ander-bravo-531377271/

Este proyecto en Java permite trabajar con matrices binarias para determinar propiedades de relaciones como reflexividad, simetría, transitividad, entre otras. La clase `RelacionesM` incluye métodos para verificar diferentes propiedades y una interfaz para ingresar la matriz desde la consola.

## Funcionalidades

La clase `RelacionesM` proporciona las siguientes funcionalidades:

- **IngresarMatriz**: Permite ingresar una matriz binaria desde la consola.
- **imprimir**: Imprime la matriz proporcionada.
- **reflexiva**: Verifica si la matriz es reflexiva.
- **irreflexiva**: Verifica si la matriz es irreflexiva.
- **simetrica**: Verifica si la matriz es simétrica.
- **asimetrica**: Verifica si la matriz es asimétrica.
- **antisimetrica**: Verifica si la matriz es antisimétrica.
- **esTransitiva**: Verifica si la matriz es transitiva.

## Instalación

Para compilar y ejecutar el programa, sigue estos pasos:

1. Clona el repositorio:

    ```sh
    git clone https://github.com/EDERANDER/RelacionesM.git
    ```

2. O inicia el programa en un compilador online presiona clic el siguiente enlace
   https://onlinegdb.com/Ehbtq9v1hx
## Uso

Al ejecutar el programa, se solicitará ingresar el tamaño de la matriz y los elementos de la matriz binaria. Luego, se mostrarán los resultados de las verificaciones de las propiedades de la matriz ingresada.

### Ejemplo de Uso

```sh
Ingrese tamaño de matriz, ejemplo 2: 3

Matriz de ejemplo, dejando un espacio entre cada numero,
y para cambiar de fila presionar enter
1 0 0
1 1 1
0 1 1

Matriz de 3x3

Ingrese los elementos de la matriz, fila por fila:
0 0 0
0 0 0
0 1 0

No es reflexiva
No es reflexiva porque al menos un elemento de la diagonal principal es 0

La matriz es irreflexiva:
Es irreflexiva porque todos los elementos de la diagonal principal son 0

No es simétrica
No es simétrica porque la matriz no es igual a su transpuesta

No es asimétrica
No es asimétrica porque hay elementos simétricos o no es irreflexiva

Es antisimétrica
Es antisimétrica porque si A[i][j] = 1 y A[j][i] = 1, entonces i == j

No es transitiva
No es transitiva porque hay A[i][j] = 1 y A[j][k] = 1, pero A[i][k] = 0

No es de equivalencia
No es de equivalencia porque no cumple con ser transitiva, reflexiva y simétrica simultáneamente
