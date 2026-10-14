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