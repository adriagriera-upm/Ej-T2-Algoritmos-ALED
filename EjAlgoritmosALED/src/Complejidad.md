# Ejercicios de complejidad

## Ejercicio 3.1

### a)
    
El valor final de la variable `contador` viene dado por:

$$\text{contador} = 0 + 1 + 2 + \dots + (n-1) = \frac{n(n-1)}{2}$$


### b)
Entonces la complejidad será:

$$O(\frac{n^2-n}{2})=O(n^2-n)=O(n^2)$$

## Ejercicio 3.2

### a)

$i=1:$

$$\text{contador} = {[2, 5, 4, 6, 1, 3]}$$

$i=2:$

$$\text{contador} = {[2, 4, 5, 6, 1, 3]}$$



### b)
El código implementa el algoritmo de selection sort, ya que clave es la posición "fija" y datos la móvil dentro de una iteración del bucle for.

### c)
En el mejor caso, es decir, cuando el array esté ordenado, la complejidad será de $O(n)$, ya que el código dentro del while no se ejecutará (se cumple que $datos[j]<clave$).

En cambio, en el peor de los casos, el while se ejecutará hasta que j=0 ya que el array estará ordenado al revés. Por tanto, la complejidad será de $O(n^2)$.

## Ejercicio 3.3

### a y b)

En $i=0$, la variable contador valdrá 1, en $i=1$: $contador= 5 + 4 = 9$. Este comportamiento se puede generalizar a $$\text{contador} = 0 + 1 + 2 + \dots + n = \frac{n(n+1)}{2}$$. Entonces, si $n=5$ $contador=15$.

### c)

$$O(\frac{n^2+n}{2})=O(n^2+n)=O(n^2)$$

## Ejercicio 3.4

### a)
En la primera ejecución $medio=9/2=4$, siendo $arr[4]=16$. Como $16<23$, en la primera recursión los argumentos son $inicio=4+1=5$ $(arr[5]=23)$ y fin inalterado. Como $medio=(5+9)/2=14$ $(arr[7]=56)$ y $56>23$, en la segunda recursión fin se actualiza a $fin=7-1=6$ e inicio sigue constante. En este caso, $medio=(5+6)/2=5$. Como $arr[5]=23$, se ha encontrado la posición del valor buscado.

### b)
Si el array no está ordenado, no se asegura que el valor buscado se encuentre entre los valores límites de inicio y fin. Por tanto, lo más probable es que no se encuentre el valor al cumplirse la condición de $fin<incicio$.

### c)
Ya que para cada recursión el rango de valores en los que se busca un valor se reduce a la mitad, al final el número de ejecuciones es $log_2(n$), siendo n igual a arr.length. Por tanto:

$$O(log(n))$$

## Ejercicio 3.5

### a)
Con $n=10$, el primer bucle for se ejecuta $n=10$ veces y el segundo 4 veces. Entonces $a=10\times4=40$

### b)

La variable j crece exponencialmente siguiendo $j=2^k$, siendo k el número de iteraciones, hasta llegar a n. Por tanto, en la última iteración, $n=2^k$ -> $k=log_2(n)=log_2(10)\approx 4$

### c)

Teniendo en cuenta lo mencionado en los últimos apartados, la complejidad será:

$$O(n \times log_2(n))=O(n \times log(n))$$

## Ejercicio 3.6

### a)

Teniendo en cuenta que intercambiado seguirá manteniéndose false después de la primera iteración y que por tanto esa será la única ejecución del primer bucle for, entonces solo se ejecutará una vez el segundo bucle for. Como este tiene se repite $n-1$ veces, se realizará la ejecución $n-1$ veces.

### b)

Sirve para que, en el caso de que el array esté ordenado, el primer bucle for se ejecute solo una vez. Por tanto, la complejidad para este caso pase de $O(n^2)$ a $O(n)$.

### c)

En el mejor caso, siendo ahora si el array esté ordenado, es como mencionada anteriormente $O(n)$. En cambio, en el peor caso (si el array está completamente desordenado) la complejidad será de $O(n^2)$. La diferencia es la explicada en los anteriores apartados.

## Ejercicio 3.7

Para obtener el recuento de cada nodo, el método de recuento tiene que acceder a cada uno de los nodos (para poder comprobar si este tiene hijos o no). Por tanto el orden de complejidad del método de recuento es de $O(n)$.




